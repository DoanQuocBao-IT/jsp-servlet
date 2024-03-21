package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.DBUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import beans.MonHoc;
import conn.DBConnection;

/**
 * Servlet implementation class UpdateMonHocServlet
 */
@WebServlet(urlPatterns = { "/updateMonHoc"})
public class UpdateMonHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMonHocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		int maso_monhoc=0;
		try {
			maso_monhoc=Integer.parseInt(maso_monhocStr);
		}catch(Exception e) {}
		MonHoc monhoc = null;
		String errorString = null;
		try {
			monhoc = DBUtils.findMonhoc(conn, maso_monhoc);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && monhoc == null) {
			response.sendRedirect(request.getServletPath() + "/monhocList");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("monhoc", monhoc);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/updateMonHocView.jsp");
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
		String ten_monhoc = (String) request.getParameter("ten_monhoc");
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
		try {
			DBUtils.updateMonhoc(conn, monhoc);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("monhoc", monhoc);
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/updateMonHocView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/monhocList");
		}
	}

}
