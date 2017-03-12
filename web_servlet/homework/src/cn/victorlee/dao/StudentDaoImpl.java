package cn.victorlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.victorlee.pojo.Student;

public class StudentDaoImpl implements StudentDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public StudentDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		boolean flag = false;
		String sql = "insert into student values(?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student.getStudent_id());
		this.pstmt.setString(2, student.getStudent_name());
		this.pstmt.setString(3, student.getIs_cicos() + "");
		this.pstmt.setString(4, student.getSex() + "");
		this.pstmt.setString(5, student.getUniversity());
		this.pstmt.setString(6, student.getDepartment());
		this.pstmt.setString(7, student.getClazz());
		this.pstmt.setString(8, student.getEntrance());
		this.pstmt.setString(9, student.getGraduation());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
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
		String sql = "select * from student where student_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, student_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			student = new Student();
			student.setStudent_id(rs.getString(1));
			student.setStudent_name(rs.getString(2));
			student.setIs_cicos(rs.getString(3).charAt(0));
			student.setSex(rs.getString(4).charAt(0));
			student.setUniversity(rs.getString(5));
			student.setDepartment(rs.getString(6));
			student.setClazz(rs.getString(7));
			student.setEntrance(rs.getString(8));
			student.setGraduation(rs.getString(9));
		}
		this.pstmt.close();
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
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student where university=? and clazz=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, university);
		this.pstmt.setString(2, clazz);
		ResultSet rs = this.pstmt.executeQuery();
		Student student = null;
		while (rs.next()) {
			student = new Student();
			student.setStudent_id(rs.getString(1));
			student.setStudent_name(rs.getString(2));
			student.setIs_cicos(rs.getString(3).charAt(0));
			student.setSex(rs.getString(4).charAt(0));
			student.setUniversity(rs.getString(5));
			student.setDepartment(rs.getString(6));
			student.setClazz(rs.getString(7));
			student.setEntrance(rs.getString(8));
			student.setGraduation(rs.getString(9));
			list.add(student);
		}
		this.pstmt.close();
		return list;
	}

}
