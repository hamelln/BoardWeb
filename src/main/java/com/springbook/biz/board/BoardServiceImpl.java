package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardDAOSpring;
import com.springbook.biz.board.impl.BoardDAOSpring2;
import com.springbook.biz.board.impl.BoardDAOSpringOracle;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	//private BoardDAO boardDao;
	//private BoardDAOSpring boardDao;
	//private BoardDAOSpring2 boardDao;
	private BoardDAOSpringOracle boardDao;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDao.insertBoard(vo);
	}
	@Override
	public void updateBoard(BoardVO vo) {
		boardDao.updateBoard(vo);
	}
	@Override
	public int deleteBoard(int seq) {
		return boardDao.deleteBoard(seq);
	}
	@Override
	public BoardVO getBoard(int seq) {
		return boardDao.getBoard(seq);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDao.getBoardList(vo);
	}
}
