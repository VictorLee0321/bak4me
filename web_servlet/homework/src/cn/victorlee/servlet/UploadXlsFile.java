package cn.victorlee.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.Student;

/**
 * Servlet implementation class UploadXlsFile
 */
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
@WebServlet("/UploadXlsFile")
public class UploadXlsFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadXlsFile() {
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
		System.out.println("up load xls file cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		Part xls_file = request.getPart("xls_file");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cicos_id = null;
		char is_cicos = 'n', sex = '男';
		String university = null, department = null, clazz = null, entrance = null, graduation = null;
		String file_name = account + ".xls";
		String exp_path = null;
		boolean writeToLocal = false;
		try {
			cicos_id = DAOFactory.getUserDAOInstance().findUserByAccount(account).getStudent_id();
			Student std = DAOFactory.getStudentDAOInstance().findStudentByStudentID(cicos_id);
			university = std.getUniversity();
			department = std.getDepartment();
			clazz = std.getClazz();
			entrance = std.getEntrance();
			graduation = std.getGraduation();
			exp_path = "/usr/local/tomcat8/webapps/back_up_file/" + university + "/" + clazz + "/";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != graduation) {
			writeToLocal = writeToLocal(xls_file, file_name, exp_path);
		}
		String xls_path = null;
		if (writeToLocal) {
			boolean addStudentStatus = false;
			xls_path = exp_path + file_name;
			Sheet sheet;
			Workbook book;
			Cell student_id_cell1, student_name_cell2;
			int row;
			try {
				book = Workbook.getWorkbook(new File(xls_path));
				sheet = book.getSheet(0);
				row = 1;
				Student std = new Student();
				std.setIs_cicos(is_cicos);
				std.setSex(sex);
				std.setUniversity(university);
				std.setDepartment(department);
				std.setClazz(clazz);
				std.setEntrance(entrance);
				std.setGraduation(graduation);
				while (true) {
					student_id_cell1 = sheet.getCell(0, row);
					student_name_cell2 = sheet.getCell(1, row);
					if ("".equals(student_id_cell1.getContents())) {
						break;
					}
					std.setStudent_id(student_id_cell1.getContents());
					std.setStudent_name(student_name_cell2.getContents());
					addStudentStatus = DAOFactory.getStudentDAOInstance().addStudent(std);
					if (addStudentStatus)
						addStudentStatus = true;
					row++;
				}
				book.close();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (addStudentStatus) {
				out.println("0");
			} else {
				out.println("1");
			}
		} else {
			out.println("upload xls file fail, please retry...");
		}
		out.flush();
		out.close();
	}
	
	private boolean writeToLocal(Part part_file, String file_name, String exp_path) throws IOException {
		System.out.println("write xls file to " + exp_path);
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

}
