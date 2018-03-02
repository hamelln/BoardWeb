package com.springbook.biz.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="BOARD3")
public class BoardVO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	                         generator="USER_SEQ_GENERATOR")
	//sequence의 자동 증가량을 50씩 증가 allocationSize=1로 하면 1씩증가
	@SequenceGenerator(name="USER_SEQ_GENERATOR",
	                   sequenceName="BOARD_SEQ",
	                   allocationSize=1)
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date regDate = new Date();
	private int cnt;
	@Transient
	private String searchCondition;
    @Transient
	private String searchKeyword;
    @Transient
	private MultipartFile uploadFile;

	private String files;
	
	//getter/setter

	public String getFiles() {return files;	}
	public void setFiles(String files) {this.files = files;	}

	public MultipartFile getUploadFile() {	return uploadFile;	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getSearchCondition() {	return searchCondition;	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {	return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public int getSeq() {	return seq;	}
	public void setSeq(int seq) {	this.seq = seq;	}
	public String getTitle() {	return title;	}
	public void setTitle(String title) {	this.title = title;	}
	public String getWriter() {	return writer;	}
	public void setWriter(String writer) {	this.writer = writer;	}
	public String getContent() {		return content;	}
	public void setContent(String content) {		this.content = content;	}
	public Date getRegDate() {		return regDate;	}
	public void setRegDate(Date regDate) {	this.regDate = regDate;	}
	public int getCnt() {	return cnt;	}
	public void setCnt(int cnt) {	this.cnt = cnt;	}
	//toString()재정의
	@Override
	public String toString() {
		return "BoardVO[seq="+seq+",title="+title+",writer="+writer+
				",content="+content+",regDate="+regDate+",cnt="+cnt+",files="+files+"]";
	}
	
}
