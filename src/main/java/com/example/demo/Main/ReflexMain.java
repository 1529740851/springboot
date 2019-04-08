package com.example.demo.Main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.core.io.ClassPathResource;

import com.example.demo.Annotation.Exceld;
import com.example.demo.entity.Student;

public class ReflexMain {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student stu=new Student(1,"张三",33);
		Student stu1=new Student(2,"李四",22);
		Student stu2=new Student(3,null,33);
		Student stu3=new Student(4,"孙六",24);
		List<Student> stus=new ArrayList<Student>();
		stus.add(stu);
		stus.add(stu1);
		stus.add(stu2);
		stus.add(stu3);
		getField(stus,Student.class);
	}
	
	public static HSSFWorkbook oupt() throws Exception{
		  HSSFWorkbook workbook1 = new HSSFWorkbook();// 新建一个Excel的工作空间
          ClassPathResource cpr = new ClassPathResource("/statics/excel/fgw_kgdq.xls");
          InputStream inputStream = cpr.getInputStream();
          HSSFWorkbook hSSFWorkbook  = new HSSFWorkbook(inputStream);
          HSSFSheet mbljSheet = hSSFWorkbook.getSheetAt(0);
          workbook1 = hSSFWorkbook;// 把模板复制到新建的Excel
          return workbook1;
	}
	
	public static void getField(List<?> list,Class classs ) throws IllegalArgumentException, IllegalAccessException{
		/*Class<?> entityClass = list.get(0).getClass();
		entityClass.getAnnotations();*/
		List<List<Object>> objlist=new ArrayList<>();
		List<Object> obj0 =new ArrayList<>();
		for(Field field : classs.getDeclaredFields()){
			Exceld e=field.getAnnotation(Exceld.class);
			obj0.add(e==null?"":e.name());
		}
		objlist.add(obj0);
		Iterator<?> iter = list.iterator();	
		while (iter.hasNext()) {
			Object obj=iter.next();
			final	List<Object> obj1=new ArrayList<>();
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Exceld e=field.getAnnotation(Exceld.class);
				if(e==null){
					continue;
				}
					Object Value = field.get(obj);				
					Value=Value==null?"":Value;
					obj1.add(Value);
					/*if(field.getType()==String.class){
						System.out.println("String"+Value);
					}
					if(field.getType()==Integer.class){
						System.out.println("Integer"+Value);
					}
					if(field.getType()==Date.class){
						System.out.println("String"+(Date)Value);
					}*/
				
			}
			objlist.add(obj1);
		}
		for (List<Object> list2 : objlist) {
			for (Object object : list2) {
				System.out.println(object);
			}
		}
	}
	
}
