package cn.victorlee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.victorlee.factory.DAOFactory;
import cn.victorlee.pojo.User;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
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
		System.out.println("check user cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String ret = "null";
		try {
			User user = DAOFactory.getUserDAOInstance().findUserByAccount(account);
			if (null != user) {
				String psw = user.getPassword();
				char is_admin = user.getIs_admin();
				char is_cicos = user.getIs_cicos();
				if (psw.equals(password)) {
					if ('y' == is_admin && 'y' == is_cicos) {
						ret = "0";
					}
					if ('y' == is_admin && 'n' == is_cicos) {
						ret = "1";
					}
					if ('n' == is_admin && 'y' == is_cicos) {
						ret = "2";
					}
					if ('n' == is_admin && 'n' == is_cicos) {
						ret = "3";
					}
				} else {
					ret = "wrong psw";
				}
			} else {
				ret = "4";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(ret);
		out.close();
	}

}
