package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.view.controller.Controller;

public class LogoutController implements Controller{
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
	        		System.out.println("로그아웃 처리");
	    	    	//세션 종료 처리
	    	    	session.invalidate();
	    	    	// 로그인 화면으로 이동
	    	    	view = "login";	
	        	}catch(Exception e) {System.out.println(e.getMessage());}
	        }  
    	return view;
	}

}
