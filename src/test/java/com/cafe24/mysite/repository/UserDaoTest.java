package com.cafe24.mysite.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.mysite.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
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
		
		
		userDao.insert(vo);
	}
	
}
