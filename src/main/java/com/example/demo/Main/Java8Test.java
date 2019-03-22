package com.example.demo.Main;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Ii;
import com.example.demo.entity.Student;

public class Java8Test {

    public static void main(String[] args) {
        //Lambda表达式
        new Thread(() -> System.out.println("hello world")).start();


        Student stu=new Student(1,"小明",33);
        Student stu1=new Student(2,"笑话",22);
        Student stu2=new Student(3,"无语",33);
        Student stu3=new Student(4,"小明",24);
        List<Student> stus=new ArrayList<Student>();
        stus.add(stu);
        stus.add(stu1);
        stus.add(stu2);
        stus.add(stu3);
        //过滤
        List<Student> stus2=stus.stream().filter(student -> student.getAge()==33).collect(Collectors.toList());

        //分组成map
        Map<String, List<Student>> groupBy = stus.stream().collect(Collectors.groupingBy(Student::getName));
        //去重
        List<Student> stus3=stus.stream().filter(distinctByKey(o -> o.getAge())).collect(Collectors.toList());




        for (int i = 0; i < stus3.size(); i++) {
            System.out.println(stus3.get(i).getName());

        }
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;

    }


	@org.junit.Test
	public void Test(@Validated Ii i){
		i.setId1(null);
	}

}
