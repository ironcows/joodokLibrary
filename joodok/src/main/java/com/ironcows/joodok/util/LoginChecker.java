package com.ironcows.joodok.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginChecker {

	//현재의 요청객체에 연결된 세션이 로그인 상태인지 판별하는 유틸리티 메서드
	public static boolean isLogin(HttpServletRequest req) {
		boolean isLogin = false;
		
		// 1. 현재 요청에 연결된 세션을 얻어낸다.
		//    false 또는 argument가 없는 getSession() 메서드 사용
		HttpSession session = req.getSession(false);
		
		// 2. 세션의 존재 여부를 판별한다.
		if(session != null) {
			// 3. 세션이 존재하면, 로그인 할 때 설정한 'id' attribute 추출 시도
			//    'id'를 추출하는 이유 : memberNo, librarianNo 와 달리 공통적으로 설정된 값이므로!
			String id = (String)session.getAttribute("id");
			
			if(id != null) {
				// 4. 세션이 존재하고, id 값이 있으면 로그인 상태로 판단한다.
				isLogin = true;
			}
		}
		
		return isLogin;
	}
	
	
}
