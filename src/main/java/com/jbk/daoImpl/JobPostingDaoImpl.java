package com.jbk.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.JobPostingDao;
import com.jbk.entities.JobPosting;

@Repository
public class JobPostingDaoImpl implements JobPostingDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int createJob(JobPosting jobPosting) {
		try (Session session = sessionFactory.openSession()) {
			JobPosting dbJobPost = session.get(JobPosting.class, jobPosting.getId());
			if (dbJobPost == null) {
				session.save(jobPosting);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 3;
		}
	}

}
