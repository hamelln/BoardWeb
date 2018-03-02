package com.springbook.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOJPA{
	@PersistenceContext
	private EntityManager em;
	
	//CRUD 기능 메소드 구현
	//글등록
	public void insertBoard(BoardVO vo) {
		 System.out.println("===> Spring JPA insertBoard() 기능 처리");
		 em.persist(vo);//입력메소드
	}
	//글 목록 리스트
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JPA getBoardList() 기능 처리");
		 String jqpl = "select b from BoardVO b order by b.seq desc";
		 return em.createQuery(jqpl).getResultList();  
	}
	//BOARD수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JPA updateBoard() 기능 처리");
		em.merge(vo);
	} 
	//상세정보
	public BoardVO getBoard(int seq) {
		System.out.println("===> Spring JPA getBoard() 기능 처리");
		BoardVO vo = em.find(BoardVO.class, seq);//객체 구하기
		vo.setCnt(vo.getCnt()+1);//구한 객체의 count증가 
		updateBoard(vo);//updateBoard()메소드 호출
		return vo;
	}

	//삭제 메소드
	public int deleteBoard(int seq) {
		 System.out.println("===> Spring JPA deleteBoard("+seq+") 기능 처리");
		 em.remove(em.find(BoardVO.class, seq));
		 return 1;
	}
}
