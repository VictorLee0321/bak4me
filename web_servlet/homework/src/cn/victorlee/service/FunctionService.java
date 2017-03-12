package cn.victorlee.service;

import java.util.List;

import cn.victorlee.dao.FunctionDao;
import cn.victorlee.dao.FunctionDaoImpl;
import cn.victorlee.db.DBConnection;
import cn.victorlee.pojo.Course;

public class FunctionService implements FunctionDao {

	private DBConnection dbconn = null;
	private FunctionDao dao = null;

	public FunctionService() throws Exception {
		this.dbconn = new DBConnection();
		this.dao = new FunctionDaoImpl(this.dbconn.getConnection());
	}

	@Override
	public String getCicosIDByStudentID(String student_id) throws Exception {
		String cicos_id = null;
		try {
			cicos_id = this.dao.getCicosIDByStudentID(student_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return cicos_id;
	}
	
	// is submit
	@Override
	public List<Course> getUnsubmitCourseByStudentID(String student_id)
			throws Exception {
		List<Course> list = null;
		try {
			list = this.dao.getUnsubmitCourseByStudentID(student_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

}
