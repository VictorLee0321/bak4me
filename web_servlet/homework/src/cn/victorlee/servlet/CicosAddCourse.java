package cn.victorlee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Course;
import cn.victorlee.pojo.Student;

/**
 * Servlet implementation class CicosAddCourse
 */
@WebServlet("/CicosAddCourse")
public class CicosAddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CicosAddCourse() {
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
		System.out.println("cicos add course cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String course_name = request.getParameter("issue_course_name");
		int exp_num = Integer.valueOf(request.getParameter("issue_exp_num"));
		String last_time = request.getParameter("issue_last_time");
		String cicos_id = null, example_name = "example-name-no-define";
		String university = null, department = null, clazz = null, term = "2016-09-01";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String ret = "null";
		try {
			cicos_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			Student std = DAOFactory.getStudentDAOInstance().findStudentByStudentID(cicos_id);
			university = std.getUniversity();
			department = std.getDepartment();
			clazz = std.getClazz();
			Course course = new Course(cicos_id, course_name, exp_num, example_name, university, department, clazz, last_time, term);
			boolean add_flag = DAOFactory.getCourseDAOInstance().addCourse(course);
			if (add_flag) {
				ret = "0";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(ret);
		out.close();
	}

}
