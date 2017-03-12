package cn.victorlee.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.victorlee.factory.DAOFactory;

/**
 * Servlet implementation class CicosDownAllSubmitHomework
 */
@WebServlet("/OldCicosDownAllSubmitHomework")
public class OldCicosDownAllSubmitHomework extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OldCicosDownAllSubmitHomework() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cicos down all submit homework cd do get");
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
		String zip_file_name = class_name + course_name + "作业" + exp_num;
		response.setContentType("APPLICATION/OCTET-STREAM");  
		response.setHeader("Content-Disposition","attachment; filename=" + zip_file_name);
		System.out.println("in batch download......");
		ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
		int files_length = path_down_all_list.size();
		File[] files = new File[files_length];
		String one_path = null;
		for (int i = 0; i < files_length; i++) {
			one_path = path_down_all_list.get(i);
			System.out.println(one_path);
			files[i] = new File(one_path);
//			System.out.println(one_path.split("/")[7] + "compression" + i);
			zos.putNextEntry(new ZipEntry(one_path.split("/")[7]));
			FileInputStream fis = new FileInputStream(files[i]);
			byte[] buffer = new byte[1024];
			int r = 0;
//			ServletOutputStream sos = response.getOutputStream();
			while ((r = fis.read(buffer)) != -1) {
				zos.write(buffer, 0, r);
//				sos.write(buffer, 0, r);
			}
			fis.close();
//			sos.flush();
//			sos.close();
		}
		zos.flush();
		zos.close();
		System.out.println("zos close()");
//		JSONArray jsonArray = JSONArray.fromObject(list);
//		System.out.println(jsonArray.toString());
//		response.setCharacterEncoding("UTF-8");
//		jsonArray.write(response.getWriter());
	}

}
