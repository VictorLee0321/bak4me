package cn.victorlee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.victorlee.assist.ZipCompressorByAnt;
import cn.victorlee.factory.DAOFactory;

/**
 * Servlet implementation class CicosDownAllSubmitHomework
 */
@WebServlet("/CicosDownAllSubmitHomework")
public class CicosDownAllSubmitHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CicosDownAllSubmitHomework() {
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
		System.out.println("cicos down all submit homework cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String course_name = request.getParameter("course");
		String exp = request.getParameter("exp");
		int exp_num = Integer.valueOf(exp);
		String cicos_id = null;
		List<String> down_all_list = new ArrayList<String>();
		List<String> path_down_all_list = new ArrayList<String>();
		try {
			cicos_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			down_all_list = DAOFactory.getHomeworkStatusDAOInstance().getFileNameByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
			path_down_all_list = DAOFactory.getHomeworkStatusDAOInstance().getExpPathByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String class_name = down_all_list.get(0).split("-")[2];
		String zip_file_name = class_name + "-" + course_name  + "-" + "作业" + exp_num + ".zip";
		String pre_final_down_url = "/usr/local/tomcat8/webapps/back_up_file/";
//		pre_final_down_url = "./WebContent/";
		String final_down_url = pre_final_down_url + zip_file_name;
		String compress_dir_name = path_down_all_list.get(0).substring(0, path_down_all_list.get(0).lastIndexOf("/"));
		System.out.println("post begin compress zip......");
		ZipCompressorByAnt zcba = new ZipCompressorByAnt(final_down_url);
		zcba.compressExe(compress_dir_name);
		System.out.println("post end compress zip");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(zip_file_name);
		out.close();
		System.out.println("cicos down all finish");
	}

}
