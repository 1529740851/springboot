package com.example.demo.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.example.demo.entity.Tabletmp;


public class ExclUtil {
	
	

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	public static List<String> importExcel(String fileName){	
		List<String> resultList = new ArrayList<String>();
		FileInputStream fin = null;
		try{
			String tempStr = "";
			Workbook workbook = null;
			String fileVersion = "";
			if(fileName.endsWith(".xlsx")){
				fileVersion = "2007";
			}else if(fileName.endsWith(".xls")){
				fileVersion = "2003";
			}
			fin = new FileInputStream(new File(fileName));
			if("2003".equals(fileVersion)){
				workbook = new HSSFWorkbook(fin);
			}else if("2007".equals(fileVersion)){
				workbook = new XSSFWorkbook(fin);
			}
			if(workbook == null){
				
				fin.close();
				return null;
			}

			//只读取第一个sheet页
			Sheet sheet = workbook.getSheetAt(0);
			int rowNum = sheet.getLastRowNum();
			// 正文内容应该从第二行开始,第一行为表头的标题
	        for (int i = 0; i <= rowNum; i++) {
	        	//有多少个单元格可读，如果中间有单元格为""则以这个单元格为size
	        	int cellsize=sheet.getRow(0).getPhysicalNumberOfCells();
	        	tempStr = getRowValue(sheet.getRow(i),cellsize);
	            resultList.add(tempStr);	        	
	        }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
            try {
				fin.close();
			} catch (IOException e) {
			
			}
        }
	    return resultList;
	}
	
	/**
	 * 读取每一行的数据，用"<,>"隔开
	 * @param row
	 * @return
	 */
	private static String getRowValue(Row row,int cellsize){
		StringBuffer rowValue = new StringBuffer();
		String temp = "";
		for (int i=0;i<cellsize;i++){			
			temp = getCellFormatValue(row.getCell(i));
		     if(i!=cellsize-1){
		    	 rowValue.append(temp+"<,>");
			 }else{
				 rowValue.append(temp);
			 }
			
		}
		return rowValue.toString();
	}
	
	 /**
     * 读取每个单元格数据
     * @param cell
     * @return
     */
	private static String getCellFormatValue(Cell cell) {
	        String cellvalue = "";
	        if(cell== null){
	        	return null;
	        }
	        switch (cell.getCellType()) {
	            // 如果当前Cell的Type为NUMERIC
	            case Cell.CELL_TYPE_NUMERIC:
	            case Cell.CELL_TYPE_FORMULA: {
	                // 判断当前的cell是否为Date
	                if (HSSFDateUtil.isCellDateFormatted(cell)) {
	                    Date date = cell.getDateCellValue();	                  
	                    cellvalue = sdf.format(date);
	                }
	                // 如果是纯数字
	                else {
	                    // 取得当前Cell的数值
	                    cellvalue = String.valueOf(cell.getNumericCellValue());
	                }
	                break;
	            }
	            // 如果当前Cell的Type为STRIN
	            case Cell.CELL_TYPE_STRING:
	                // 取得当前的Cell字符串
	                cellvalue = cell.getRichStringCellValue().getString();    
	                break;
	            // 默认的Cell值
	            default:
	                cellvalue = cell.getRichStringCellValue().getString();
	               
	            }
	        return cellvalue;

	    }
	    

	public   List<Tabletmp>  excl(){
	    	ExclUtil excelReader = new ExclUtil();
	        try {
	            // 对读取Excel表格内容测试
	        	String fileName="E:\\shuju\\shuju.xlsx";
	           // String fileName = "d:\\testExcel.xlsx";
	            List<String> reult = excelReader.importExcel(fileName);
	           
	            List<Tabletmp> tas=new ArrayList<Tabletmp>();
	            for (int i = 1; i <reult.size() ; i++) {
	            Tabletmp ta=new Tabletmp();
	            String[] cells = reult.get(i).split("<,>");	           	           
	            	ta.setAcloumn(cells[0]);
	            	ta.setTitle(cells[1]);
	            	String html=cells[2];
	            	html=html.replace("src=\"", "src=\"/res_base/wxdgljupload/");
	            	html=html.replace("http://www.shrc.gov.cn/", "/res_base/wxdgljupload/");
	            	ta.setAcontent(html);
	            	ta.setAuthor(cells[3]);
	            	ta.setSubtitle(cells[4]);
	            	ta.setTitlehref(cells[5]);
	            	ta.setSource(cells[6]);
	            	ta.setPeople(cells[7]);
	            	ta.setDraft(cells[8]);
	            	ta.setAbstract(cells[9]);
	            	if(StringUtils.isNotBlank(cells[10])&&!"null".equals(cells[10])){	            		
	            	ta.setReleasedate(sdf.parse(cells[10]));	
	            	}else{	            	
	            	ta.setReleasedate(null);
	            	}
	            	ta.setImage(cells[11]);	            	
	            	tas.add(ta);
				}	 
	            System.out.println(tas.size());
	            return tas;
	           // for (int i = 0; i < tas.size(); i++) {
					//System.out.println(tas.get(0).getReleasedate());
				//}
	        } catch (Exception e) {
	        
	            e.printStackTrace();
	        }
			return null;
	    }
	    
	public static void main(String[] args) throws Exception{
	    	
	    	ExclUtil excelReader = new ExclUtil();
	        try {
	            // 对读取Excel表格内容测试
	        	String fileName="E:\\shuju\\shuju.xlsx";
	           // String fileName = "d:\\testExcel.xlsx";
	            List<String> reult = excelReader.importExcel(fileName);
	           
	            List<Tabletmp> tas=new ArrayList<Tabletmp>();
	            for (int i = 1; i <reult.size() ; i++) {
	            Tabletmp ta=new Tabletmp();
	            String[] cells = reult.get(i).split("<,>");	   
	            	ta.setAcloumn(cells[0]);
	            	ta.setTitle(cells[1]);
	            	ta.setAcontent(cells[2]);
	            	ta.setAuthor(cells[3]);
	            	ta.setSubtitle(cells[4]);
	            	ta.setTitlehref(cells[5]);
	            	ta.setSource(cells[6]);
	            	ta.setPeople(cells[7]);
	            	ta.setDraft(cells[8]);
	            	ta.setAbstract(cells[9]);
	            	if(StringUtils.isNotBlank(cells[10])&&!"null".equals(cells[10])){	            		
	            	ta.setReleasedate(sdf.parse(cells[10]));	
	            	}else{	            	
	            	ta.setReleasedate(null);
	            	}
	            	ta.setImage(cells[11]);	            	
	            	tas.add(ta);
				}	 
	            //System.out.println(tas.size());
	           // for (int i = 0; i < tas.size(); i++) {
					//System.out.println(tas.get(0).getReleasedate());
				//}
	        } catch (Exception e) {
	        
	            e.printStackTrace();
	        }
	    }
	    	

}


