package com.rainyhon.common.service;

import com.microcore.center.mapper.ViewMapper;
import com.microcore.center.model.*;
import com.rainyhon.common.model.DynamicQuery;
import com.rainyhon.common.model.DynamicQueryColumn;
import com.rainyhon.common.model.DynamicQueryWeb;
import com.rainyhon.common.util.CommonUtil;
import com.rainyhon.common.vo.ResultVo;
import com.rainyhon.common.vo.Unary;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@Log
public class ViewService {

    public static final String GT = "gt";

    public static final String LT = "lt";

    public static final String EQ = "eq";

    public static final String BETWEEN = "between";

    public static final String START = "*";

    public static final String LTEQ = "lteq";

    public static final String NEQ = "neq";

    public static final String GTEQ = "gteq";

    public static final String IN = "in";

    public static final String AND = "and";

    public static final String MARKS = "'";

    public static final String LIKE = "like";

    @Autowired
    private ViewMapper viewMapper;

    public ResultVo getColumnByViewName(String name) {
        List<ColumnVo> list = viewMapper.getColumnByViewName(name);
        ResultVo vo = new ResultVo();
        vo.setData(list);
        return vo;
    }

    public ResultVo getAllViewName() {
        List<String> list = viewMapper.getAllViewName();
        ResultVo vo = new ResultVo();
        vo.setData(list);
        return vo;
    }

    private final String SELECT = "select";

    private final String FROM = "from";

    private final String WHERE = "where";

    private final String SPACE = " ";

    private final String COMMA = ",";

    private final String PRE_BRACKET = "(";

    private final String SUF_BRACKET = ")";

    private final String DEFAULT_CONDITION = "1=1";

    public ResultVo query(ViewQueryVo query) {
        ResultVo vo = new ResultVo();
        StringBuilder sql = new StringBuilder();
        // select
        sql.append(SELECT);
        sql.append(SPACE);
        List<ColumnVo> columnVos = query.getColumns();
        if (columnVos == null || columnVos.isEmpty()) {
            sql.append(START);
        } else {
            columnVos.forEach(columnVo -> {
                sql.append(columnVo.getColumnName());
                sql.append(COMMA);
            });
            sql.deleteCharAt(sql.length() - 1);
        }
        // from
        sql.append(SPACE).append(FROM).append(SPACE);
        sql.append(query.getViewName());
        // where
        sql.append(SPACE).append(WHERE).append(SPACE);
        sql.append(DEFAULT_CONDITION).append(SPACE).append(AND).append(SPACE);
        // condition;
        appendConditions(sql, query.getUnary());
        log.info(sql.toString());
        List<Map<String, String>> result = viewMapper.query(sql.toString());
        vo.setData(result);
        return vo;
    }

    /**
     * 追加条件
     *
     * @param sql
     * @param unary
     */
    private void appendConditions(StringBuilder sql, Unary unary) {
        if (unary != null) {
            // a = 1
            switch (unary.getCondition()) {
                case GT:
                    sql.append(unary.getColumn()).append(">").append(formatValue(unary.getValue(), unary.getType()));
                    break;
                case GTEQ:
                    sql.append(unary.getColumn()).append(">=").append(formatValue(unary.getValue(), unary.getType()));
                    break;
                case LT:
                    sql.append(unary.getColumn()).append("<").append(formatValue(unary.getValue(), unary.getType()));
                    break;
                case LTEQ:
                    sql.append(unary.getColumn()).append("<=").append(formatValue(unary.getValue(), unary.getType()));
                    break;
                case EQ:
                    sql.append(unary.getColumn()).append("=").append(formatValue(unary.getValue(), unary.getType()));
                    break;
                case NEQ:
                    sql.append(unary.getColumn()).append("!=").append(formatValue(unary.getValue(), unary.getType()));
                    break;
                case BETWEEN:
                    String[] betweenValue = unary.getValue().split(COMMA);
                    if (betweenValue.length != 2) {
                        throw new IllegalArgumentException("between条件参数不足或大于2个");
                    }
                    sql.append(unary.getColumn())
                            .append(SPACE).append("between").append(SPACE)
                            .append(formatValue(betweenValue[0], unary.getType())).append("and").append(SPACE).append(formatValue(betweenValue[1], unary.getType()));
                    break;
                case IN:
                    String[] inValue = unary.getValue().split(COMMA);
                    sql.append(unary.getColumn()).append(SPACE).append("in").append(SPACE);
                    // (
                    sql.append(PRE_BRACKET);
                    for (String value : inValue) {
                        sql.append(formatValue(value, unary.getType())).append(COMMA);
                    }
                    sql.deleteCharAt(sql.length() - 1);
                    // )
                    sql.append(SUF_BRACKET);
                    break;
                case LIKE:
                    break;
            }
        }
        Unary aftUnary = unary.getAftUnary();
        Unary childUnary = unary.getChildUnary();
        if (aftUnary != null && childUnary != null) {
            throw new IllegalArgumentException(unary.getColumn() + "的aftUnary,childUnary属性不可同时存在");
        }
        if (aftUnary != null) {
            // and || or
            sql.append(SPACE).append(aftUnary.getRelation()).append(SPACE);
            appendConditions(sql, aftUnary);
        }
        if (childUnary != null) {
            // and || or
            sql.append(SPACE).append(childUnary.getRelation()).append(SPACE);
            // 一对括号为一元
            // (
            sql.append(PRE_BRACKET);
            appendConditions(sql, childUnary);
            // )
            sql.append(SUF_BRACKET);
        }

    }

    private String formatValue(String value, String type) {
        String result;
        switch (type.toLowerCase()) {
            case "varchar":
                result = MARKS + value + MARKS;
                break;
            case "integer":
                result = value;
                break;
            case "datetime":
                result = MARKS + value + MARKS;
                break;
            default:
                throw new IllegalArgumentException("不支持的数据类型:" + type);
        }
        return result;
    }

    public ResultVo getAllCondtions() {
        Map<String, String> conditions = new HashMap<>();
        conditions.put(GT, "大于");
        conditions.put(LT, "小于");
        conditions.put(EQ, "等于");
        conditions.put(NEQ, "不等于");
        conditions.put(LTEQ, "小于等于");
        conditions.put(GTEQ, "大于等于");
        conditions.put(BETWEEN, "之间");
        conditions.put(IN, "包含");
        conditions.put(LIKE, "模糊");
        return ResultVo.ok(conditions);
    }

    @Autowired
    private DynamicQueryService service;

    @Autowired
    private DynamicQueryWebService webService;

    @Autowired
    private DynamicQueryColumnService columnService;

    @Transactional(rollbackFor = Exception.class)
    public ResultVo add(ViewAddVo vo) {
        DynamicQuery query = new DynamicQuery();
        String dqId = CommonUtil.getUUID();
        // 新增DynamicQuery
        query.setId(dqId);
        query.setViewName(vo.getViewName());
        query.setViewDisplayName(vo.getViewDisplayName());
        query.setDescription(vo.getDescription());
        query.setCreateTime(new Date());
        service.add(query);
        // FIXME 其他表何时存
        addWeb(vo, dqId);
        return ResultVo.ok();
    }

    private void addWeb(ViewAddVo vo, String dqId) {
        DynamicQueryWeb web = new DynamicQueryWeb();
        web.setId(CommonUtil.getUUID());
        web.setDqId(dqId);
        web.setData(vo.getData());
        webService.add(web);
    }

    /**
     * 新增字段
     *
     * @param vo
     * @param dqId
     */
    private void addColumns(ViewAddVo vo, String dqId) {
        List<ColumnVo> columns = vo.getColumns();
        if (columns != null && !columns.isEmpty()) {
            for (int i = 0; i < columns.size(); i++) {
                ColumnVo cvo = columns.get(i);
                DynamicQueryColumn column = new DynamicQueryColumn();
                column.setId(CommonUtil.getUUID());
                column.setDqId(dqId);
                column.setColumnName(cvo.getColumnName());
                column.setColumnDisplayName(cvo.getColumnDisplayName());
                column.setType(cvo.getType());
                column.setOrderIndex(i);
                columnService.add(column);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultVo modify(ViewModifyVo vo) {
        DynamicQuery query = new DynamicQuery();
        String dqId = vo.getId();
        if (service.isExist(dqId)) {
            // 新增DynamicQuery
            query.setId(dqId);
            query.setViewName(vo.getViewName());
            query.setViewDisplayName(vo.getViewDisplayName());
            query.setDescription(vo.getDescription());
            service.modify(query);
        }
        deleteWeb(dqId);
        addWeb(vo, dqId);
        deleteColumns(dqId);
        addColumns(vo, dqId);
        return ResultVo.ok();
    }

    private void deleteWeb(String dqId) {
        webService.delete(dqId);
    }

    private void deleteColumns(String dqId) {
        columnService.delete(dqId);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultVo delete(String[] ids) {
        for (String id : ids) {
            service.delete(id);
            deleteWeb(id);
            deleteColumns(id);
        }
        return ResultVo.ok();
    }

    public ResultVo details(String id) {
        ViewDetailVo vo = new ViewDetailVo();
        DynamicQuery dq = service.findOne(id);
        vo.setId(id);
        vo.setViewName(dq.getViewName());
        vo.setViewDisplayName(dq.getViewDisplayName());
        vo.setDescription(dq.getDescription());
        DynamicQueryWeb web = webService.findOneByDQId(id);
        vo.setData(web.getData());
        List<DynamicQueryColumn> list = columnService.findOneByDQId(id);
        List<ColumnVo> columns = list.stream().map(this::convertColumn2Vo).collect(Collectors.toList());
        vo.setColumns(columns);
        return ResultVo.ok(vo);
    }

    /**
     * 列对象转换
     *
     * @param column
     * @return
     */
    private ColumnVo convertColumn2Vo(DynamicQueryColumn column) {
        ColumnVo columnVo = new ColumnVo();
        columnVo.setColumnName(column.getColumnName());
        columnVo.setColumnDisplayName(column.getColumnDisplayName());
        columnVo.setType(column.getType());
        return columnVo;
    }
}
