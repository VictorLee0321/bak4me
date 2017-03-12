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
import cn.victorlee.pojo.Course;
import cn.victorlee.pojo.CourseNET3;

/**
 * Servlet implementation class GetSubmitCourse3
 */
@WebServlet("/GetSubmitCourse3")
public class GetSubmitCourse3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubmitCourse3() {
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
		System.out.println("get submit course cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		response.setContentType("text/html;charset=UTF-8");
		List<CourseNET3> list = new ArrayList<CourseNET3>();
		try {
			String student_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			// is submit
			List<Course> course_list = DAOFactory.getFunctionDAOInstance().getUnsubmitCourseByStudentID(student_id);
			for (int i = 0; i < course_list.size(); i++) {
				list.add(new CourseNET3(course_list.get(i).getCourse_name(), course_list.get(i).getExp_num(), course_list.get(i).getLast_time()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != list) {
			JSONArray jsonArray = JSONArray.fromObject(list);
			System.out.println(jsonArray.toString());
			jsonArray.write(response.getWriter());
		}
	}

}
