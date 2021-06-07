package com.cts.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.demo.model.Student;
// Object of StudentMapper is mapping to each record of student table
public class StudentMapper implements RowMapper<Student>
{
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setRoll(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setMarks(rs.getInt(3));
		return student;
	} 

}
