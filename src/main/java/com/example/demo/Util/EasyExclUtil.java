package com.example.demo.Util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang.StringUtils;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;

public class EasyExclUtil {
	
	 public static void main(String[] args) {
			System.out.println(DateUtil.DoubletoDate(43418.399537037039,"yyyy-MM-dd HH:mm:ss"));
	        long act = System.currentTimeMillis();
	       
	    	String filepath="E:\\shuju\\shuju.xlsx";

	        List<String> sheetContent = read(filepath);
	        //write();

	        System.out.println("一共"+sheetContent.size()+"有效数据");
	        long end = System.currentTimeMillis();
	        System.out.println("耗时间=======:"+(end-act)+"毫秒");
	        
	        //System.out.println(listUser.size());


	    }

	    private static  List<String> read(String filepath) {
	        List<String> sheetContent = new ArrayList<>();

	        //String filepath ="E:\\all_cach\\1.xlsx";
	        try (InputStream inputStream = new FileInputStream("E:\\shuju\\shuju.xlsx")) {
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

}
