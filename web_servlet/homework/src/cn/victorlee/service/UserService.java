package cn.victorlee.service;

import java.util.List;

import cn.victorlee.dao.UserDao;
import cn.victorlee.dao.UserDaoImpl;
import cn.victorlee.db.DBConnection;
import cn.victorlee.pojo.User;

public class UserService implements UserDao {

	private DBConnection dbconn = null;
	private UserDao dao = null;

	public UserService() throws Exception {
		this.dbconn = new DBConnection();
		this.dao = new UserDaoImpl(this.dbconn.getConnection());
	}

	@Override
	public boolean addUser(User user) throws Exception {
		boolean flag = false;
		try {
			if (null == this.dao.findUserByAccount(user.getAccount())) {
				flag = this.dao.addUser(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
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
		try {
			user = this.dao.findUserByAccount(account);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return user;
	}

	@Override
	public List<User> getAdmin() throws Exception {
		List<User> list = null;
		try {
			list = this.dao.getAdmin();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<User> getCicos() throws Exception {
		List<User> list = null;
		try {
			list = this.dao.getCicos();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public boolean updatePsw(String account, String password) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.updatePsw(account, password);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

}
