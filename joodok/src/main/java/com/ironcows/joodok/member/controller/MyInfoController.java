package com.ironcows.joodok.member.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.service.MemberServiceIf;

@Controller(value="memberMyInfoController")
@RequestMapping(value="/member")
public class MyInfoController implements MyInfoControllerIf {
	
	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	@Resource(name="memberService")
	private MemberServiceIf memberSv;
	
	
	
	@Override
	@RequestMapping(value="/myInfo", method=RequestMethod.GET)
	public String getMyInfo(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession();
		
		// 포장용 객체 member 생성 및 검색 설정
		Member member = new Member();
		member.setMemberNo((String)session.getAttribute("memberNo"));
		
		
		//service 로 myInfo 가져오기
		Map<String, String> myInfo = memberSv.getMyInfo(member);
		
		if(myInfo != null) {
			//myInfo 추가
			model.addAttribute("myInfo", myInfo);
			//출력할 컨텐츠 화면으로 memberInfo.jsp 설정
			model.addAttribute("content", "/WEB-INF/views/member/memberInfo/memberInfo.jsp");
		}else {
			// 세션이 만료되어 정상 작업이 이뤄지지 않을 때
			
			//메시지 설정
			model.addAttribute("message", "세션이 만료되었습니다. 다시 로그인 해주십시오.");
			//메시지 출력 이후 이동할 페이지로 로그인 화면 설정
			model.addAttribute("next", "/login/toLogin");
			//출력할 컨텐츠 화면으로 message.jsp 설정
			model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		}
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}

}
