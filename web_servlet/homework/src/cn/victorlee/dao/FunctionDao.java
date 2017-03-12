package cn.victorlee.dao;

import java.util.List;

import cn.victorlee.pojo.Course;

public interface FunctionDao {
	
	public String getCicosIDByStudentID(String student_id) throws Exception;
	
	// is submit
	public List<Course> getUnsubmitCourseByStudentID(String student_id) throws Exception;

}
