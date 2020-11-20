package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;
import spms.vo.MemberDTO;
@Component("/member/add.do")
public class MemberAddController implements Controller, DataBinding{
	MySqlMemberDao memberDao;

	public MemberAddController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public Object[] getDataBinders() {
		return new Object[] {
			"member",spms.vo.MemberDTO.class
		};
	}
	@Override 
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO member = (MemberDTO)model.get("member");
		if (member.getEmail() == null) {
			System.out.println("33");
			return "/member/MemberAdd.jsp";
		} else {
			System.out.println("44");
		    memberDao.insert(member);
			return "redirect:list.do";
		}
	}
}
