package cn.victorlee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.victorlee.factory.DAOFactory;

/**
 * Servlet implementation class GetLastTime
 */
@WebServlet("/GetLastTime")
public class GetLastTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLastTime() {
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
		System.out.println("get last time cd do post");
		request.setCharacterEncoding("UTF-8");
		String university = request.getParameter("university");
		String clazz = request.getParameter("clazz");
		String course_name = request.getParameter("course_name");
		String exp_num = request.getParameter("exp_num");
		System.out.println(university + ";" + clazz + ";" + course_name + ";" + exp_num);
		String last_time = null;
		try {
			last_time = DAOFactory.getCourseDAOInstance().getLastTimeByUniversityClazzCourseNameExpNum(university, clazz, course_name, Integer.valueOf(exp_num));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*JSONObject jo = new JSONObject();
		jo.element("last_time", last_time);
		System.out.println(jo.toString());
		response.setCharacterEncoding("UTF-8");
		jo.write(response.getWriter());*/
		System.out.println(last_time);
		PrintWriter out = response.getWriter();
		out.write(last_time);
		out.close();
	}

}
