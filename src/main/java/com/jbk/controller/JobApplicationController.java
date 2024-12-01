package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.JobApplication;
import com.jbk.serviceImpl.JobApplicationServiceImpl;

@RestController
@RequestMapping("/jobApplication")
public class JobApplicationController {

	@Autowired
	JobApplicationServiceImpl jobApplicationServiceImpl;

	@PostMapping("/apply")
	public String applayForJob(@RequestBody JobApplication jobApplication) {
		int status = jobApplicationServiceImpl.applayForJob(jobApplication);
		switch (status) {
		case 1:
			return "Application successful";
		case 2:
			return "You have already applied for this position.";
		case 3:
			return "Something went wrong.";
		default:
			return "";
		}
	}
}
