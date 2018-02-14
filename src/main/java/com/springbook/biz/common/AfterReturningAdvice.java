package com.springbook.biz.common;

//POJO객체
public class AfterReturningAdvice {
	public void afterLog() {
		System.out.println("[사전 처리]비즈니스 로직 수행전 동작");
	}
}
