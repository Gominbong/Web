package spms.dao;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spms.annotation.Component;
import spms.vo.MemberDTO;
@Component("memberDao")
public class MySqlMemberDao implements MemberDao{
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}
	
	
	public MemberDTO exist(String email, String password) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email",email);
		paramMap.put("password", password);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("spms.dao.MemberDao.exist",paramMap);
		} finally {
			sqlSession.close();
		}
	}

	public List<MemberDTO> selectList(HashMap<String,Object> paramMap) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("spms.dao.MemberDao.selectList",paramMap);
		}finally {
			sqlSession.close();
		}
	}

	public int insert(MemberDTO member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.insert("spms.dao.MemberDao.insert",member);
		} finally {
			sqlSession.close();
		}
	}

	public int delete(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.delete("spms.dao.MemberDao.delete",no);
			sqlSession.commit();
			return count;
		} finally {
			sqlSession.close();
		}
	}

	public int update(MemberDTO memberDto) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			MemberDTO original = sqlSession.selectOne("spms.dao.MemberDao.selectOne",memberDto.getNo());
			Hashtable<String,Object> paramMap = new Hashtable<String,Object>();
			if(!memberDto.getName().equals(original.getName())) {
				paramMap.put("name", memberDto.getName());
			}
			if(!memberDto.getEmail().equals(original.getEmail())) {
				paramMap.put("email", memberDto.getEmail());
			}
			if(paramMap.size() > 0 ) {
				paramMap.put("no", memberDto.getNo());
				int count = sqlSession.update("spms.dao.MemberDao.update",paramMap);
				sqlSession.commit();
				return count;
			}else {
				return 0;
			}
		}  finally {
			sqlSession.close();
		}
	}

	public MemberDTO selectOne(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectOne("spms.dao.MemberDao.selectOne",no);
		} finally {
			sqlSession.close();
		}
	}
}
