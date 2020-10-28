package spms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.dao.MemberDAO;
import spms.vo.MemberDTO;

public class LogInServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInForm.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ServletContext sc = this.getServletContext();
			//Connection conn = (Connection) sc.getAttribute("conn"); 
			MemberDAO memberDao = (MemberDAO)sc.getAttribute("memberDao");
		//	memberDao.setConnection(conn);
			
			 
			MemberDTO member = memberDao.exist(
					request.getParameter("email"),
					request.getParameter("password"));
			if (member != null) {
				System.out.println("asd");
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("../member/list");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInFail.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}

		/*
		 * ServletContext sc =this.getServletContext(); conn =
		 * (Connection)sc.getAttribute("conn"); stmt =
		 * conn.prepareStatement("SELECT MNAME, EMAIL from MEMBERS" +
		 * " WHERE EMAIL = ? AND PWD = ? " ); stmt.setString(1,
		 * request.getParameter("email")); stmt.setString(2,
		 * request.getParameter("password")); rs = stmt.executeQuery(); if(rs.next()) {
		 * MemberDTO member = new MemberDTO().setEmail(rs.getString("EMAIL"))
		 * .setName(rs.getString("MNAME")); HttpSession session = request.getSession();
		 * session.setAttribute("member", member);
		 * response.sendRedirect("../member/list"); }else { RequestDispatcher rd =
		 * request.getRequestDispatcher("/auth/LogInFail.jsp"); rd.forward(request,
		 * response); }
		 * 
		 * }catch(Exception e) { e.printStackTrace(); request.setAttribute("error", e);
		 * RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		 * rd.forward(request, response); }finally {
		 * 
		 * try {if (rs != null) rs.close();} catch(Exception e) {} try {if (stmt !=
		 * null) stmt.close();} catch(Exception e) {}
		 * 
		 * }
		 */
	}
}
