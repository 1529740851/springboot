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
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;

public class EasyExclUtil {
	
	 public static void main(String[] args) {
			//System.out.println(DateUtil.DoubletoDate(43418.399537037039,"yyyy-MM-dd HH:mm:ss"));
	        long act = System.currentTimeMillis();
	       
	    		String filepath="E:\\shuju\\shuju.xlsx";
			  List<String> sheetContent;
				sheetContent = read(filepath);

		        System.out.println("一共"+sheetContent.size()+"有效数据");
		        long end = System.currentTimeMillis();
		        System.out.println("耗时间=======:"+(end-act)+"毫秒");
			
	        //write();

	        
	        //System.out.println(listUser.size());


	    }

	 private static  List<String> read(String filepath)  {
	        List<String> sheetContent = new ArrayList<>();
	       
	        //String filepath ="E:\\all_cach\\1.xlsx";
	        try (InputStream inputStream = new FileInputStream(filepath)) {
	            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null,
	                    new AnalysisEventListener<List<String>>() {

	                @Override
	                public void invoke(List<String> object, AnalysisContext context) {
	                    /**
	                     * 自行添加syl 》》》
	                     */
	                    StringBuffer stringBuffer = new StringBuffer();
	                    if(object != null && !StringUtils.isEmpty(object.get(0))){
	                        for(String s: object){
	                            if(null!=s){
	                                stringBuffer.append(s+"=");
	                            }
	                        }
	                        System.out.println("行=="+context.getCurrentRowNum()+":  "+stringBuffer.toString());

	                        sheetContent.add(stringBuffer.toString());
	                        /**
	                         *  《《《自行添加结束
	                         */
	                        System.out.println("当前sheet:" + context.getCurrentSheet().getSheetNo() + ",当前行:" +
	                                context.getCurrentRowNum());
	                    }

	                }

	                @Override
	                public void doAfterAllAnalysed(AnalysisContext context) {

	                }
	            });
	            excelReader.read();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    return sheetContent;

	    }

	 
	 
	 @Test
     public void writeWithoutHead() throws IOException {
        try (OutputStream out = new FileOutputStream("E://withHead.xlsx");) {
           ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
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
           writer.write0(data, sheet1, table);
           writer.finish();
        }
     }
}
