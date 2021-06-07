package com.cts.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cts.demo.model.Student;

public interface StudentDAO {
	public void setDataSource(DataSource ds);
	public void insertStudent(String name, int marks);
    public List<Student> listStudents();
    public void deleteStudent(int roll);
    public void updateStudent(int roll, int marks);
 }
