package com.example.demo.Main;

import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.Annotation.Exceld;
import com.example.demo.entity.Student;

public class ReflexMain {

	public static void main(String[] args) throws Exception {
		Student stu = new Student(1, "张三", 33);
		Student stu1 = new Student(2, "李四", 22);
		Student stu2 = new Student(3, null, 33);
		Student stu3 = new Student(4, "孙六", 24);
		stu.setDate(new Date());
		List<Student> stus = new ArrayList<Student>();
		stus.add(stu);
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		//getField(stus);
		HSSFWorkbook work = oupt1(stus);
		work.write(new File("d:/x.xls"));

	}

	public static HSSFWorkbook oupt() throws Exception {
		HSSFWorkbook workbook1 = new HSSFWorkbook();// 新建一个Excel的工作空间
		ClassPathResource cpr = new ClassPathResource("/statics/excel/fgw_kgdq.xls");
		InputStream inputStream = cpr.getInputStream();
		HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(inputStream);
		HSSFSheet mbljSheet = hSSFWorkbook.getSheetAt(0);
		workbook1 = hSSFWorkbook;// 把模板复制到新建的Excel
		return workbook1;
	}

	public static CellStyle getCellStyleTitle(HSSFWorkbook workbook){
		CellStyle cellStyleTitle = workbook.createCellStyle();
		HSSFFont fontTitle = workbook.createFont();
		fontTitle.setFontHeightInPoints((short) 25); //字体大小
		fontTitle.setFontName("宋体"); //字体
	    fontTitle.setBold(true);
		cellStyleTitle.setFont(fontTitle);
		cellStyleTitle.setAlignment(HorizontalAlignment.CENTER); //水平布局：居中
		cellStyleTitle.setWrapText(true);//设置自动换行
		return cellStyleTitle;
	}
	
	public static CellStyle getCellStyle(HSSFWorkbook workbook){
		CellStyle cellStyle= workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 15); //字体大小
		font.setFontName("宋体"); //字体
		cellStyle.setFont(font);
		cellStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return cellStyle;
	}
	

	public static HSSFWorkbook oupt1(List<?> list) throws Exception {	
		HSSFWorkbook workbook = new HSSFWorkbook();	
		CellStyle cellStyleTitle=getCellStyleTitle(workbook);  //获取大标题样式
		CellStyle cellStyle=getCellStyle(workbook);			   //获取小标题样式
		HSSFSheet sheet = workbook.createSheet("学生表");
		List<List<Object>> lists = getList(list);
		int hb=lists.get(0).size()-1;
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, hb);
		Row rowtitle = sheet.createRow(0);
		rowtitle.createCell(0).setCellValue("学生表");
		rowtitle.getCell(0).setCellStyle(cellStyleTitle);
		sheet.addMergedRegion(region);
		for (int i = 0; i < lists.size(); i++) {
			int line=i+1;
			Row row = sheet.createRow(line);
			for (int j = 0; j < lists.get(i).size(); j++) {
				row.createCell(j).setCellValue(lists.get(i).get(j).toString());			
				if(i==0){
				System.out.println(lists.get(i).get(j).toString());
				row.getCell(j).setCellStyle(cellStyle);	
				}
			
			}

		}
		return workbook;
	}


	public static List<List<Object>> getList(List<?> list) throws IllegalArgumentException, IllegalAccessException {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		List<List<Object>> objlist = new ArrayList<>();
		List<Object> obj0 = new ArrayList<>();
		for (Field field : list.get(0).getClass().getDeclaredFields()) {
			Exceld e = field.getAnnotation(Exceld.class);
			if (e == null) {
				continue;
			}
			obj0.add(e == null ? "" : e.name());
		}
		objlist.add(obj0);
		Iterator<?> iter = list.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			final List<Object> obj1 = new ArrayList<>();
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Exceld e = field.getAnnotation(Exceld.class);
				if (e == null) {
					continue;
				}
				
				Object Value = field.get(obj);
				if(field.getType()==Date.class&&Value!=null){
					Value=df.format((Date)Value);
				}
				Value = Value == null ? "" : Value;
				obj1.add(Value);
			}
			objlist.add(obj1);
		}
		return  objlist;
	}

	
}
