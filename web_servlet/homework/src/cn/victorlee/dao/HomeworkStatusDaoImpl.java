package cn.victorlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.victorlee.pojo.HomeworkStatus;

public class HomeworkStatusDaoImpl implements HomeworkStatusDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public HomeworkStatusDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addHomeworkStatus(HomeworkStatus hs) throws Exception {
		boolean flag = false;
		String sql = "insert into homework_status values(?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, hs.getStudent_id());
		this.pstmt.setString(2, hs.getCicos_id());
		this.pstmt.setString(3, hs.getCourse_name());
		this.pstmt.setInt(4, hs.getExp_num());
		this.pstmt.setString(5, hs.getFile_name());
		this.pstmt.setString(6, hs.getExp_time());
		this.pstmt.setString(7, hs.getIs_overtime() + "");
		this.pstmt.setString(8, hs.getExp_path());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean removeHomeworkStatus(String student_id, String cicos_id,
			String course_name, int exp_num) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHomeworkStatus(HomeworkStatus hs) throws Exception {
		boolean flag = false;
		String student_id = hs.getStudent_id();
		String cicos_id = hs.getCicos_id();
		String course_name = hs.getCourse_name();
		int exp_num = hs.getExp_num(); 
		String sql = null;
		if (null != findHomeworkStatus(student_id, cicos_id, course_name, exp_num)) {
			sql = "update homework_status set exp_time=now() where student_id=? && cicos_id=? && course_name=? && exp_num=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, student_id);
			this.pstmt.setString(2, cicos_id);
			this.pstmt.setString(3, course_name);
			this.pstmt.setInt(4, exp_num);
			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} else {
			flag = addHomeworkStatus(hs);
		}
		this.pstmt.close();
		return flag;
	}
	
	@Override
	public HomeworkStatus findHomeworkStatus(String student_id,
			String cicos_id, String course_name, int exp_num) throws Exception {
		HomeworkStatus hs = null;
		String sql = "select * from homework_status where student_id=? && cicos_id=? && course_name=? && exp_num=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student_id);
		this.pstmt.setString(2, cicos_id);
		this.pstmt.setString(3, course_name);
		this.pstmt.setInt(4, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			hs = new HomeworkStatus();
			hs.setStudent_id(rs.getString(1));
			hs.setCicos_id(rs.getString(2));
			hs.setCourse_name(rs.getString(3));
			hs.setExp_num(rs.getInt(4));
			hs.setFile_name(rs.getString(5));
			hs.setExp_time(rs.getString(6));
			hs.setIs_overtime(rs.getString(7).charAt(0));
			hs.setExp_path(rs.getString(8));
		}
		this.pstmt.close();
		return hs;
	}

	@Override
	public List<String> getFileNameByStudentIDCourseName(String student_id,
			String course_name) throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select file_name from homework_status where student_id=? && course_name=?";
		String file_name = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student_id);
		this.pstmt.setString(2, course_name);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			file_name = rs.getString(1);
			list.add(file_name);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<String> getFileNameByCicosIDCourseNameExpNum(String cicos_id,
			String course_name, int exp_num) throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select file_name from homework_status where cicos_id=? && course_name=? && exp_num=?";
		String file_name = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, cicos_id);
		this.pstmt.setString(2, course_name);
		this.pstmt.setInt(3, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			file_name = rs.getString(1);
			list.add(file_name);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public String getExpPathByFileName(String file_name) throws Exception {
		String exp_path = null;
		String sql = "select exp_path from homework_status where file_name=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, file_name);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			exp_path = rs.getString(1);
		}
		this.pstmt.close();
		return exp_path;
	}

	@Override
	public String getExpPathByStudentIDCourseNameFileName(String student_id,
			String course_name, String file_name) throws Exception {
		String exp_path = null;
		String sql = "select exp_path from homework_status where student_id=? && course_name=? && file_name=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student_id);
		this.pstmt.setString(2, course_name);
		this.pstmt.setString(3, file_name);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			exp_path = rs.getString(1);
		}
		this.pstmt.close();
		return exp_path;
	}

	@Override
	public List<String> getExpPathByCicosIDCourseNameExpNum(String cicos_id,
			String course_name, int exp_num) throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select exp_path from homework_status where cicos_id=? && course_name=? && exp_num=?";
		String exp_path = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, cicos_id);
		this.pstmt.setString(2, course_name);
		this.pstmt.setInt(3, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			exp_path = rs.getString(1);
			list.add(exp_path);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<HomeworkStatus> getSubmitHomework(String student_id)
			throws Exception {
		List<HomeworkStatus> list = new ArrayList<HomeworkStatus>();
		HomeworkStatus hs = null;
		String sql = "select * from homework_status where student_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student_id);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			hs = new HomeworkStatus();
			hs.setStudent_id(rs.getString(1));
			hs.setCicos_id(rs.getString(2));
			hs.setCourse_name(rs.getString(3));
			hs.setExp_num(rs.getInt(4));
			hs.setFile_name(rs.getString(5));
			hs.setExp_time(rs.getString(6));
			hs.setIs_overtime(rs.getString(7).charAt(0));
			hs.setExp_path(rs.getString(8));
			list.add(hs);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<String> getOvertimeFileNameByCicosIDCourseNameExpNum(
			String cicos_id, String course_name, int exp_num) throws Exception {
		List<String> list = new ArrayList<String>();
		String sql = "select file_name from homework_status where cicos_id=? && course_name=? && exp_num=? && is_overtime='y'";
		String file_name = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, cicos_id);
		this.pstmt.setString(2, course_name);
		this.pstmt.setInt(3, exp_num);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			file_name = rs.getString(1);
			list.add(file_name);
		}
		this.pstmt.close();
		return list;
	}

}
