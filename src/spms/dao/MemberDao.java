package spms.dao;

import java.util.List;

import spms.vo.MemberDTO;

public interface MemberDao {
	List<MemberDTO> selectList() throws Exception;
	int insert(MemberDTO member) throws Exception;
	int delete(int no) throws Exception;
	MemberDTO selectOne(int no) throws Exception;
	int update(MemberDTO member) throws Exception;
	MemberDTO exist(String email, String password) throws Exception;

}
