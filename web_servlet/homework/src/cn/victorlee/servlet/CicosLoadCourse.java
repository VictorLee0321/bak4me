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
 * Servlet implementation class CicosLoadCourse
 */
@WebServlet("/CicosLoadCourse")
public class CicosLoadCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CicosLoadCourse() {
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
		System.out.println("cicos load course cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String cicos_id = null, judge_name = null;
		List<Course> course_list = new ArrayList<Course>();
		List<String> list = new ArrayList<String>();
		try {
			cicos_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			course_list = DAOFactory.getCourseDAOInstance().getCourseByCicosID(cicos_id);
			for (int i = 0; i < course_list.size(); i++) {
				judge_name = course_list.get(i).getCourse_name();
				if (!list.contains(judge_name)) {
					list.add(judge_name);
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
