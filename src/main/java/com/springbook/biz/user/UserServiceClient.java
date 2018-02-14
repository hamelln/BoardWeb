package com.springbook.biz.user;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		//1.Spring 컨테이너 구동
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("annotationContext.xml");
		//2.Spring 컨테이너로부터 UserServieImpl 객체 lookup
		UserService userService =
				(UserService)container.getBean("userService");
		
		//3. 로그인 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user!=null)
			System.out.println(user.getName()+"님 환영합니다.");
		else
			System.out.println("로그인 실패");
		
		//4. 사용자 추가 테스트
		Scanner scanner = new Scanner(System.in);
		/*vo.setId("hong");
		vo.setPassword("1234");
		vo.setName("홍길동");
		vo.setRole("User");
	*/	
		 vo.setId(scanner.next());
		 vo.setPassword(scanner.next());
		 vo.setName(scanner.next());
		 vo.setRole(scanner.next());
		 
		user = userService.setUser(vo);
		
		System.out.println(user);
		
		
		
	   //4. Spring 컨테이너 종료.
		container.close();

	}

}
