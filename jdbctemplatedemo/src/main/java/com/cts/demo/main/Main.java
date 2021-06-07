package com.cts.demo.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.demo.dao.StudentJdbcTemplate;
import com.cts.demo.model.Student;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		StudentJdbcTemplate studentTemplate=(StudentJdbcTemplate)context.getBean("studentJdbcTemplate");
	    Scanner scanner=new Scanner(System.in);
		/*
		 * System.out.println("Enter student's name"); String name=scanner.next();
		 * System.out.println("Enter student's marks"); int marks=scanner.nextInt();
		 * studentTemplate.insertStudent(name, marks);
		 */
	    // System.out.println("Enter the student roll number to delete");
		/*
		 * int rollToDelete=scanner.nextInt();
		 * studentTemplate.deleteStudent(rollToDelete);
		 */
	   List<Student> studentList=studentTemplate.listStudents();
	   for(Student stu : studentList)
	   {
		   System.out.println(stu.getRoll()+"\t"+stu.getName()+"\t"+stu.getMarks());
	   }
	   
	   System.out.println("Enter the roll number which you want to update");
	   int roll=scanner.nextInt();
	   System.out.println("Enter the marks which you want to change");
	   int marks=scanner.nextInt();
	   studentTemplate.updateStudent(roll, marks);
	   System.out.println("Updated result!!!!!!!!!!!!!!!");
	   studentList=studentTemplate.listStudents();
	   for(Student stu : studentList)
	   {
		   System.out.println(stu.getRoll()+"\t"+stu.getName()+"\t"+stu.getMarks());
	   }
	   
	}

}
