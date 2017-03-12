package cn.victorlee.assist;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Student;

public class InsertStudent {

	public static void main(String[] args) {
		Student student = null;
		String last2 = null;
		String[] nameArr = {"000","曹森钜","陈法宇","陈剑华","陈子亮","程淑玲","冯伟豪","符贻杰","何承璠","胡斌","胡照强","黄家欣","黄珉琳","黄明智","李鸿","李明钊","梁家琪","林远梓","林跃","刘林海","刘晚枫","卢家盛","罗少雄","任浩鹏","谭舒朗","谭振繁","王佳伟","吴洪林","吴龙韬","吴梦亮","武佩云","曾杰超","张沅婷","周星海","朱静文","邹乐涛","朱勇标","林业办"};
		try {
			for (int i = 1; i < 38; i++) {
				student = new Student();
				if (15 == i)
					continue;
				if (i < 10)
					last2 = "0" + i;
				else
					last2 = "" + i;
				student.setStudent_id("2013213143" + last2);
				student.setStudent_name(nameArr[i]);
				/*student.setIs_cicos(rs.getString(3).charAt(0));
				student.setSex(rs.getString(4).charAt(0));*/
				student.setUniversity("仲恺农业工程学院");
				student.setDepartment("计算科学学院");
				student.setClazz("信计133班");
				/*student.setEntrance(rs.getString(8));
				student.setGraduation(rs.getString(9));*/
				DAOFactory.getStudentDAOInstance().addStudent(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
