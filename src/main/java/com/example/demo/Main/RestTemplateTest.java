package com.example.demo.Main;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

public class RestTemplateTest {

	public static void main(String[] args) {
		String url = "http://localhost:8080/stu/getStudent";
		 
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
       
 //       MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
  //        restTemplate.postForObject(url, paramMap, String.class);
//        System.out.print(responseEntity.toString());
//        System.out.println();
        System.out.print(JSON.toJSONString(responseEntity.getBody())); //responseEntity.getBody()));


	}

}
