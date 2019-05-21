package com.cafe24.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.FindCriteria;
import com.cafe24.mysite.vo.PagingMaker;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "")
	public String list(Model model, FindCriteria fCri) {
		model.addAttribute("list", boardService.listFind(fCri));
		PagingMaker pagingMaker = new PagingMaker();
		pagingMaker.setCri(fCri);

		pagingMaker.setTotalData(boardService.findCountData(fCri));
		model.addAttribute("findCountData", boardService.findCountData(fCri));

		model.addAttribute("pagingMaker", pagingMaker);

		return "board/list";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}

	@RequestMapping(value = "/write/{no}", method = RequestMethod.GET)
	public String write(Model model, @PathVariable(value = "no") Long no) {
		model.addAttribute("groupNo", no);
		return "board/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, BoardVo boardVo) {
		if (boardVo.getGroupNo() == null) {
			boardService.writeBoard(boardVo);
		} else {
			BoardVo master = boardService.getBoardView(boardVo.getGroupNo());
			boardVo.setGroupNo(master.getGroupNo());
			boardVo.setOrderNo(master.getOrderNo());
			boardVo.setDepth(master.getDepth());
			boardService.writeReply(boardVo);
		}
		return "redirect:/board";
	}

	@RequestMapping(value = "/view/{no}")
	public String view(@PathVariable(value = "no") Long no, Model model) {
		BoardVo boardVo = boardService.getBoardView(no);
		model.addAttribute("boardVo", boardVo);
		return "board/view";
	}

	@RequestMapping(value = "/delete/{no}")
	public String delete(@PathVariable(value = "no") Long no, Model model) {
		Boolean result = null;

		BoardVo boardVo = boardService.getBoardView(no);
		System.out.println(boardVo + "###");
		if (boardVo.getMaster() == 1) {
			result = boardService.deleteMaster(boardVo.getGroupNo());
		} else {
			result = boardService.delete(no);
		}
		String message = result == true ? "success" : "fail";
		model.addAttribute("message", message);
		return "redirect:/board";
	}

	@RequestMapping(value = "/modify/{no}", method = RequestMethod.GET)
	public String modify(@PathVariable(value = "no") Long no, Model model) {
		BoardVo boardVo = boardService.getBoardView(no);
		model.addAttribute("boardVo", boardVo);
		return "board/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVo vo, Model model) {
		boardService.modifyBoard(vo);
		BoardVo boardVo = boardService.getBoardView(vo.getNo());
		model.addAttribute("boardVo", boardVo);
		return "redirect:/board/view/" + vo.getNo();
	}

}
