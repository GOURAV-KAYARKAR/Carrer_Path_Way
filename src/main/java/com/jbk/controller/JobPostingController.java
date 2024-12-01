package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.JobPosting;
import com.jbk.serviceImpl.JobPostingServiceImpl;

@RestController
@RequestMapping("/job-postings")
public class JobPostingController {

	@Autowired
	JobPostingServiceImpl jobPostingServiceImpl;

	@PostMapping("/createJob")
	public String createJob(@RequestBody JobPosting jobPosting) {
		int status = jobPostingServiceImpl.createJob(jobPosting);
		switch (status) {
		case 1:
			return "Job Posted Sussfully";
		case 2:
			return "Job Post Already Exist";
		case 3:
			return "Something went Wrong";
		default:
			return "";
		}
	}
}
