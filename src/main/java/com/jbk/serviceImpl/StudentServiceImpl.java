package com.jbk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.StudentDaoImpl;
import com.jbk.entities.Student;
import com.jbk.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	@Override
	public int registerStudent(Student student) {
		int status = studentDaoImpl.registerStudent(student);
		return status;
	}

	public int deleteStudent(long id) {
		int status = studentDaoImpl.deleteStudent(id);
		return status;
	}

	public List<Student> allStudent() {
		return studentDaoImpl.allStudent();
	}

	public Student getStudentByStudentname(String studentName) {
		return studentDaoImpl.getStudentByStudentname(studentName);
	}

	public int addMultipleStudent(List<Student> liststudent) {
		int status = studentDaoImpl.addMultipleStudent(liststudent);
		return status;
	}
	
	public int updateStudent(Student student) {
		int updateOrNot = studentDaoImpl.updateStudent(student);
		return updateOrNot;
		
	}

}
