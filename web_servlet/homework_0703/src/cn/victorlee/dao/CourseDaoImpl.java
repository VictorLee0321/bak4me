package cn.victorlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.victorlee.pojo.Course;

public class CourseDaoImpl implements CourseDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public CourseDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addCourse(Course course) throws Exception {
		boolean flag = false;
		String sql = "insert into course values(?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, course.getCicos_id());
		this.pstmt.setString(2, course.getCourse_name());
		this.pstmt.setInt(3, course.getExp_num());
		this.pstmt.setString(4, course.getExample_name());
		this.pstmt.setString(5, course.getUniversity());
		this.pstmt.setString(6, course.getDepartment());
		this.pstmt.setString(7, course.getClazz());
		this.pstmt.setString(8, course.getLast_time());
		this.pstmt.setString(9, course.getTerm());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
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
		String sql = "select * from course where cicos_id=? && course_name=? && exp_num=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, cicos_id);
		this.pstmt.setString(2, course_name);
		this.pstmt.setInt(3, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			course = new Course();
			course.setCicos_id(rs.getString(1));
			course.setCourse_name(rs.getString(2));
			course.setExp_num(rs.getInt(3));
			course.setExample_name(rs.getString(4));
			course.setUniversity(rs.getString(5));
			course.setDepartment(rs.getString(6));
			course.setClazz(rs.getString(7));
			course.setLast_time(rs.getString(8));
			course.setTerm(rs.getString(9));
		}
		this.pstmt.close();
		return course;
	}
	
	@Override
	public List<Course> getCourseByCicosID(String cicos_id) throws Exception {
		List<Course> list = new ArrayList<Course>();
		Course course = null;
		String sql = "select * from course where cicos_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, cicos_id);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			course = new Course();
			course.setCicos_id(rs.getString(1));
			course.setCourse_name(rs.getString(2));
			course.setExp_num(rs.getInt(3));
			course.setExample_name(rs.getString(4));
			course.setUniversity(rs.getString(5));
			course.setDepartment(rs.getString(6));
			course.setClazz(rs.getString(7));
			course.setLast_time(rs.getString(8));
			course.setTerm(rs.getString(9));
			list.add(course);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<String> getUniversity() throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct university from course";
		String university = null;
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			university = rs.getString(1);
			list.add(university);
		}
		return list;
	}

	@Override
	public List<String> getDepartmentByUniversity(String university)
			throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct department from course where university=?";
		String department = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			department = rs.getString(1);
			list.add(department);
		}
		return list;
	}

	@Override
	public List<String> getClazzByUniversityDepartment(String university,
			String department) throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct clazz from course where university=? && department=?";
		String clazz = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		this.pstmt.setString(2, department);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			clazz = rs.getString(1);
			list.add(clazz);
		}
		return list;
	}

	@Override
	public List<String> getCourseNameByUniversityClazz(String university,
			String clazz) throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select distinct course_name from course where university=? && clazz=?";
		String course_name = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		this.pstmt.setString(2, clazz);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			course_name = rs.getString(1);
			list.add(course_name);
		}
		return list;
	}

	@Override
	public List<Integer> getExpNumByUniversityClazzCourseName(String university,
			String clazz, String course_name) throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		String sql = "select exp_num from course where university=? && clazz=? && course_name=?";
		int exp_num = 0;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		this.pstmt.setString(2, clazz);
		this.pstmt.setString(3, course_name);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			exp_num = rs.getInt(1);
			list.add(exp_num);
		}
		return list;
	}

	@Override
	public String getExampleNameByUniversityClazzCourseNameExpNum(String university,
			String clazz, String course_name, int exp_num) throws Exception {
		String example_name = null;
		String sql = "select example_name from course where university=? && clazz=? && course_name=? && exp_num=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		this.pstmt.setString(2, clazz);
		this.pstmt.setString(3, course_name);
		this.pstmt.setInt(4, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			example_name = rs.getString(1);
		}
		return example_name;
	}

	@Override
	public String getLastTimeByUniversityClazzCourseNameExpNum(
			String university, String clazz, String course_name, int exp_num)
			throws Exception {
		String last_time = null;
		String sql = "select last_time from course where university=? && clazz=? && course_name=? && exp_num=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		this.pstmt.setString(2, clazz);
		this.pstmt.setString(3, course_name);
		this.pstmt.setInt(4, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			last_time = rs.getString(1);
		}
		return last_time;
	}

}
