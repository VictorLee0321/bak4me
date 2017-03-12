package cn.victorlee.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Course;
import cn.victorlee.pojo.HomeworkStatus;
import cn.victorlee.pojo.Student;

/**
 * Servlet implementation class UploadFile
 */
@MultipartConfig(maxFileSize = 24 * 1024 * 1024)
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
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
		System.out.println("up load file cd do post");
		request.setCharacterEncoding("UTF-8");
		String student_id = request.getParameter("student_id");
		String student_name = request.getParameter("student_name");
		String clazz = request.getParameter("clazz");
		String course_name = request.getParameter("course_name");
		String str_exp_num = request.getParameter("exp_num");
		String fileType = request.getParameter("fileType");
		Part part_file = request.getPart("file");
		int exp_num = Integer.valueOf(str_exp_num);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (null == part_file || null == student_id || null == student_name || null == clazz || null == course_name || null == str_exp_num) {
			System.out.println("request parameter is null");
			// response wrong code
			out.println("null from request");
			out.flush();
			out.close();
		}
		System.out.println(student_id + ";" + student_name + ";" + clazz + ";" + course_name + ";" + exp_num + ";" + fileType);
		HomeworkStatus hs = new HomeworkStatus();
		Student student = null;
		try {
			student = DAOFactory.getStudentDAOInstance().findStudentByStudentID(student_id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String university = student.getUniversity();
		String last_time = null;
		char is_overtime = 'n';
		/*String file_type = null;
		String file_getContentType = part_file.getContentType();
		file_type = file_getContentType.substring(file_getContentType.lastIndexOf(".", file_getContentType.length()));*/
		String file_name = student_id + "-" + student_name + "-" + clazz + "-" + course_name + "-作业" + exp_num + "." + fileType;
		String exp_path = "/usr/local/tomcat8/webapps/back_up_file/" + university + "/" + clazz + "/" + course_name + "/" + exp_num + "/";
		Course course = null;
		String cicos_id = null;
		boolean addData = false, writeToLocal = false;
		try {
			cicos_id = DAOFactory.getFunctionDAOInstance().getCicosIDByStudentID(student_id);
			if (null != cicos_id) {
				course = DAOFactory.getCourseDAOInstance().findCourseByCicosIDCourseNameExpNum(cicos_id, course_name, exp_num);
				if (null != course) {
					last_time = course.getLast_time();
					System.out.println("last_time" + last_time);
					if (null != last_time) {
//						last_time = last_time.split(".")[0];
						last_time = last_time.substring(0, last_time.length() - 2);
						System.out.println("last_time is not null:---" + last_time);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date last_date = sdf.parse(last_time);
						Date now = new Date();
						if (last_date.before(now)) {
							is_overtime = 'y';
						}
					}
					hs.setStudent_id(student_id);
					hs.setCicos_id(cicos_id);
					hs.setCourse_name(course_name);
					hs.setExp_num(exp_num);
					hs.setFile_name(file_name);
					hs.setIs_overtime(is_overtime);
					hs.setExp_path(exp_path + file_name);
					addData = DAOFactory.getHomeworkStatusDAOInstance().updateHomeworkStatus(hs);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeToLocal = writeToLocal(part_file, file_name, exp_path);
		// if overtime is y and boolean write to local return type 0,1,wrong
		if (addData && writeToLocal) {
			if ('y' == is_overtime) {
				out.println("1");
			} else {
				out.println("0");
			}
		} else {
			out.println("error");
		}
		out.flush();
		out.close();
	}

	private boolean writeToLocal(Part part_file, String file_name, String exp_path) throws IOException {
		boolean flag = false;
		// make directory
		File f = new File(exp_path);
		try {
            if (!f.exists()) {
                f.mkdirs();
            }
        } catch (Exception e) {
            System.out.println("make directory wrong:path=" + exp_path);
            throw e;
        }
		if (f.exists()) {
			exp_path = exp_path + file_name;
			System.out.println("file path----------------" + exp_path);
			InputStream in = part_file.getInputStream();
			OutputStream out = new FileOutputStream(exp_path);
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
			f = new File(exp_path);
			if (f.exists()) {
				flag = true;
			} else {
				System.out.println("write to local fail");
			}
		}
		return flag;
	}
	
	/*private String getFilename(Part part) throws UnsupportedEncodingException {
		if (null == part) {
			return null;
		}
		String fileName = part.getHeader("content-disposition");
		// fileName = new String(fileName.getBytes(), "gbk");
		System.out.println("1--------------------" + fileName);
		
		if (0 == fileName.length())
			return null;
		fileName = fileName.substring(0, fileName.length() - 1);
		System.out.println("2--------------------" + fileName);
		
		fileName = fileName.substring(fileName.lastIndexOf("\"") + 1, fileName.length());
		System.out.println("---------------------after without \"" + fileName);
		
		return fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
	}*/

}
