package com.example.demo.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
//操作doc
public class DocMain {

		public static void main(String args[]){
	        File f = new File("d:\\test.doc");
	        try {
	            InputStream in = new FileInputStream(f);
	            HWPFDocument doc = new HWPFDocument(in);
	           /* String doc1 = doc.getDocumentText();
	            System.out.println(doc1);
	            StringBuilder doc2 = doc.getText();
	            System.out.println(doc2);*/
	            Range rang = doc.getRange();
	            rang.replaceText("${name}","张三");
	            String doc3 = rang.text();
	          //  System.out.println(doc3);	      
	            OutputStream os = new FileOutputStream("d:\\test1.doc");
	            doc.write(os);
	            os.close();
	            in.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	

}
