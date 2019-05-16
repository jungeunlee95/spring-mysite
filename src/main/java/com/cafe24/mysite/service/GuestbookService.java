package com.cafe24.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.repository.dao.GuestbookDao;
import com.cafe24.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getList(){
		return guestbookDao.getList();
	}
	
	public boolean add(GuestbookVo vo){
		return guestbookDao.insert(vo);
	}
	
	public boolean delete(GuestbookVo vo){
		return guestbookDao.delete(vo);
	}

}
