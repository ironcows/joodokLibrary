package com.ironcows.joodok.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironcows.joodok.dto.Librarian;
import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.service.LoginServiceIf;



@Controller(value="loginController")
@RequestMapping(value="/login")
public class LoginController implements LoginControllerIf {

	
	//필요한 service 들을 가져온다.
	
	/**
	 * LoginService 에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="loginService")
	private LoginServiceIf service;
	
	
	@Override
	@RequestMapping(value="/toLogin", method=RequestMethod.GET)
	public String toLogin(Model model) {
		model.addAttribute("content", "/WEB-INF/views/login/login.jsp");
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}
	
	
	@Override
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String login(HttpServletRequest req
					  , @RequestParam("id") String id
					  , @RequestParam("pw") String pw
					  , @RequestParam("role") String role
					  , Model model) {
		
		// id, pw 입력 여부는 page 에서 검사하므로 여기선
		// id, pw가 입력이 되어있는 경우만을 작성
		HttpSession session = req.getSession();
		
		// member 인지, librarian 인지 role 파라미터를 통해 분기
		if(role.equals("member")) {
			//member 로그인 일 경우
			
			//포장용 객체 member, 로그인 결과도 처리할 객체임.
			Member member = new Member();
			member.setId(id);
			member.setPassword(pw);
			
			//service 로 로그인 시도
			member = service.loginMember(member);
			
			if(member != null) {
				//로그인 성공한 경우
				//session 에 로그인 정보를 저장
				session.setAttribute("memberNo", member.getMemberNo());
				session.setAttribute("id", member.getId());
				session.setAttribute("name", member.getName());
				session.setAttribute("role", role);
				
				//로그인 성공 화면과 이후에 이동할 페이지에 대한 설정
				model.addAttribute("message", member.getId() + "(" + member.getName() + ")" + "님 로그인 되었습니다.");
				model.addAttribute("next", "/index");
				
			}else {
				//로그인 실패한 경우
				//로그인 실패 화면에 대한 설정(로그인 화면으로 다시 이동시킨다.)
				model.addAttribute("message", "ID 또는 PASSWORD 가 일치하지 않습니다.");
				model.addAttribute("next", "/login/toLogin");
			}
		//end member if else
		}else if(role.equals("librarian")) {
			//librarian 로그인 일 경우
			
			//포장용 객체 librarian, 로그인 성공 결과도 처리할 객체임.
			Librarian librarian = new Librarian();
			librarian.setId(id);
			librarian.setPassword(pw);
			
			//service 로 로그인 시도
			librarian = service.loginLibrarian(librarian);
			
			if(librarian != null) {
				//로그인 성공한 경우
				//session 에 로그인 정보를 저장
				session.setAttribute("librarianNo", librarian.getLibrarianNo());
				session.setAttribute("id", librarian.getId());
				session.setAttribute("name", librarian.getName());
				session.setAttribute("role", role);
				
				//로그인 성공 화면과 이후에 이동할 페이지에 대한 설정
				model.addAttribute("message", librarian.getId() + "(" + librarian.getName() + ")" + "님, 로그인 되었습니다.");
				model.addAttribute("next", "/index");
			}else {
				//로그인 실패한 경우
				//로그인 실패 화면에 대한 설정(로그인 화면으로 다시 이동시킨다.)
				model.addAttribute("message", "ID 또는 PASSWORD 가 일치하지 않습니다.");
				model.addAttribute("next", "/login/toLogin");
			}
		//end librarian if else	
		} 
		
		//content 에 할당할 페이지 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//end login

	
	
	
	@Override
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession(false);
		
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		//세션이 만료된 상태에 출력할 메시지를 기본으로 세팅한다.
		String message = "세션이 만료되어 이미 로그아웃 되어있습니다.";
		
		if (session != null) {
			//세션 종료
			message = id + "(" + name + ")" +"님 로그아웃 되었습니다.";
			session.invalidate();
		} 
		
		//로그아웃 결과에 대한 메시지 설정
		model.addAttribute("message", message);
		//로그아웃 처리 메시지 출력 이후 이동할 페이지에 대한 설정
		model.addAttribute("next", "/index");

		//content 에 할당할 페이지 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");

		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//end logout

}
