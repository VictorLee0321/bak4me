package cn.victorlee.service;

import java.util.ArrayList;
import java.util.List;

import cn.victorlee.dao.HomeworkStatusDao;
import cn.victorlee.dao.HomeworkStatusDaoImpl;
import cn.victorlee.db.DBConnection;
import cn.victorlee.pojo.HomeworkStatus;

public class HomeworkStatusService implements HomeworkStatusDao {

	private DBConnection dbconn = null;
	private HomeworkStatusDao dao = null;

	public HomeworkStatusService() throws Exception {
		this.dbconn = new DBConnection();
		this.dao = new HomeworkStatusDaoImpl(this.dbconn.getConnection());
	}

	@Override
	public boolean addHomeworkStatus(HomeworkStatus hs) throws Exception {
		boolean flag = false;
		try {
			if (null == this.dao.findHomeworkStatus(hs.getStudent_id(), hs.getCicos_id(), hs.getCourse_name(), hs.getExp_num())) {
				flag = this.dao.addHomeworkStatus(hs);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
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
		try {
			flag = this.dao.updateHomeworkStatus(hs);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return flag;
	}

	@Override
	public HomeworkStatus findHomeworkStatus(String student_id,
			String cicos_id, String course_name, int exp_num) throws Exception {
		HomeworkStatus hs = null;
		try {
			hs = this.dao.findHomeworkStatus(student_id, cicos_id, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return hs;
	}

	@Override
	public List<String> getFileNameByStudentIDCourseName(String student_id,
			String course_name) throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getFileNameByStudentIDCourseName(student_id, course_name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<String> getFileNameByCicosIDCourseNameExpNum(String cicos_id,
			String course_name, int exp_num) throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getFileNameByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public String getExpPathByFileName(String file_name) throws Exception {
		String exp_path = null;
		try {
			exp_path = this.dao.getExpPathByFileName(file_name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return exp_path;
	}

	@Override
	public String getExpPathByStudentIDCourseNameFileName(String student_id,
			String course_name, String file_name) throws Exception {
		String exp_path = null;
		try {
			exp_path = this.dao.getExpPathByStudentIDCourseNameFileName(student_id, course_name, file_name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return exp_path;
	}

	@Override
	public List<String> getExpPathByCicosIDCourseNameExpNum(String cicos_id,
			String course_name, int exp_num) throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getExpPathByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<HomeworkStatus> getSubmitHomework(String student_id)
			throws Exception {
		List<HomeworkStatus> list = new ArrayList<HomeworkStatus>();
		try {
			list = this.dao.getSubmitHomework(student_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

	@Override
	public List<String> getOvertimeFileNameByCicosIDCourseNameExpNum(
			String cicos_id, String course_name, int exp_num) throws Exception {
		List<String> list = null;
		try {
			list = this.dao.getOvertimeFileNameByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbconn.close();
		}
		return list;
	}

}
