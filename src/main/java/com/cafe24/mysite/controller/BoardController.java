package com.cafe24.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="")
	public String list(Model model) {
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model, BoardVo boardVo) {
		boardService.writeBoard(boardVo);
		return "redirect:/board";
	}
	
	@RequestMapping(value="/view/{no}")
	public String view(@PathVariable(value="no") Long no, Model model) {
		BoardVo boardVo = boardService.getBoardView(no);
		model.addAttribute("boardVo", boardVo);
		return "board/view";
	}
	
	@RequestMapping(value="/modify/{no}", method=RequestMethod.GET)
	public String modify(@PathVariable(value="no") Long no, Model model) {
		BoardVo boardVo = boardService.getBoardView(no);
		model.addAttribute("boardVo", boardVo);
		return "board/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVo vo, Model model) {
		boardService.modifyBoard(vo);
		BoardVo boardVo = boardService.getBoardView(vo.getNo());
		model.addAttribute("boardVo", boardVo);
		return "redirect:/board/view/"+vo.getNo();
	}
	

}













