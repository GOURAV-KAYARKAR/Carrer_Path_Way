package com.jbk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.JobPostingDaoImpl;
import com.jbk.entities.JobPosting;
import com.jbk.service.JobPostingService;

@Service
public class JobPostingServiceImpl implements JobPostingService {

	@Autowired
	JobPostingDaoImpl jobPostingDaoImpl;

	@Override
	public int createJob(JobPosting jobPosting) {
		int status = jobPostingDaoImpl.createJob(jobPosting);
		return status;
	}

}
