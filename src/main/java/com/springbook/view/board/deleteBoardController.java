package com.springbook.view.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class deleteBoardController implements Controller{
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
	        		System.out.println("글 삭제 처리");
	    	    	String seq = request.getParameter("seq");
	    	    	BoardDAO dao = new BoardDAO();
	    	    	int result = dao.deleteBoard(Integer.parseInt(seq));
	    	    	if(result>0)
	    	    		view = "getBoardList.do";
	    	    	else {
	    	    		PrintWriter out = response.getWriter();
	    	    		out.print("<script>");
	    	    		out.print("alert('삭제오류');");
	    	    		out.print("history.back();");
	    	    		out.print("</script>");
	    	    	}	
		    		
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return view;
	}

}
