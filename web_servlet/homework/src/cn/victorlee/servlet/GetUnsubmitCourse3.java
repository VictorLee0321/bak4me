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
 * Servlet implementation class GetUnsubmitCourse3
 */
@WebServlet("/GetUnsubmitCourse3")
public class GetUnsubmitCourse3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUnsubmitCourse3() {
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
		// get unsubmit course
				System.out.println("get un submit course3 cd do post");
				request.setCharacterEncoding("UTF-8");
				String account = request.getParameter("account");
				response.setContentType("text/html;charset=UTF-8");
				List<CourseNET3> list = new ArrayList<CourseNET3>();
				try {
					String student_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
					String cicos_id = DAOFactory.getFunctionDAOInstance().getCicosIDByStudentID(student_id);
					// get class course
					List<Course> class_course_list = DAOFactory.getCourseDAOInstance().getCourseByCicosID(cicos_id);
					System.out.println("class_course_list:" + class_course_list.toString());
					// is submit, get student submit course
					List<Course> submit_course_list = DAOFactory.getFunctionDAOInstance().getUnsubmitCourseByStudentID(student_id);
					System.out.println("submit_course_list:" + submit_course_list.toString());
					// unsubmit course list
//					Collection<Course> unsubmit_course_col = CollectionUtils.subtract(class_course_list, submit_course_list);
//					System.out.println("unsubmit_course_col:" + unsubmit_course_col.toString());
					/*boolean isGetUnsubmit = */class_course_list.removeAll(submit_course_list);
					/*if (isGetUnsubmit) {*/
						List<Course> unsubmit_course_list = class_course_list;
						System.out.println("GetUnsubmitCourse:" + unsubmit_course_list.toString());
						Course course;
						for (int i = 0; i < unsubmit_course_list.size(); i++) {
							course = unsubmit_course_list.get(i);
							list.add(new CourseNET3(course.getCourse_name(), course.getExp_num(), course.getLast_time()));
						}
					/*}*/
					/*if (0 == submit_course_list.size()) {
						Course course;
						list.clear();
						for (int i = 0; i < class_course_list.size(); i++) {
							course = class_course_list.get(i);
							list.add(new CourseNET3(course.getCourse_name(), course.getExp_num(), course.getLast_time()));
						}
					}*/
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
