package cn.victorlee.service;

import java.util.List;

import cn.victorlee.dao.CourseDao;
import cn.victorlee.dao.CourseDaoImpl;
import cn.victorlee.db.DBConnection;
import cn.victorlee.pojo.Course;

public class CourseService implements CourseDao {

	private DBConnection dbconn = null;
	private CourseDao dao = null;

	public CourseService() throws Exception {
		this.dbconn = new DBConnection();
		this.dao = new CourseDaoImpl(this.dbconn.getConnection());
	}

	@Override
	public boolean addCourse(Course course) throws Exception {
		boolean flag = false;
		try {
			if (null == this.dao.findCourseByCicosIDCourseNameExpNum(course.getCicos_id(), course.getCourse_name(), course.getExp_num())) {
				flag = this.dao.addCourse(course);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

	@Override
	public boolean removeCourseByCicosIDCourseNameExpNum(String cicos_id,
			String course_name, int exp_num) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course findCourseByCicosIDCourseNameExpNum(String cicos_id,
			String course_name, int exp_num) throws Exception {
		Course course = null;
		try {
			course = this.dao.findCourseByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return course;
	}

	@Override
	public List<Course> getCourseByCicosID(String cicos_id) throws Exception {
		List<Course> list = null;
		try {
			list = this.dao.getCourseByCicosID(cicos_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<String> getUniversity() throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getUniversity();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<String> getDepartmentByUniversity(String university)
			throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getDepartmentByUniversity(university);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<String> getClazzByUniversityDepartment(String university,
			String department) throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getClazzByUniversityDepartment(university, department);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<String> getCourseNameByUniversityClazz(String university,
			String clazz) throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getCourseNameByUniversityClazz(university, clazz);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<Integer> getExpNumByUniversityClazzCourseName(
			String university, String clazz, String course_name)
			throws Exception {
		List<Integer> list = null;
		try {
			list = this.dao.getExpNumByUniversityClazzCourseName(university, clazz, course_name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public String getExampleNameByUniversityClazzCourseNameExpNum(
			String university, String clazz, String course_name, int exp_num)
			throws Exception {
		String example_name = null;
		try {
			example_name = this.dao.getExampleNameByUniversityClazzCourseNameExpNum(university, clazz, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return example_name;
	}

	@Override
	public String getLastTimeByUniversityClazzCourseNameExpNum(
			String university, String clazz, String course_name, int exp_num)
			throws Exception {
		String last_time = null;
		try {
			last_time = this.dao.getLastTimeByUniversityClazzCourseNameExpNum(university, clazz, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return last_time;
	}

}
