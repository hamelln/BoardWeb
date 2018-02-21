package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class updateBoardController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 String view ="";
	        if(id==null|"".equals(id))
	       	 	view = "login.do";
	        else {   
	        	try {
	        		System.out.println("글 수정 처리");
		    	//1. 파라미터 받기
		    	request.setCharacterEncoding("utf-8");
		    	String title = request.getParameter("title");
		    	String content = request.getParameter("content");
		    	String seq = request.getParameter("seq");
		    	
		    	//2. DB연동처리
		    	BoardVO vo = new BoardVO();
		    	vo.setTitle(title);
		    	vo.setContent(content);
		    	vo.setSeq(Integer.parseInt(seq));
		    	
		    	BoardDAO dao = new BoardDAO();
		    	dao.updateBoard(vo);
		    	//3. 화면 이동
		    	view = "getBoardList.do";
		    		
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return view;
	}

}
