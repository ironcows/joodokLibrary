package com.ironcows.joodok.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ironcows.joodok.dto.Member;
import com.ironcows.joodok.service.ReservationServiceIf;

@Controller(value="memberReservationController")
@RequestMapping(value="/member")
public class ReservationController implements ReservationControllerIf {
	
	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="reservationService")
	private ReservationServiceIf reservationSv;
	

	@Override
	@RequestMapping(value="/myReservation", method=RequestMethod.GET)
	public String getMyReservation(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession();
		
		//포장용 객체 member 생성 및 검색 설정
		Member member = new Member();
		member.setMemberNo((String)session.getAttribute("memberNo"));
		
		//service 로 myReservation 가져오기
		List<Map<String, String>> myReservation = reservationSv.getMyReservation(member);
		
		if(myReservation != null) {
			model.addAttribute("myReservation", myReservation);
		}
		
		//출력할 컨텐츠 화면으로 memberReservation.jsp 로 설정
		model.addAttribute("content", "/WEB-INF/views/member/reservationBook/memberReservation.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}

}
