package com.example.demo.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;

import com.example.demo.entity.Mnoticeconfig;

public class HtmlUtil {
		//读取html文件
		public static String readfile(String filePath){
			
		          File file = new File(filePath);  
		         InputStream input = null;
		         try {
		              input = new FileInputStream(file);
		          } catch (FileNotFoundException e) {
		              e.printStackTrace();
		         }  
		         StringBuffer buffer = new StringBuffer();  
		         byte[] bytes = new byte[1024];
		        try {
		             for(int n ; (n = input.read(bytes))!=-1 ; ){  
		                 buffer.append(new String(bytes,0,n,"GBK"));  
		             }
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		     
		        return buffer.toString();  
		     }
										
		/*获取所有html文件名*/
		public static List<String>  countAndCopy(File src) throws IOException {
				List<String> htmls=new ArrayList<String>();
				BufferedReader bfr = null;
				try {
					File[] fileArr = src.listFiles();
					for(File f : fileArr) {
							String name=f.getName();
							if(name.endsWith(".html")) {
								htmls.add(name)	;											
						}
					}					
				}finally {
					try {
					if(bfr != null)
							bfr.close();
					}catch(IOException ex) {
						throw new RuntimeException("释放文件失败");
					}
				}
				return htmls;
				
			}
		
		public static List<Mnoticeconfig> importHtml() throws IOException{
			
			String html1=Jsoup.parse("E:\\shuju\\节能监察中心门户网站要素\\File\\99a12b85-39f0-4cbe-823c-0ce2a01cc86d.html", "utf-8").toString() ;
			
			List<Mnoticeconfig> mconfigs=new ArrayList<Mnoticeconfig>();
			List<String> htmls= countAndCopy(new File("E:\\shuju\\节能监察中心门户网站要素\\File"));
			StringBuffer sb=new StringBuffer("E:\\shuju\\节能监察中心门户网站要素\\File\\");
			StringBuffer sb2=new StringBuffer();
			for (int i = 0; i < htmls.size(); i++) {
				Mnoticeconfig m=new Mnoticeconfig();
				String htmlname=htmls.get(i);
				String RptPath=htmlname.substring(0, htmlname.indexOf(".html"));
				m.setRptPath(RptPath);			
				String html=readfile(sb.append(htmlname).toString());	
				int start=html.indexOf(">", html.indexOf("<body"))+1;
				
				html=html.replace("src=\"","src=\"/res_base/jnjcupload/" );
				//System.out.println(html.indexOf(">", html.indexOf("<body")));
				sb2.append(html.substring(html.indexOf("<style>"), (html.indexOf("</style>")+8)));
				sb2.append(html.substring(start, html.indexOf("</body>")));
				//System.out.println(html.substring(html.indexOf("<style>"), (html.indexOf("</style>")+8)));				
				//System.out.println(html.substring(start, html.indexOf("</body>")));
				m.setAcontent(sb2.toString());
				sb.setLength(0);
				sb.append("E:\\shuju\\节能监察中心门户网站要素\\File\\");				
				mconfigs.add(m);
				sb2.setLength(0);
			}
			return mconfigs;
		}
		
		public static void main(String[] args) throws Exception{
			/*	List<Mnoticeconfig> mconfigs=new ArrayList<Mnoticeconfig>();
			List<String> htmls= countAndCopy(new File("E:\\shuju\\节能监察中心门户网站要素\\File"));
			StringBuffer sb=new StringBuffer("E:\\shuju\\节能监察中心门户网站要素\\File\\");
			for (int i = 0; i < htmls.size(); i++) {
				Mnoticeconfig m=new Mnoticeconfig();
				String htmlname=htmls.get(i);
				String RptPath=htmlname.substring(0, htmlname.indexOf(".html"));
				m.setRptPath(RptPath);				
				String html=readfile(sb.append(htmlname).toString());					
				m.setAcontent(html);
				sb.setLength(0);
				sb.append("E:\\shuju\\节能监察中心门户网站要素\\File\\");
				mconfigs.add(m);
			}*/
			String html1=Jsoup.parse("E:\\shuju\\节能监察中心门户网站要素\\File\\99a12b85-39f0-4cbe-823c-0ce2a01cc86d.html", "utf-8").toString() ;
			
			List<Mnoticeconfig> mconfigs=new ArrayList<Mnoticeconfig>();
			List<String> htmls= countAndCopy(new File("E:\\shuju\\节能监察中心门户网站要素\\File"));
			StringBuffer sb=new StringBuffer("E:\\shuju\\节能监察中心门户网站要素\\File\\");
			StringBuffer sb2=new StringBuffer();
			for (int i = 0; i < htmls.size(); i++) {
				Mnoticeconfig m=new Mnoticeconfig();
				String htmlname=htmls.get(i);
				String RptPath=htmlname.substring(0, htmlname.indexOf(".html"));
				m.setRptPath(RptPath);			
				String html=readfile(sb.append(htmlname).toString());	
				int start=html.indexOf(">", html.indexOf("<body"))+1;
				System.out.println(html.indexOf("src=\""));
				
				//html.replace("src='","src='res_base/jnjcupload" );
				//System.out.println(html.indexOf(">", html.indexOf("<body")));
				sb2.append(html.substring(html.indexOf("<style>"), (html.indexOf("</style>")+8)));
				sb2.append(html.substring(start, html.indexOf("</body>")));
				//System.out.println(html.substring(html.indexOf("<style>"), (html.indexOf("</style>")+8)));				
				//System.out.println(html.substring(start, html.indexOf("</body>")));
				m.setAcontent(sb2.toString());
				sb.setLength(0);
				sb.append("E:\\shuju\\节能监察中心门户网站要素\\File\\");				
				mconfigs.add(m);
				sb2.setLength(0);
			}
			
			   
		}

}
