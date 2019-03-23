package com.example.demo.Controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DownController {

    @RequestMapping("/down")
    public void cooperation(HttpServletRequest request, HttpServletResponse response)  throws  Exception {
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .getBytes(), "UTF-8");
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");
        writer.write0(getListString(), sheet1);
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
        out.flush();
        writer.finish();
    }


    public List<List<String>>  getListString(){
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
//        List<List<String>> head = new ArrayList<List<String>>();
//        List<String> headCoulumn1 = new ArrayList<String>();
//        List<String> headCoulumn2 = new ArrayList<String>();
//        List<String> headCoulumn3 = new ArrayList<String>();
//        headCoulumn1.add("第一列");
//        headCoulumn2.add("第二列");
//        headCoulumn3.add("第三列");
//        head.add(headCoulumn1);
//        head.add(headCoulumn2);
//        head.add(headCoulumn3);
        return data;
    }



}
