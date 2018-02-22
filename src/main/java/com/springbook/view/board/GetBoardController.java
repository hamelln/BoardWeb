package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		if (id == null | "".equals(id))
			mav.setViewName("redirect:login.do");
		else {
			System.out.println("글 상세 처리");
			BoardVO vo = new BoardVO();
			
			String seq = request.getParameter("seq");
			vo.setSeq(Integer.parseInt(seq));// 순번 입력
			BoardDAO dao = new BoardDAO();
			vo = dao.getBoard(vo.getSeq());// 객체 저장
			session.setAttribute("board", vo);

			mav.setViewName("getBoard");
		}
		return mav;
	}
}
