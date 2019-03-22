package com.example.demo.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.demo.entity.Student;

public class EasyExclUtil {
	
	 public static void main(String[] args) throws IOException {

		 	InputStream inputStream = new FileInputStream("E:\\student.xlsx");
	        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
	       // List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0,Student.class));
	        inputStream.close();
	        print(data);

	    }

	

	 
	 //有表头
	 @Test
	 public static void writeWithoutHead() throws IOException {
        try (OutputStream out = new FileOutputStream("E://withHead3.xlsx");) {
           ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
           Sheet sheet1 = new Sheet(1, 0);
           sheet1.setSheetName("sheet1");
           List<List<String>> data = new ArrayList<>();
           for (int i = 0; i < 50; i++) {
              List<String> item = new ArrayList<>();
              item.add("item0" + i);
              item.add("item1" + i);
              item.add("item2" + i);
              data.add(item);
           }
           List<List<String>> head = new ArrayList<List<String>>();
           List<String> headCoulumn1 = new ArrayList<String>();
           List<String> headCoulumn2 = new ArrayList<String>();
           List<String> headCoulumn3 = new ArrayList<String>();
           headCoulumn1.add("第一列");
           headCoulumn2.add("第二列");
           headCoulumn3.add("第三列");
           head.add(headCoulumn1);
           head.add(headCoulumn2);
           head.add(headCoulumn3);
           Table table = new Table(1);
           table.setHead(head);
        
          // TableStyle tableStyle= new TableStyle();
          // tableStyle.setTableHeadBackGroundColor(IndexedColors.RED);
          // tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);
           //table.setTableStyle(tableStyle);
           
           writer.write0(data, sheet1, table);
           writer.finish();
        }
     }
	 
	 //无表头
	 public static void wubiaotou() throws FileNotFoundException, IOException{
		 try (OutputStream out = new FileOutputStream("withoutHead.xlsx");) {
	         ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
	         Sheet sheet1 = new Sheet(1, 0);
	         sheet1.setSheetName("sheet1");
	         List<List<String>> data = new ArrayList<>();
	         for (int i = 0; i < 100; i++) {
	            List<String> item = new ArrayList<>();
	            item.add("item0" + i);
	            item.add("item1" + i);
	            item.add("item2" + i);
	            data.add(item);
	         }
	         writer.write0(data, sheet1);
	         writer.finish();
	      }

		 
	 }
	 
	 //根据表写入数据
	 public static void writestudent() throws IOException {
	      try (OutputStream out = new FileOutputStream("E://student.xlsx");) {
	         ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
	         Sheet sheet1 = new Sheet(1, 0, Student.class);
	         sheet1.setSheetName("sheet1");
	         List<Student> data = new ArrayList<>();
	         for (int i = 0; i < 100; i++) {
	            Student item = new Student();
	            item.setName( "name" + i); 
	            item.setAge(i);      
	            data.add(item);
	         }
	         writer.write(data, sheet1);
	         writer.finish();
	      }
	 }
	 
	 public static void print(List<Object> data){
		  for (Object object : data) {
		        List<String> list=(List<String>) object;
		        for (String string : list) {
					System.out.println(string);
			}
		}
				
	 }
}
