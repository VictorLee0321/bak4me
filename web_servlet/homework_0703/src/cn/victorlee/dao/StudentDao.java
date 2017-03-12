package cn.victorlee.dao;

import java.util.List;

import cn.victorlee.pojo.Student;

public interface StudentDao {

	public boolean addStudent(Student student) throws Exception;

	public boolean removeStudentByStudentID(String student_id) throws Exception;

	public boolean updateStudent(Student student) throws Exception;

	public Student findStudentByStudentID(String student_id) throws Exception;

	public List<Student> findStudentByStudentName(String student_name) throws Exception;

	public List<Student> getStudentByUniversityClazz(String university, String clazz) throws Exception;

}
