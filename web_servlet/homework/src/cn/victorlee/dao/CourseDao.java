package cn.victorlee.dao;

import java.util.List;

import cn.victorlee.pojo.Course;

public interface CourseDao {
	
	public boolean addCourse(Course course) throws Exception;
	
	public boolean removeCourseByCicosIDCourseNameExpNum(String cicos_id, String course_name, int exp_num) throws Exception;
	
	public boolean updateCourse(Course course) throws Exception;
	
	public Course findCourseByCicosIDCourseNameExpNum(String cicos_id, String course_name, int exp_num) throws Exception;
	
	public List<Course> getCourseByCicosID(String cicos_id) throws Exception;

	public List<String> getUniversity() throws Exception;
	
	public List<String> getDepartmentByUniversity(String university) throws Exception;
	
	public List<String> getClazzByUniversityDepartment(String university, String department) throws Exception;
	
	public List<String> getCourseNameByUniversityClazz(String university, String clazz) throws Exception;
	
	public List<Integer> getExpNumByUniversityClazzCourseName(String university, String clazz, String course_name) throws Exception;
	
	public String getExampleNameByUniversityClazzCourseNameExpNum(String university, String clazz, String course_name, int exp_num) throws Exception;
	
	public String getLastTimeByUniversityClazzCourseNameExpNum(String university, String clazz, String course_name, int exp_num) throws Exception;

}
