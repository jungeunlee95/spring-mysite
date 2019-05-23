package com.cafe24.mysite.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cafe24.mysite.vo.UserVo;

public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void insertTest() {
		UserVo vo = new UserVo();
		vo.setEmail("ccccc");
		vo.setGender("male");
		vo.setName("테스트");
		vo.setPassword("ccccc");
		System.out.println(vo);
		
		
		userDao.insert(vo)
		;
	}
	
}
