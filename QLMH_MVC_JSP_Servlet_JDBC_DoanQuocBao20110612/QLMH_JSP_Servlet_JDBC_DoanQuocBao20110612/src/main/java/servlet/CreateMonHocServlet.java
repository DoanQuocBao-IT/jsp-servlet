package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import beans.MonHoc;
import conn.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;


/**
 * Servlet implementation class CreateMonHocServlet
 */
@WebServlet(urlPatterns = { "/createMonHoc" })
public class CreateMonHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateMonHocServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createMonHocView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn=DBConnection.getConnection();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String maso_monhocStr = (String) request.getParameter("maso_monhoc");
		String ten_monhoc = new String (request.getParameter("ten_monhoc").getBytes("ISO-8859-1"), "UTF-8");
		String sotinchiStr = (String) request.getParameter("sotinchi");
		int maso_monhoc = 0;
		int sotinchi = 0;
		try {
			maso_monhoc = Integer.parseInt(maso_monhocStr);
			sotinchi = Integer.parseInt(sotinchiStr);
		} catch (Exception e) {
		}
		MonHoc monhoc = new MonHoc(maso_monhoc, ten_monhoc, sotinchi);
		String errorString = null;
		String regex = "\\w+";

		if (maso_monhocStr == null || !maso_monhocStr.matches(regex)) {
			errorString = "maso_monhoc invalid!";
		}

		if (errorString == null) {
			try {
				DBUtils.insertMonhoc(conn, monhoc);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("monhoc", monhoc);
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createMonHocView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/monhocList");
		}
	}

}
