package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;
import spms.vo.MemberDTO;
@Component("/member/update.do")
public class MemberUpdateController implements Controller, DataBinding{
	MySqlMemberDao memberDao;
	public MemberUpdateController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao=memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{
			"no", Integer.class,
			"member", spms.vo.MemberDTO.class
		};
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO member = (MemberDTO)model.get("member");
		if(member.getEmail() == null) {
			Integer no = (Integer)model.get("no");
			MemberDTO detailInfo = memberDao.selectOne(no);
			model.put("member", detailInfo);
			return "/member/MemberUpdate.jsp";
		}else {
			memberDao.update(member);
			return "redirect:list.do";
		}
	}
}
