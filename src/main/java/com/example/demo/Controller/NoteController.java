package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Note;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private Note note;	
	
	 @RequestMapping("/index")
	 public String index(Map<String,Object> map) {
	 System.out.println(note.toString());
	        return "index";
	 }

}
