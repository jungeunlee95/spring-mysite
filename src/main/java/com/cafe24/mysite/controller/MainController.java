package com.cafe24.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.service.AdminService;
import com.cafe24.mysite.vo.SiteVo;
import com.cafe24.mysite.vo.UserVo;

@Controller
public class MainController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping({"/", "/main"})
	public String main(Model model) {
		SiteVo vo = adminService.getMain();
		model.addAttribute("site", vo);
		return "main/index";
	}
}
