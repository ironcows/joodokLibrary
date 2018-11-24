package com.ironcows.joodok.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RoleChecker {
	public static String getRole(ServletRequest req) {
		//1. 현재 요청에 연결된 세션을 얻어냄
		//   false 또는 argument가 없는 getSession() 메서드를 사용
		
		HttpSession session = ((HttpServletRequest)req).getSession();
		String role = (String) session.getAttribute("role");
		
		return role;
	}
}
