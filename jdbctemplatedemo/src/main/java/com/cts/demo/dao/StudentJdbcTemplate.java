package com.cts.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.demo.mapper.StudentMapper;
import com.cts.demo.model.Student;

public class StudentJdbcTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	public void setDataSource(DataSource ds) {
		     this.dataSource=ds;
		     jdbcTemplate=new JdbcTemplate(ds);

	}

	public void insertStudent(String name, int marks) {
		String insertSQL="INSERT INTO student(name,marks) VALUES(?,?)";
		jdbcTemplate.update(insertSQL,name,marks);

	}

	public List<Student> listStudents() {
		String selectSQL="SELECT * from student";
		List<Student> studentList=jdbcTemplate.query(selectSQL, new StudentMapper());
		return studentList;
	}

	public void deleteStudent(int roll) {
		String deleteSQL="DELETE FROM student WHERE roll=?";
		jdbcTemplate.update(deleteSQL,roll);

	}

	public void updateStudent(int roll, int marks) {
		String updateSQL="UPDATE student set marks=?  WHERE roll=?";
		jdbcTemplate.update(updateSQL,marks,roll);

	}

}
