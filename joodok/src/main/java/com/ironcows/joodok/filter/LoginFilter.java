package com.ironcows.joodok.filter;

import static com.ironcows.joodok.util.LoginChecker.isLogin;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	
	private String pageContext;
	
	private final Set<String> urlExclude = new HashSet<>();
	private final Set<String> srcExclude = new HashSet<>();
	
	@Override
	public void destroy() {
		
	}
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		pageContext = filterConfig.getServletContext().getContextPath();
		System.out.println("pageContext = " + pageContext);
		
		String[] excUrls = {pageContext+"/", pageContext+"/login/toLogin", pageContext+"/login/loginProcess", pageContext+"/index"};
		String[] srcUrls = {pageContext+"/resources/img", pageContext+"/resources/css", pageContext+"/resources/js"};
		
		urlExclude.addAll(Arrays.asList(excUrls));
		srcExclude.addAll(Arrays.asList(srcUrls));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//1. loginFilter 전처리 위치
		System.out.println("========= 2. 로그인 필터 진입 =========");
		String reqURI = ((HttpServletRequest)request).getRequestURI();
		
		System.out.println("reqURI = " + reqURI);
		System.out.println("isLogin = " + isLogin((HttpServletRequest)request));
		
		
		if(isLogin((HttpServletRequest)request)) {
			// 2.1 현재 로그인 중이라는 의미
			//     로그인 되어 있으면 요청을 그대로 전달한다.
			//     로그인이 되어있다는 의미의 값을 request에 추가한다.
			request.setAttribute("isLogin", "true");
			chain.doFilter(request, response);
		}else {
			//2.2 로그인 상태가 아니라는 의미
			// 1) 로그인을 시도하는 경우 ==> 로그인 시도를 그대로 전달
			//    요청 파라미터의 action 값이 login 이면 로그인 시도로 판단한다..
			int allowCnt = 0;
			for(String url : srcExclude) {
				System.out.println("srcUrl : " + url + "==============================");
				if(reqURI.startsWith(url)) {
					allowCnt++;
					break;
				}
			}
			
			if(urlExclude.contains(reqURI) || allowCnt > 0) {
				// 로그인 시도이므로 그대로 전달
				chain.doFilter(request, response);
			}else {
				// 2. 로그인 없이 기능을 요청하는 경우 
				//    기능 차단, 로그인 페이지로 이동시킨다.
				request.setAttribute("isLogin", "false");
				
				String content = "/WEB-INF/views/main/message.jsp";
				String view = "/WEB-INF/views/main/index.jsp";
				String next = pageContext + "/login/toLogin";
				
				request.setAttribute("message", "로그인 후 이용할 수 있습니다.");
				request.setAttribute("content", content);
				request.setAttribute("next", next);
				
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
		
		//3. loginFilter 후처리 위치
		System.out.println("========== 2. 로그인 필터 종료 ==========");
	}


}
