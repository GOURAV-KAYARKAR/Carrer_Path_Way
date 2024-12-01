package com.jbk.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.StudentDao;
import com.jbk.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int registerStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {
			Student dbStudent = session.get(Student.class, student.getId());
			if (dbStudent == null) {
				session.save(student);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	public int deleteStudent(long id) {
		try (Session session = sessionFactory.openSession()) {
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	public List<Student> allStudent() {
		List<Student> studentList = null;
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM Student";
			Query<Student> query = session.createQuery(hql, Student.class);
			studentList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public Student getStudentByStudentname(String studentName) {
		Student student = null;
		try (Session session = sessionFactory.openSession()) {
			Student dbstudent = session.get(Student.class, studentName);
			student = dbstudent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public int addMultipleStudent(List<Student> listStudent) {
	    Transaction transaction = null;
	    try (Session session = sessionFactory.openSession()) {
	        transaction = session.beginTransaction();

	        for (Student student : listStudent) {
	            Student dbStudent = session.get(Student.class, student.getId());
	            if (dbStudent == null) {
	                session.save(student);
	            } else {
	                // Optionally, log or handle the case where the student already exists
	                System.out.println("Student with ID " + student.getId() + " already exists.");
	            }
	        }

	        transaction.commit();
	        return 1; // Success
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        return 3; // Failure
	    }
	}


	
	public int updateStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {
			Student dbStudent = session.get(Student.class, student.getId());
			if (dbStudent != null) {
				dbStudent.setEmail(student.getEmail());
				dbStudent.setPassword(student.getPassword());
				dbStudent.setContactNumber(student.getContactNumber());

				session.update(dbStudent);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		
	}

}
