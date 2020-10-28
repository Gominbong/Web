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
/* 애노테이션을 이용하여 서블릿 배치 정보 설정
 * - 서블릿 초기화 파라미터도 애노테이션으로 처리 
 *
@WebServlet(
  urlPatterns={"/member/update"},
  initParams={
	  @WebInitParam(name="driver",value="com.mysql.jdbc.Driver"),
	  @WebInitParam(name="url",value="jdbc:mysql://localhost/studydb"),
	  @WebInitParam(name="username",value="study"),
	  @WebInitParam(name="password",value="study")
  }
)
 */
public class MemberUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		try {
			ServletContext sc= this.getServletContext();
		 //	Connection conn = (Connection)sc.getAttribute("conn");
			//MemberDAO memberDao = new MemberDAO();
			MemberDAO memberDao = (MemberDAO)sc.getAttribute("memberDao");
			//memberDao.setConnection(conn);
			MemberDTO member = memberDao.getList(Integer.parseInt(request.getParameter("no"))	);
			System.out.println("update");
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("/member/MemberUpdate.jsp");
		
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		//	request.setCharacterEncoding("UTF-8");

		try {
			ServletContext sc = this.getServletContext();
		//	Connection conn= (Connection) sc.getAttribute("conn");    
			MemberDAO memberDao = (MemberDAO)sc.getAttribute("memberDao");
		//	memberDao.setConnection(conn);

			memberDao.update(new MemberDTO().setNo(Integer.parseInt(request.getParameter("no")))
					.setName(request.getParameter("name"))
					.setEmail(request.getParameter("email"))   );
			response.sendRedirect("list");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		} 
	}
}
