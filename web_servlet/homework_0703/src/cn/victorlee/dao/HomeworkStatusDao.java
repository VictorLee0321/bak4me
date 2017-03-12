package cn.victorlee.dao;

import java.util.List;

import cn.victorlee.pojo.HomeworkStatus;

public interface HomeworkStatusDao {
	
	public boolean addHomeworkStatus(HomeworkStatus hs) throws Exception;
	
	public boolean removeHomeworkStatus(String student_id, String cicos_id, String course_name, int exp_num) throws Exception;
	
	public boolean updateHomeworkStatus(HomeworkStatus hs) throws Exception;
	
	// student find his submit filename
	public List<String> getFileNameByStudentIDCourseName(String student_id, String course_name) throws Exception;
	
	// cicos find his clazz some course exp.no had submit
	public List<String> getFileNameByCicosIDCourseNameExpNum(String cicos_id, String course_name, int exp_num) throws Exception;
	
	public String getExpPathByFileName(String file_name) throws Exception;
	
	public String getExpPathByStudentIDCourseNameFileName(String student_id, String course_name, String file_name) throws Exception;
	
	// cicos get his clazz exp.no paths
	public List<String> getExpPathByCicosIDCourseNameExpNum(String cicos_id, String course_name, int exp_num) throws Exception;
	
}
