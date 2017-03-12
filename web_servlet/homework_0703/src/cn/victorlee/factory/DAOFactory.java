package cn.victorlee.factory;

import cn.victorlee.dao.CourseDao;
import cn.victorlee.dao.StudentDao;
import cn.victorlee.dao.UserDao;
import cn.victorlee.service.CourseService;
import cn.victorlee.service.StudentService;
import cn.victorlee.service.UserService;

public class DAOFactory {
	
	public static StudentDao getStudentDAOInstance() throws Exception {
		return new StudentService();
	}
	
	public static UserDao getUserDAOInstance() throws Exception {
		return new UserService();
	}
	
	public static CourseDao getCourseDAOInstance() throws Exception {
		return new CourseService();
	}

}
