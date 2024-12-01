package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Interview;
import com.jbk.serviceImpl.InterviewServiceImpl;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	InterviewServiceImpl interviewServiceImpl;

	@PostMapping("/schedule")
	public String interviewSchedule(@RequestBody Interview interview) {
		int status = interviewServiceImpl.interviewSchedule(interview);
		switch (status) {
		case 1:
			return "Interview Schedule";
		case 2:
			return "Interview Already Schedule";
		case 3:
			return "Something went wrong.";
		default:
			return "";
		}
	}

	@GetMapping("/{id}")
	public Object getInterviewById(@PathVariable long id) {
		Object obj = interviewServiceImpl.getInterviewById(id);
		return obj;
	}

	
}
