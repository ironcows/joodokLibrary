package com.ironcows.joodok.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.ironcows.joodok.util.RoleChecker;

@WebFilter(filterName="memberRoleFilter"
         , urlPatterns= {"/member/*"})
public class MemberRoleFilter implements Filter {

	private String pageContext;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		pageContext = filterConfig.getServletContext().getContextPath();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("======== 3. 접속 권한 필터 진입 =======");
		
		String role = RoleChecker.getRole(request);
		
		if("member".equals(role)) {
			//접속 권한이 librarian 이면 그대로 진행
			chain.doFilter(request, response);
		}else {
			String content = "/WEB-INF/views/main/message.jsp";
			String view = "/WEB-INF/views/main/index.jsp";
			String next = pageContext + "/index";
			
			request.setAttribute("message", "이용할 수 있는 권한이 없습니다.");
			request.setAttribute("content", content);
			request.setAttribute("next", next);
			request.getRequestDispatcher(view).forward(request, response);
			
			System.out.println("========== 3. 접속 권한 필터 종료 =========");
		}
		
	}

}
