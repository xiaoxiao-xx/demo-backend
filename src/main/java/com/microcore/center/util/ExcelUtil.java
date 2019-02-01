package com.microcore.center.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.microcore.center.dto.DbModelDto;
import com.microcore.center.model.DbModelDetail;

@Slf4j
public class ExcelUtil {

	private static final  String XLS = "xls";
    private static final  String XLSX = "xlsx";

    /**
     * 读入excel文件，解析后返回
     * @param file
     * @throws IOException
     */
    public static DbModelDto readExcel(MultipartFile file) throws Exception{
        //检查文件
		checkFile(file);
        //获得Workbook工作薄对象
        Workbook workbook = getWorkBook(file);
        DbModelDto modelDto = null;
        if(workbook != null){
//        	int sheetNum = workbook.getNumberOfSheets();
//        	if (sheetNum!=2) {
//				throw new Exception("excel格式不正确");
//			}
            Sheet sheet1 = workbook.getSheetAt(0);//模型信息表
            if(sheet1 == null){
            	throw new Exception("模型信息为空");
            }
            modelDto = getSheetInfo1(sheet1);

            workbook.close();
        }
        return modelDto;
    }

	private static DbModelDto getSheetInfo1(Sheet sheet1) throws Exception {
		//获得当前sheet的开始行  
		int firstRowNum  = sheet1.getFirstRowNum();
		//获得当前sheet的结束行  
		int lastRowNum = sheet1.getLastRowNum();
		//读取第二行数据
		Row row = sheet1.getRow(firstRowNum+1);
		if (row == null) {
			throw new Exception("模型信息为空------");
		}
		DbModelDto modelDto = new DbModelDto();
		modelDto.setModelName(getCellValue(row.getCell(0)));
		modelDto.setModelTrade(getCellValue(row.getCell(1)));
		modelDto.setModelDesc(getCellValue(row.getCell(2)));

		List<DbModelDetail> modelDetailDto = new ArrayList<>();
		//循环除了第一行的所有行  
		for(int rowNum = firstRowNum+3;rowNum <= lastRowNum;rowNum++){
		    //获得当前行
		    Row row2 = sheet1.getRow(rowNum);
		    if(row2 == null){
		        continue;
		    }
		    DbModelDetail dbModelDetail = new DbModelDetail();
		    dbModelDetail.setFieldCname(getCellValue(row2.getCell(0)));
		    dbModelDetail.setFieldEname(getCellValue(row2.getCell(1)));
		    dbModelDetail.setFieldType(getCellValue(row2.getCell(2)));
		    dbModelDetail.setFieldDesc(getCellValue(row2.getCell(3)));
		    dbModelDetail.setType(getCellValue(row2.getCell(4)));
		    dbModelDetail.setDataType(getCellValue(row2.getCell(5)));
		    dbModelDetail.setDataList(getCellValue(row2.getCell(6)));
		    dbModelDetail.setRemark(getCellValue(row2.getCell(7)));
		    modelDetailDto.add(dbModelDetail);
		}
		modelDto.setModelDetailDto(modelDetailDto);
		return modelDto;
	}

    public static void checkFile(MultipartFile file) throws Exception{
        //判断文件是否存在
        if(null == file){
            throw new Exception("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename().toLowerCase();
        //判断文件是否是excel文件
        if(!fileName.endsWith(XLS) && !fileName.endsWith(XLSX)){
            throw new IOException(fileName + "不是excel文件");
        }
    }

    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename().toLowerCase();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(XLS)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(XLSX)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            log.info("IOException:{}",e.getMessage());
        }
        return workbook;
    }

    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        Object obj = null;
    	switch (cell.getCellTypeEnum()) {
	        case BOOLEAN:
	            obj = cell.getBooleanCellValue();
	            break;
	        case ERROR:
	            obj = cell.getErrorCellValue();
	            break;
	        case NUMERIC:
	            obj = cell.getNumericCellValue();
	            break;
	        case STRING:
	            obj = cell.getStringCellValue();
	            break;
	        default:
	            break;
    	}
    	cellValue = obj+"";
        return cellValue;
    }


    public static HSSFWorkbook getExcel() {

    	HSSFWorkbook workbook = new HSSFWorkbook();
    	HSSFSheet sheet = workbook.createSheet("sheet1");
    	HSSFRow row = sheet.createRow(0);
//    	HSSFCellStyle style = workbook.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

    	HSSFCell cell1 = row.createCell(0);
    	cell1.setCellValue("模型名称");
    	HSSFCell cell2 = row.createCell(1);
    	cell2.setCellValue("模型行业(公共领域,教育行业,机械机电,冶金钢铁,互联网)");
    	HSSFCell cell3 = row.createCell(2);
    	cell3.setCellValue("模型描述");

    	HSSFRow row1 = sheet.createRow(2);
    	HSSFCell cell_1 = row1.createCell(0);
    	cell_1.setCellValue("字段中文名称");
    	HSSFCell cell_2 = row1.createCell(1);
    	cell_2.setCellValue("字段英文名称");
    	HSSFCell cell_3 = row1.createCell(2);
    	cell_3.setCellValue("字段类型");
    	HSSFCell cell_4 = row1.createCell(3);
    	cell_4.setCellValue("字段描述");
    	HSSFCell cell_5 = row1.createCell(4);
    	cell_5.setCellValue("类型");
    	HSSFCell cell_6 = row1.createCell(5);
    	cell_6.setCellValue("表示格式");
    	HSSFCell cell_7 = row1.createCell(6);
    	cell_7.setCellValue("值域");
    	HSSFCell cell_8 = row1.createCell(7);
    	cell_8.setCellValue("定义：字段名称");

    	return workbook;
    }
}
