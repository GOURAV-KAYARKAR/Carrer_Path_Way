package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Student;
import com.jbk.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@PostMapping("/register")
	public String registerStudent(@RequestBody Student student) {
		int status = studentServiceImpl.registerStudent(student);
		switch (status) {
		case 1:
			return "Student added sussfully";
		case 2:
			return "Student already exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}
	
	@PostMapping("/addListStudent")
	public String addMultipleStudent(@RequestBody List<Student> liststudent) {
		int status = studentServiceImpl.addMultipleStudent(liststudent);
		switch (status) {
		case 1:
			return "Student added sussfully";
		case 2:
			return "Student already exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}


	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(name = "id") long id) {
		int status = studentServiceImpl.deleteStudent(id);
		switch (status) {
		case 1:
			return "User delete sussfully";
		case 2:
			return "User not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}
	
	@GetMapping("/allStudents")
	public List<Student> allStudent() {
		return studentServiceImpl.allStudent();
	}

	@GetMapping("/getStudent/{studentname}")
	public String getStudentByStudentname(@PathVariable(name = "Studentname") String studentName) {
		Student student = studentServiceImpl.getStudentByStudentname(studentName);
		if (student != null) {
			return student.toString();
		} else {
			return "User not found";
		}
	}
	
	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		int updateOrNot = studentServiceImpl.updateStudent(student);
		switch (updateOrNot) {
		case 1:
			return "Student update sussfully";
		case 2:
			return "Student not exist";
		case 3:
			return "Something went wrong";
		default:
			return null;
		}
		
	}
	
}
