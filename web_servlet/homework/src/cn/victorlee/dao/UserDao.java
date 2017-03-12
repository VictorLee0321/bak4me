package cn.victorlee.dao;

import java.util.List;

import cn.victorlee.pojo.User;

public interface UserDao {
	
	public boolean addUser(User user) throws Exception;
	
	public boolean removeUserByAccount(String account) throws Exception;
	
	public boolean updateUser(User user) throws Exception;
	
	public boolean updatePsw(String account, String password) throws Exception;
	
	public User findUserByAccount(String account) throws Exception;
	
	public List<User> getAdmin() throws Exception;
	
	public List<User> getCicos() throws Exception;

}
