package com.example.demo.Main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;

import com.example.demo.Util.EmailUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

	
		@Autowired
	    private EmailUtil emailUtil;
		 //添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
	    @Test
	    public void testSimpleMail() throws Exception {
	    	  /*/String content="<html>\n" +
	    	            "<body>\n" +
	    	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	    	            "</body>\n" +
	    	            "</html>";*/
	    		
	        //emailUtil.sendHtmlMail("1529740851@qq.com","test simple mail",content);
	    	emailUtil.sendSimpleMail("1529740851@qq.com","test simple mail"," hello this is simple mail");
	    		
	    	//String filePath="e:\\txt.txt";
	    	//emailUtil.sendAttachmentsMail("1529740851@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	   //      String rscId = "neo006";
	   // 	String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	   //  	String imgPath = "E:\\1548232727(1).jpg";
	   //  	emailUtil.sendInlineResourceMail("1529740851@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	    
	    }
}
