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
 * Servlet implementation class UpdatePsw
 */
@WebServlet("/UpdatePsw")
public class UpdatePsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePsw() {
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
		System.out.println("update password cd do post");
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String old_psw = request.getParameter("old_psw");
		String new_psw = request.getParameter("new_psw");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String ret = "null";
		try {
			User user = DAOFactory.getUserDAOInstance().findUserByAccount(account);
			if (null != user) {
				String psw = user.getPassword();
				if (psw.equals(old_psw)) {
					boolean isUpdatePsw = DAOFactory.getUserDAOInstance().updatePsw(account, new_psw);
					if (isUpdatePsw) {
						ret = "0";
					}
				} else {
					ret = "1";
				}
			} else {
				ret = "no this user";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(ret);
		out.close();
	}

}
