package spms.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDAO;
import spms.vo.MemberDTO;

public class MemberAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/member/MemberAdd.jsp");
		rd.forward(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.setCharacterEncoding("UTF-8");
		try {
			ServletContext sc = this.getServletContext();
			//Connection conn = (Connection) sc.getAttribute("conn"); 
			//MemberDAO memberDao = new MemberDAO();
			MemberDAO memberDao = (MemberDAO)sc.getAttribute("memberDao");
		   //memberDao.setConnection(conn);
			memberDao.insert(new MemberDTO().setEmail(request.getParameter("email"))
					.setPassword(request.getParameter("password"))
					.setName(request.getParameter("name"))   );
			response.sendRedirect("list");
		}catch(Exception e) {
			 e.printStackTrace();
		      request.setAttribute("error", e);
		      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		      rd.forward(request, response);
		}
		/*
		 * conn = DriverManager.getConnection( ctx.getInitParameter("url"), //JDBC URL
		 * ctx.getInitParameter("username"), // DBMS 사용자 아이디
		 * ctx.getInitParameter("password")); // DBMS 사용자 암호
		 * 
		 * 
		 * ServletContext ctx= this.getServletContext(); conn = (Connection)
		 * ctx.getAttribute("conn"); stmt = conn.prepareStatement(
		 * "INSERT INTO MEMBERS(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE)" +
		 * " VALUES (?, ?, ?, NOW(),NOW())"); stmt.setString(1,
		 * request.getParameter("email")); stmt.setString(2,
		 * request.getParameter("password")); stmt.setString(3,
		 * request.getParameter("name")); stmt.executeUpdate();
		 * response.sendRedirect("list");
		 * 
		 * 
		 * response.setContentType("text/html; charset=UTF-8"); PrintWriter out =
		 * response.getWriter(); out.println("<html><head><title>회원등록결과</title>" +
		 * "<meta http-equiv='Refresh' content='1;url=list'>" + "</head>");
		 * out.println("<body>"); out.println("<p>등록 성공입니다!</p>");
		 * out.println("</body></html>");
		 * 
		 * //response.setHeader("Refresh","1;url=list");
		 * 
		 * } catch (Exception e) { e.printStackTrace(); request.setAttribute("error",
		 * e); RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
		 * rd.forward(request, response);
		 * 
		 * }
		 */
	}
}
