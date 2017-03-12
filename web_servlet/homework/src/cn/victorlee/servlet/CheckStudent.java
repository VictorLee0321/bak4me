package cn.victorlee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Student;

/**
 * Servlet implementation class CheckStudent
 */
@WebServlet("/CheckStudent")
public class CheckStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckStudent() {
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
		System.out.println("check student cd do post");
		request.setCharacterEncoding("UTF-8");
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		System.out.println(student_id + ";" + student_name);
		String check_status = "null";
		Student student = null;
		try {
			student = DAOFactory.getStudentDAOInstance().findStudentByStudentID(student_id);
			if (null != student && student.getStudent_name().equals(student_name)) {
				check_status = "0";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(check_status);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(check_status);
		out.close();
	}

}
