package com.example.demo.Controller;



import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.Service.IiService;
import com.example.demo.entity.Ii;



@Controller
public class Yemian {

		@Autowired
		private IiService service;	
	
	
	
	 @RequestMapping("/index2")
	 	public String index2(Map<String,Object> map) {
		 map.put("hello","hello");
	        return "index2";
	    }
	 	
	 	@RequestMapping("/index")
	 	public String index(Map<String,Object> map) {
		 //map.put("Ii",service.Select());
		// System.out.println("xxx22222");
	 		service.Select();		
		//  service.insert2();
	        return "index";
	    }
	 
	 @RequestMapping("/update")
	 	public String update(Map<String,Object> map) {
		 service.updateMnoticeconfig();
		 return "index";
	 }
	     /*
		 * Optional<String> 参数可传可不传
		 * */
		@RequestMapping("/insert")
		public  String  insert( Ii i,String  userName){
			System.out.println(i.getId3());
			service.insert(i);
			return "redirect:/index";
		}
		@RequestMapping("/delete")
		public  String  delete(String id ){
			if(StringUtils.isNotBlank(id)  ){
				service.delete(id);
				
			}
			return "redirect:/index";
			
			
		}
	 
}