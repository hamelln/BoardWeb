package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository("boardDao")
public class BoardDAO {
	//JDBC관련 변수
	private Connection conn=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//sql문
	private final String BOARD_INSERT 
	        ="insert into board(seq,title,writer,content)"
			+ " values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_LIST 
	        ="select * from board order by seq desc";
	
	public  Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			System.out.println("x");
			conn= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "sa");
			if(conn!=null)
				System.out.println("성공");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void insertBoard(BoardVO vo) {
		Connection conn=null;
		try {
			conn=getConnection();
			if(conn!=null) {
			pstmt = conn.prepareStatement(BOARD_INSERT);
			int i=0;
			pstmt.setString(++i,vo.getTitle());
			pstmt.setString(++i,vo.getWriter());
			pstmt.setString(++i,vo.getContent());
			pstmt.executeUpdate();
		}else
			System.out.println("connection is null");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int i=0;
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt(++i));
				board.setTitle(rs.getString(++i));
				board.setWriter(rs.getString(++i));
				board.setContent(rs.getString(++i));
				board.setRegDate(rs.getDate(++i));
				board.setCnt(rs.getInt(++i));
				list.add(board);
			}
		}catch(Exception e) {System.out.println(e.getMessage());
		}finally {	
		}
		return list;
	}
	
	
	
}
