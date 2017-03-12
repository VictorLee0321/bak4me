package cn.victorlee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.victorlee.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		boolean flag = false;
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getAccount());
		this.pstmt.setString(2, user.getPassword());
		this.pstmt.setString(3, user.getIs_admin() + "");
		this.pstmt.setString(4, user.getIs_cicos() + "");
		this.pstmt.setString(5, user.getStudent_id());
		this.pstmt.setString(6, user.getStudent_name());
		this.pstmt.setString(7, user.getEmail());
		this.pstmt.setString(8, user.getRegister_time());
		this.pstmt.setString(9, user.getStatus() + "");
		this.pstmt.setString(10, user.getValidate_code());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean removeUserByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserByAccount(String account) throws Exception {
		User user = null;
		String sql = "select * from user where account=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, account);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setAccount(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setIs_admin(rs.getString(3).charAt(0));
			user.setIs_cicos(rs.getString(4).charAt(0));
			user.setStudent_id(rs.getString(5));
			user.setStudent_name(rs.getString(6));
			user.setEmail(rs.getString(7));
			user.setRegister_time(rs.getString(8));
			user.setStatus(rs.getString(9).charAt(0));
			user.setValidate_code(rs.getString(10));
		}
		this.pstmt.close();
		return user;
	}

	@Override
	public List<User> getAdmin() throws Exception {
		List<User> list = new ArrayList<User>();
		User user = null;
		String sql = "select * from user where is_admin=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "y");
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setAccount(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setIs_admin(rs.getString(3).charAt(0));
			user.setIs_cicos(rs.getString(4).charAt(0));
			user.setStudent_id(rs.getString(5));
			user.setStudent_name(rs.getString(6));
			user.setEmail(rs.getString(7));
			user.setRegister_time(rs.getString(8));
			user.setStatus(rs.getString(9).charAt(0));
			user.setValidate_code(rs.getString(10));
			list.add(user);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public List<User> getCicos() throws Exception {
		List<User> list = new ArrayList<User>();
		User user = null;
		String sql = "select * from user where is_cicos=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "y");
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setAccount(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setIs_admin(rs.getString(3).charAt(0));
			user.setIs_cicos(rs.getString(4).charAt(0));
			user.setStudent_id(rs.getString(5));
			user.setStudent_name(rs.getString(6));
			user.setEmail(rs.getString(7));
			user.setRegister_time(rs.getString(8));
			user.setStatus(rs.getString(9).charAt(0));
			user.setValidate_code(rs.getString(10));
			list.add(user);
		}
		this.pstmt.close();
		return list;
	}

}
