package spms.listeners;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import spms.dao.MemberDAO;
import spms.util.DBConnectionPool;

public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool connPool;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {
			ServletContext sc = event.getServletContext();
			
			connPool = new DBConnectionPool(
					sc.getInitParameter("driver"),
					sc.getInitParameter("url"),
					sc.getInitParameter("username"),
					sc.getInitParameter("password"));
			
			MemberDAO memberDao = new MemberDAO();
			memberDao.setDbConnectionPool(connPool);
			sc.setAttribute("memberDao", memberDao);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		connPool.closeAll();
	}


	
	
}
