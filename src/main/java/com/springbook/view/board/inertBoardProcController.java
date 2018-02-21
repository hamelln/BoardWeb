package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class inertBoardProcController implements Controller{
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
	        	System.out.println("글 등록 처리");
		    	//1. 파라미터 받기
		    	request.setCharacterEncoding("utf-8");
		    	String title = request.getParameter("title");
		    	String content = request.getParameter("content");
		    	String writer = request.getParameter("writer");
		    	
		    	//2.DB연동 처리
		    	BoardVO vo = new BoardVO();
		    	vo.setTitle(title);
		    	vo.setContent(content);
		    	vo.setWriter(writer);
		    	
		    	BoardDAO dao = new BoardDAO();
		    	dao.insertBoard(vo);
		    	
		    	//3. 화면이동
		    	
	        	view = "getBoardList.do";	
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return view;
	}

}
