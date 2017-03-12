package cn.victorlee.assist;

import java.util.List;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Student;

public class GetStudentByClazz {

	public static void main(String[] args) {
		List<Student> list =  null;
		Student student = null;
		try {
			list = DAOFactory.getStudentDAOInstance().getStudentByUniversityClazz("仲恺农业工程学院", "信计133班");
//			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			student = list.get(i);
			System.out.println(student);
		}
	}

}
