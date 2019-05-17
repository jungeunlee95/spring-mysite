package com.cafe24.mysite.repository.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.exception.UserDaoException;
import com.cafe24.mysite.vo.UserVo;

@Repository
public class UserDao {
	@Autowired 
	private SqlSession sqlSession;
	
//	@Autowired
//	private DataSource dataSource;

	public UserVo get(Long no) {
		return sqlSession.selectOne("user.getByNo", no);
	}

	
	// 로그인
	public UserVo get(UserVo userVo) throws UserDaoException{
		/// 파라미터로 email이랑 password왔다 치고 ///
//		String email = userVo.getEmail();
//		String password = userVo.getPassword();
//		//////////////////////////////////////////
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("email", email);
//		map.put("password", password);
//		UserVo result = sqlSession.selectOne("user.getByEmailAndPassword", map);
//		return result;
		
		UserVo result = sqlSession.selectOne("user.getByEmailAndPassword", userVo);
		return result;
				
	}
	
	public Boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		return 1==count;
	}
	
	public Boolean update(UserVo vo) {
		int count = sqlSession.update("user.update", vo);
		return 1==count;

	}
}
