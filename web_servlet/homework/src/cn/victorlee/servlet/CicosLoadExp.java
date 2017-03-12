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

/**
 * Servlet implementation class CicosLoadExp
 */
@WebServlet("/CicosLoadExp")
public class CicosLoadExp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CicosLoadExp() {
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
		System.out.println("cicos load exp cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String course_name = request.getParameter("course");
		String cicos_id = null;
		List<Course> course_list = new ArrayList<Course>();
		List<Integer> list = new ArrayList<Integer>();
		Course course = new Course();
		try {
			cicos_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			course_list = DAOFactory.getCourseDAOInstance().getCourseByCicosID(cicos_id);
			for (int i = 0; i < course_list.size(); i++) {
				course = course_list.get(i);
				if (course_name.equals(course.getCourse_name())) {
					list.add(course.getExp_num());
				}
			}
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
