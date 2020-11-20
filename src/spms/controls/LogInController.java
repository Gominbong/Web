package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;
import spms.vo.MemberDTO;
@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding{
	MySqlMemberDao memberDao;
	
	public LogInController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao=memberDao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
			"loginInfo",spms.vo.MemberDTO.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO loginInfo = (MemberDTO) model.get("loginInfo");
		System.out.println("88888");
		if(loginInfo.getEmail() == null) {
			return "/auth/LogInForm.jsp";
		}else {
			MemberDTO member = memberDao.exist(
					loginInfo.getEmail(),
					loginInfo.getPassword());
			if(member != null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member", member); System.out.println("6666"); 
				return "redirect:../member/list.do";
				
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	}
}
