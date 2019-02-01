package com.microcore.center.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.microcore.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.microcore.api.model.DbDbKit;
import com.microcore.center.client.DbKitTemplate;
import com.microcore.center.dto.DbConnectionDto;
import com.microcore.center.dto.DbFieldCnfDto;
import com.microcore.center.dto.DbTableCnfDto;
import com.microcore.center.mapper.DbConnectionMapper;
import com.microcore.center.mapper.DbFieldCnfMapper;
import com.microcore.center.mapper.DbTableCnfMapper;
import com.microcore.center.model.DbColumnComment;
import com.microcore.center.model.DbConnection;
import com.microcore.center.model.DbConnectionExample;
import com.microcore.center.model.DbFieldCnf;
import com.microcore.center.model.DbFieldCnfExample;
import com.microcore.center.model.DbTableCnf;
import com.microcore.center.model.DbTableCnfExample;
import com.microcore.center.model.DbTableCnfExample.Criteria;
import com.microcore.center.service.DbColumnCommentService;
import com.microcore.center.service.DbConnectionService;
import com.microcore.center.service.DbDbKitService;
import com.microcore.center.service.DbFieldCnfService;
import com.microcore.center.service.DbTableCnfService;
import com.microcore.center.task.AsyncTask;
import com.microcore.common.constant.Constants;
import com.microcore.common.exception.CommonException;
import com.microcore.common.jdbc.JdbcUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源管理
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class DbConnectionServiceImpl implements DbConnectionService {

    @Autowired
    private DbConnectionMapper dbConnectionMapper;

    @Autowired
    private DbTableCnfMapper dbTableCnfMapper;

    @Autowired
    private DbFieldCnfMapper dbFieldCnfMapper;

    @Autowired
    private DbTableCnfService dbTableCnfService;

    @Autowired
    private DbFieldCnfService dbFieldCnfService;

    @Autowired
    private DbKitTemplate dbKitTemplate;

    @Autowired
    private DbColumnCommentService dbColumnCommentService;

    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private DbDbKitService dbDbKitService;

    @Override
    public ResultVo addDbConnection(DbConnectionDto dbConnection) {
        // 插入数据到db_connection表
        // connection_name和database_name合并成一个，两个数据一样 以database_name为主
        String conId = CommonUtil.getUUID();
        dbConnection.setId(conId);
        // 无用字段
        dbConnection.setType("--");
        String versionName = dbConnection.getVersionName();
        String ip = dbConnection.getIp().trim();
        String port = dbConnection.getPort().trim();
        String dbType = JdbcUtil.judgeDbType(versionName);
        String databaseName = dbConnection.getDataBaseName().trim();
        String url = JdbcUtil.generateUrl(dbType, ip, port, databaseName);
        dbConnection.setUrl(url);
        String password = dbConnection.getPassword();
        try {
            password = DESUtil.decryptor(password);
        } catch (Exception e) {
            log.warn("密码异常[{}]", e.getMessage());
            return ResultVo.fail("密码异常");
        }
        password = PasswordUtil.encrypt(password);
        dbConnection.setPassword(password);

        String crtOrgId = UserUtil.getOrgId();
        // 暂时不使用的字段
        dbConnection.setConnectionName("--");
        // 设置下发状态，保存时就下发
        dbConnection.setStatus("YES");
        dbConnection.setDelStatus("NOR");

        String userId = UserUtil.getUserId();
        Date date = CommonUtil.getCurrentTime();
        dbConnection.setUpdUserId(userId);
        dbConnection.setUpdOrgId(crtOrgId);
        dbConnection.setUpdTm(date);
        dbConnection.setCrtUserId(userId);
        dbConnection.setCrtOrgId(crtOrgId);
        dbConnection.setCrtTm(date);

        int insert = dbConnectionMapper.insert(dbConnection);
        String kitId = dbConnection.getKitId();
        if (StringUtil.isEmpty(kitId)) {
            String orgId = dbConnection.getOrgId();
            DbDbKit dbKit = dbDbKitService.getDbKitByOrgId(orgId);
            dbConnection.setKitId(dbKit.getId());
        }
        dbKitTemplate.saveDbConnection(dbConnection);
	    if (insert != 0) {
		    return ResultVo.ok("中心成功添加数据("+insert+")条");
	    }
        return ResultVo.fail("中心添加失败");
    }

    /**
     * 获取当前机构下的所有数据库连接
     */
    @Override
    public ResultVo<List<DbConnectionDto>> getDbConnections(String type) {
        List<DbConnection> list = getConnectionByOrgId(UserUtil.getOrgId());
        if (CommonUtil.isEmpty(list)) {
            return ResultVo.ok(new ArrayList<>());
        }

        DbDbKit dbKit = dbDbKitService.getCurrentUsersDbKit();
        List<DbConnection> connections = list.stream()
                .filter(x -> !CommonUtil.orEquals(x.getUrl(), dbKit.getMakeUrl(), dbKit.getDistillUrl()))
                .collect(Collectors.toList());

        List<DbConnectionDto> connectionList = CommonUtil.listPo2VO(connections, DbConnectionDto.class);
        // tableDto 此处不用设置
        connectionList.forEach(dto -> dto.setDatabaseType(dto.getVersionName()));

        return ResultVo.ok(connectionList);
    }

    @Override
    public ResultVo getOrgDbConnections(String type, String orgId) {
        List<DbConnection> list = getConnectionByOrgId(orgId);
        if (CommonUtil.isEmpty(list)) {
            return ResultVo.ok(new ArrayList<>());
        }
        DbDbKit dbKit = dbDbKitService.getDbKitByOrgId(orgId);
        List<DbConnection> connections = list.stream()
                .filter(x -> !CommonUtil.orEquals(x.getUrl(), dbKit.getMakeUrl(), dbKit.getDistillUrl()))
                .collect(Collectors.toList());
        List<DbConnectionDto> connectionList = CommonUtil.listPo2VO(connections, DbConnectionDto.class);
        connectionList.forEach(dto -> dto.setDatabaseType(dto.getVersionName()));
        return ResultVo.ok(connectionList);
    }

    private List<DbConnection> getConnectionByOrgId(String orgId) {
        DbConnectionExample example = new DbConnectionExample();
        DbConnectionExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
        return dbConnectionMapper.selectByExample(example);
    }

    /**
     * 分页查询数据库连接
     */
    @Override
    public PageInfo<DbConnection> getDbConnectionList(String type, Integer pageIndex, Integer pageSize) {
        DbConnectionExample example = new DbConnectionExample();
        DbConnectionExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        criteria.andOrgIdEqualTo(UserUtil.getOrgId());
        criteria.andDelStatusEqualTo(Constants.DEL_STATUS_NOR);
        return PageHelper.startPage(pageIndex, pageSize).
                doSelectPageInfo(() -> dbConnectionMapper.selectByExample(example));
    }

    /**
     * 获取某个数据库连接下的表格和字段信息
     */
    @Override
    public ResultVo<DbConnectionDto> getConnectionTree(String conId) {
        DbConnection dbConnection = getDbConnectionById(conId);
        if (dbConnection == null) {
            return ResultVo.fail("查询不到这个连接");
        }

        DbConnectionDto dbConnectionDto = CommonUtil.po2VO(dbConnection, DbConnectionDto.class);

        List<DbTableCnf> tableCnfs = dbTableCnfService.getDbTableCnfByPid(dbConnection.getId());
        List<DbTableCnfDto> tableCnfDtos = new ArrayList<>();

        tableCnfs.forEach(dbTableCnf -> {
            List<DbFieldCnf> fieldList = dbFieldCnfService.getDbFieldCnfByPid(dbTableCnf.getId());
            String tableName = dbTableCnf.getTableName();

            fieldList.forEach(field -> {
                DbColumnComment columnComment = dbColumnCommentService
                        .getColumnComment(conId, tableName, field.getFieldName());
                if (columnComment.getComment() != null) {
	                field.setFieldNote(columnComment.getComment());
                }
            });

            DbTableCnfDto dbTableCnfDto = CommonUtil.po2VO(dbTableCnf, DbTableCnfDto.class);
            List<DbFieldCnfDto> fieldDtoList = CommonUtil.listPo2VO(fieldList, DbFieldCnfDto.class);
            dbTableCnfDto.setFieldDto(fieldDtoList);
            tableCnfDtos.add(dbTableCnfDto);
        });
        dbConnectionDto.setTableDto(tableCnfDtos);

        return ResultVo.ok(dbConnectionDto);
    }

    /**
     * 将数据库信息存入数据库
     */
    @Override
    public ResultVo storeTableFieldInfo(DbConnectionDto dbConnectionDto) {
        List<DbTableCnfDto> tableDto = dbConnectionDto.getTableDto();
        for (DbTableCnfDto dbTableCnfDto : tableDto) {
            DbTableCnf tableCnf = CommonUtil.po2VO(dbTableCnfDto, DbTableCnf.class);
            dbTableCnfMapper.insert(tableCnf);

            List<DbFieldCnfDto> fieldDto = dbTableCnfDto.getFieldDto();
	        fieldDto.forEach(dto -> {
		        DbFieldCnf fieldCnf = CommonUtil.po2VO(dto, DbFieldCnf.class);
		        dbFieldCnfMapper.insert(fieldCnf);
	        });
        }

        return ResultVo.ok();
    }

    /**
     * 删除数据库连接
     * 暂不删除db_table_cnf和db_field_cnf两张表中的相关数据
     * 如果已经被依赖，则连接的删除会引发错误
     */
    @Override
    public ResultVo deleteDbConnectionById(String id, String kitId) {
//		DbConnection connection = dbConnectionMapper.selectByPrimaryKey(dbConnection.getId());
//		if ("YES".equals(connection.getStatus())) {
//			return ResultVo.fail("已经发布，不可删除");
//		}

        DbConnection dbConnection = new DbConnection();
        dbConnection.setId(id);
        dbConnection.setDelStatus(Constants.DEL_STATUS_DEL);
        dbConnectionMapper.updateByPrimaryKeySelective(dbConnection);

        // 通知节点删除
        dbKitTemplate.deleteDbConnectionById(id, kitId);

        return ResultVo.ok("");
    }

    /**
     * 更新数据库连接
     */
    @Override
    public ResultVo updateDbConnection(DbConnectionDto dbConnection) {
        String ip = dbConnection.getIp().trim();
        String port = dbConnection.getPort().trim();
        String databaseName = dbConnection.getDataBaseName().trim();
        String dbType = JdbcUtil.judgeDbType(dbConnection.getVersionName());
        String url = JdbcUtil.generateUrl(dbType, ip, port, databaseName);
        dbConnection.setUrl(url);
        dbConnection.setDelStatus(Constants.DEL_STATUS_NOR);
        dbConnection.setUpdOrgId(UserUtil.getOrgId());
        dbConnection.setUpdTm(CommonUtil.getSystemDate());
        dbConnection.setUpdUserId(UserUtil.getUserId());
        String password = dbConnection.getPassword();
        try {
            password = DESUtil.decryptor(password);
        } catch (Exception e) {
            log.warn("密码异常[{}]", e.getMessage());
            return ResultVo.fail("密码异常");
        }
        dbConnection.setPassword(PasswordUtil.encrypt(password));
        dbConnection.setType("--");
        dbConnectionMapper.updateByPrimaryKeySelective(dbConnection);
        // 通知节点修改
        String kitId = dbConnection.getKitId();
        if (StringUtil.isEmpty(kitId)) {
            String orgId = dbConnection.getOrgId();
            DbDbKit dbKit = dbDbKitService.getDbKitByOrgId(orgId);
            dbConnection.setKitId(dbKit.getId());
        }
        dbKitTemplate.updateDbConnection(dbConnection);
        return ResultVo.ok();
    }

    /**
     * 根据ID获取数据库连接
     */
    @Override
    public DbConnection getDbConnectionById(String id) {
        return dbConnectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getDatabaseNameById(String id) {
        DbConnection connection = Optional.ofNullable(getDbConnectionById(id)).orElse(new DbConnection());
        return Optional.ofNullable(connection.getDataBaseName()).orElse("");
    }

    /**
     * 获取某个数据库连接下的所有表的表名
     */
    @Override
    public ResultVo<List<DbTableCnf>> getTablesByConId(String conId) {
        DbTableCnfExample example = new DbTableCnfExample();
        Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(conId);
        List<DbTableCnf> dbTableCnfList = dbTableCnfMapper.selectByExample(example);
        return ResultVo.ok(dbTableCnfList);
    }

    /**
     * 获取表的列信息
     */
    @Override
    public ResultVo<List<DbFieldCnf>> getTableColumns(String tableId) {
        DbFieldCnfExample example = new DbFieldCnfExample();
        DbFieldCnfExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(tableId);
        List<DbFieldCnf> fieldList = dbFieldCnfMapper.selectByExample(example);

        DbTableCnf tableCnf = dbTableCnfMapper.selectByPrimaryKey(tableId);
        String conId = tableCnf.getPid();
        String tableName = tableCnf.getTableName();

        fieldList.forEach(field -> {
	        DbColumnComment columnComment = dbColumnCommentService
			        .getColumnComment(conId, tableName, field.getFieldName());
            if (columnComment.getComment() != null) {
	            field.setFieldNote(columnComment.getComment());
            }
        });

        return ResultVo.ok(fieldList);
    }

    /**
     * 检验用户填写的IP地址和端口是否可以连通
     */
    @Override
    public ResultVo<String> checkIpAndPort(String ip, Integer port) {
        if (ip == null || "".equals(ip)) {
            throw new CommonException("没有IP");
        }

        if (port == null || port < 1) {
            throw new CommonException("没有端口");
        }

        DbConnection connection = new DbConnection();
        connection.setIp(ip);
        connection.setPort(port + "");

        // 通知节点检验
        ResultVo<?> vo = dbKitTemplate.checkIpAndPort(connection);

        if (vo == null || vo.getStatus() != 200) {
            throw new CommonException("检验失败");
        }

        return ResultVo.ok();
    }

    /**
     * 根据用户填写的IP地址、端口、用户名、密码、数据库名检验数据库是否可以连通
     */
    @Override
    public ResultVo checkDatabaseConnection(DbConnectionDto dbConnection) {
        if (dbConnection.getKitId() == null) {
            DbDbKit dbKit = dbDbKitService.getDbKitByOrgId(dbConnection.getOrgId());
            dbConnection.setKitId(dbKit.getId());
        }
        ResultVo<?> vo = dbKitTemplate.checkDatabaseConnection(dbConnection);

        if (vo == null || vo.getStatus() != 200) {
            return ResultVo.fail();
        }

        return ResultVo.ok();
    }


    /**
     * 刷新数据库信息缓存
     */
    @Override
    public ResultVo refreshDbConnection(String conId, String kitId) {
        asyncTask.refreshConnection(kitId, conId);
        return ResultVo.ok();
    }

    /**
     * 根据ID查询数据库连接
     */
    @Override
    public ResultVo<DbConnection> getConnectionById(String id) {
        DbConnection connection = dbConnectionMapper.selectByPrimaryKey(id);
        String password = DESUtil.encrypt(connection.getPassword());
        connection.setPassword(password);
        return ResultVo.ok(connection);
    }

}
