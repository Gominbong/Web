package spms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDAO;

public class MemberDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try {
			ServletContext ctx= this.getServletContext();
			//Connection conn = (Connection) ctx.getAttribute("conn");
			
			//MemberDAO memberDao = new MemberDAO();	
			MemberDAO memberDao = (MemberDAO)ctx.getAttribute("memberDao");
			//memberDao.setConnection(conn);
			memberDao.delete(Integer.parseInt(request.getParameter("no")));
			/*
			 * conn = DriverManager.getConnection( ctx.getInitParameter("url"), //JDBC URL
			 * ctx.getInitParameter("username"), // DBMS 사용자 아이디
			 * ctx.getInitParameter("password")); // DBMS 사용자 암호
			 */
			/*
			 * stmt = conn.createStatement();
			 * stmt.executeUpdate("DELETE FROM MEMBERS WHERE MNO="+
			 * request.getParameter("no"));
			 */			response.sendRedirect("list");
		}catch(Exception e) {
			  e.printStackTrace();
		      request.setAttribute("error", e);
		      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		      rd.forward(request, response);
		}
	}
}
