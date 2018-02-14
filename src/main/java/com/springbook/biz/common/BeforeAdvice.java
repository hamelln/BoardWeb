package com.springbook.biz.common;

//POJO객체
public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[사후 처리]비즈니스 로직 수행 후 동작");
	}
}
