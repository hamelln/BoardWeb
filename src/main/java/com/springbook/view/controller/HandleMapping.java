package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.LogoutController;
import com.springbook.view.board.deleteBoardController;
import com.springbook.view.board.inertBoardController;
import com.springbook.view.board.inertBoardProcController;
import com.springbook.view.board.updateBoardController;
import com.springbook.view.user.LoginController;

public class HandleMapping {
	private Map<String, Controller> mappings;
	
	public HandleMapping() {
		mappings = new HashMap<>();
		mappings.put("/login.do",new LoginController());
		mappings.put("/getBoardList.do",new GetBoardListController());
		mappings.put("/getBoard.do",new GetBoardController());
		mappings.put("/insertBoard.do",new inertBoardController());
		mappings.put("/insertBoardProc.do",new inertBoardProcController());
		mappings.put("/updateBoard.do",new updateBoardController());
		mappings.put("/deleteBoard.do",new deleteBoardController());
		mappings.put("/logout.do",new LogoutController());
		
	}
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
