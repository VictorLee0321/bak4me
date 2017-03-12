package cn.victorlee.assist;

import java.util.List;

import cn.victorlee.factory.DAOFactory;

public class GetUniversity {

	public static void main(String[] args) {
		List<String> list = null;
		try {
			list = DAOFactory.getCourseDAOInstance().getUniversity();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
