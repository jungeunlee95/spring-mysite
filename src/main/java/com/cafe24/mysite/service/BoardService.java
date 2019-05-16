package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getList() {
		return boardDao.getList();
	}
	
	public boolean write(BoardVo vo) {
		return boardDao.insert(vo);
	}
	
	public BoardVo getView(Long no) {
		return boardDao.getView(no);
	}
	
	public boolean modify(BoardVo vo) {
		return boardDao.update(vo);
	}
	
}
