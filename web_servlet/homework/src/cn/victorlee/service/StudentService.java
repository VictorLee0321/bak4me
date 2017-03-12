package cn.victorlee.service;

import java.util.List;

import cn.victorlee.dao.StudentDao;
import cn.victorlee.dao.StudentDaoImpl;
import cn.victorlee.db.DBConnection;
import cn.victorlee.pojo.Student;

public class StudentService implements StudentDao {
	
	private DBConnection dbconn = null;
	private StudentDao dao = null;
	
	public StudentService() throws Exception {
		this.dbconn = new DBConnection();
		this.dao = new StudentDaoImpl(this.dbconn.getConnection());
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		boolean flag = false;
		try {
			if (null == this.dao.findStudentByStudentID(student.getStudent_id())) {
				flag = this.dao.addStudent(student);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

	@Override
	public boolean removeStudentByStudentID(String student_id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student findStudentByStudentID(String student_id) throws Exception {
		Student student = null;
		try {
			student = this.dao.findStudentByStudentID(student_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return student;
	}

	@Override
	public List<Student> findStudentByStudentName(String student_name)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByUniversityClazz(String university,
			String clazz) throws Exception {
		List<Student> list = null;
		try {
			list = this.dao.getStudentByUniversityClazz(university, clazz);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

}
