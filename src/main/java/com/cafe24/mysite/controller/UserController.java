package com.cafe24.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.UserService;
import com.cafe24.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) {
		userService.joinUser(userVo);
		return "redirect:/user/joinsuccess";
	}
	

	@RequestMapping(value="/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="email", required=true, defaultValue="") String email, 
						@RequestParam(value="password", required=true, defaultValue="") String password,
						HttpSession session, 
						Model model) {		
		//UserVo authUser = userDao.get(email,password); 
		UserVo userVo = new UserVo(email,password);
		UserVo authUser = userService.getUser(userVo); 
		
		if(authUser == null) {
			// data 넘기기
			model.addAttribute("result","fail");
			return "user/login";
		}
		
		// session 처리
		session.setAttribute("authUser", authUser);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/update/{no}", method=RequestMethod.GET)
	public String update(@PathVariable(value="no") Long no, Model model) {
		UserVo userVo = userService.getUser(no);
		model.addAttribute("userVo", userVo);
		return "user/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute UserVo userVo) {
		userService.updateUser(userVo);
		
		return "redirect:/user/updatesuccess";
	}
	
	@RequestMapping(value="/updatesuccess")
	public String updatesuccess(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "user/updatesuccess";
	}
	

}

  












