package cn.victorlee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.victorlee.factory.DAOFactory;

/**
 * Servlet implementation class LoadClazz
 */
@WebServlet("/LoadClazz")
public class LoadClazz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClazz() {
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
		System.out.println("load clazz cd do post");
		request.setCharacterEncoding("UTF-8");
		String university = request.getParameter("university");
		String department = request.getParameter("department");
		List<String> list = null;
		try {
			list = DAOFactory.getCourseDAOInstance().getClazzByUniversityDepartment(university, department);
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
