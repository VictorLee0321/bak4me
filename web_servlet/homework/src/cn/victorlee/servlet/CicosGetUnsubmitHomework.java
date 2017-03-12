package cn.victorlee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Student;
import cn.victorlee.pojo.StudentIDN2;

/**
 * Servlet implementation class CicosGetUnsubmitHomework
 */
@WebServlet("/CicosGetUnsubmitHomework")
public class CicosGetUnsubmitHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CicosGetUnsubmitHomework() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cicos get un submit homework cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String course_name = request.getParameter("course");
		String exp = request.getParameter("exp");
		int exp_num = Integer.valueOf(exp);
		String cicos_id = null, university = null, clazz = null;
		Student std = new Student();
		List<String> submit_file_name_list = new ArrayList<String>();
		List<Student> class_student_list = new ArrayList<Student>();
		List<StudentIDN2> list = new ArrayList<StudentIDN2>();
		try {
			// cicos_id is student_id of cicos
			cicos_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			std = DAOFactory.getStudentDAOInstance().findStudentByStudentID(cicos_id);
			university = std.getUniversity();
			clazz = std.getClazz();
			class_student_list = DAOFactory.getStudentDAOInstance().getStudentByUniversityClazz(university, clazz);
			List<StudentIDN2> studentidn2_class_list = new ArrayList<StudentIDN2>();
			for (int i = 0; i < class_student_list.size(); i++) {
				studentidn2_class_list.add(new StudentIDN2(class_student_list.get(i).getStudent_id(), class_student_list.get(i).getStudent_name()));
			}
			submit_file_name_list = DAOFactory.getHomeworkStatusDAOInstance().getFileNameByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
			List<StudentIDN2> studentidn2_submit_list = new ArrayList<StudentIDN2>();
			for (int i = 0; i < submit_file_name_list.size(); i++) {
				studentidn2_submit_list.add(new StudentIDN2(submit_file_name_list.get(i).split("-")[0], submit_file_name_list.get(i).split("-")[1]));
			}
			studentidn2_class_list.removeAll(studentidn2_submit_list);
			list = studentidn2_class_list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
		response.setCharacterEncoding("UTF-8");
		jsonArray.write(response.getWriter());
	}

}
