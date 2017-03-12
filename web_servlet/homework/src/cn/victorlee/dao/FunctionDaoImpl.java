package cn.victorlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Course;
import cn.victorlee.pojo.HomeworkStatus;

public class FunctionDaoImpl implements FunctionDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public FunctionDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public String getCicosIDByStudentID(String student_id) throws Exception {
		String cicos_id = null;
		String sql = null, university = null, department = null, clazz = null;
		sql = "select university, department, clazz from student where student_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			university = rs.getString(1);
			department = rs.getString(2);
			clazz = rs.getString(3);
		}
		if (null != university && null != department && null != clazz) {
			sql = "select distinct cicos_id from course where  university=? && department=? && clazz=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, university);
			this.pstmt.setString(2, department);
			this.pstmt.setString(3, clazz);
			rs = this.pstmt.executeQuery();
			if (rs.next()) {
				cicos_id = rs.getString(1);
			}
		}
		this.pstmt.close();
		return cicos_id;
	}
	
	// is submit
	@Override
	public List<Course> getUnsubmitCourseByStudentID(String student_id)
			throws Exception {
		List<Course> list = new ArrayList<Course>();
		List<HomeworkStatus> hs_list = new ArrayList<HomeworkStatus>();
		hs_list = DAOFactory.getHomeworkStatusDAOInstance().getSubmitHomework(student_id);
		if (null != hs_list) {
			String cicos_id = null, course_name = null;
			int exp_num = 0;
			Course course = null;
			ResultSet rs;
			String sql = "select * from course where cicos_id=? and course_name=? and exp_num=?";
			this.pstmt = this.conn.prepareStatement(sql);
			for (int i = 0; i < hs_list.size(); i++) {
				cicos_id = hs_list.get(i).getCicos_id();
				course_name = hs_list.get(i).getCourse_name();
				exp_num = hs_list.get(i).getExp_num();
				this.pstmt.setString(1, cicos_id);
				this.pstmt.setString(2, course_name);
				this.pstmt.setInt(3, exp_num);
				rs = this.pstmt.executeQuery();
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
			}
			this.pstmt.close();
		}
		return list;
	}

}
