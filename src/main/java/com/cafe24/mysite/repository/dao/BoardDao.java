package com.cafe24.mysite.repository.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired 
	private SqlSession sqlSession;
	
	
	public boolean update(BoardVo vo) {
		return 1==sqlSession.update("board.update", vo);
	}
	
	public BoardVo getView(Long no) {
		BoardVo result = sqlSession.selectOne("board.getView",no);
		return result;
	}

	public boolean insert(BoardVo vo) {
		return 1==sqlSession.insert("board.insert", vo);
	}
	
	public List<BoardVo> getList() {
		List<BoardVo> result = sqlSession.selectList("board.getList");
		return result;
	}

}
