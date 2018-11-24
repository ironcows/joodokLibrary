package com.ironcows.joodok.librarian.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ironcows.joodok.dto.OrderDetail;
import com.ironcows.joodok.dto.Orders;
import com.ironcows.joodok.dto.TradeEnterprise;
import com.ironcows.joodok.service.AcquisitionServiceIf;
import com.ironcows.joodok.service.OrderDetailServiceIf;
import com.ironcows.joodok.service.OrdersServiceIf;
import com.ironcows.joodok.service.TradeEnterpriseServiceIf;


@Controller(value="libOrderController")
@RequestMapping(value="/librarian")
public class OrderController implements OrderControllerIf {

	//필요한 service 들을 가져온다.
	
	/**
	 * com.ironcows.joodok.service 안의 클래스에서 Repository(Service) 로 등록한 것을 
	 * Resource에 명시함으로써 연결한다.
	 */
	
	@Resource(name="acquisitionService")
	private AcquisitionServiceIf acquisitionSv;
	
	@Resource(name="tradeEnterpriseService")
	private TradeEnterpriseServiceIf tradeEnterpriseSv;
	
	@Resource(name="ordersService")
	private OrdersServiceIf ordersSv;
	
	@Resource(name="orderDetailService")
	private OrderDetailServiceIf orderDetailSv;
	
	
	@Override
	@RequestMapping(value="/toOrder", method=RequestMethod.GET)
	public String toOrder(Model model) {
		
		//대문자 표기 레코드셋
		List<Map<String, String>> capitalOrderedList = acquisitionSv.getAcqusitionForOrder();
		
		//캐멀 노테이션 표기 레코드셋
		List<Map<String, String>> unOrderedList = new ArrayList<>();
		
		//거래처 정보
		List<TradeEnterprise> tradeEnterpriseList = tradeEnterpriseSv.getAllTradeEnterprise();
		
		
		for (Map<String, String> capitalOrderedOne : capitalOrderedList) {
			//insertOrder.jsp 에서 사용될 el 에서 컬럼명을 대문자로 표기되는 것을
			//캐멀 노테이션을 적용한 레코드로 변경해준다.
			Map<String, String> newOne = new HashMap<>();
			newOne.put("acquisitionNo", capitalOrderedOne.get("ACQUISITIONNO"));
			newOne.put("category", capitalOrderedOne.get("CATEGORY"));
			newOne.put("acquisitionIsbn", capitalOrderedOne.get("ACQUISITIONISBN"));
			newOne.put("registeredDate", capitalOrderedOne.get("REGISTEREDDATE"));

			//캐멀 노테이션을 적용한 레코드로 추가
			unOrderedList.add(newOne);
		}
		
		//거래처 정보
		model.addAttribute("tradeEnterpriseList", tradeEnterpriseList);
		
		//주문 대상 정보
		model.addAttribute("unOrderedList", unOrderedList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/order/insertOrder.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}
	
	
	@Override
	@RequestMapping(value="/addOrderList", method=RequestMethod.POST)
	public String addOrderList(@RequestParam(value="checkedAcquisitionNo", required=false) List<String> checkedAcquisitionNos
							 , @RequestParam(value="acquisitionNo", required=false) List<String> acquisitionNos
							 , @RequestParam(value="category", required=false) List<String> categorys
							 , @RequestParam(value="acquisitionIsbn", required=false) List<String> acquisitionIsbns
							 , @RequestParam(value="registeredDate", required=false) List<String> registeredDates
							 , @RequestParam(value="orAcquisitionNo", required=false) List<String> orAcquisitionNos
							 , @RequestParam(value="orCategory", required=false) List<String> orCategorys
							 , @RequestParam(value="orAcquisitionIsbn", required=false) List<String> orAcquisitionIsbns
							 , @RequestParam(value="orRegisteredDate", required=false) List<String> orRegisteredDates
							 , Model model) {

		/**
		 * 선택된 대상을 주문 목록에 추가하기 위해서 주의해야할 점
		 * 1. 이미 선택된 목록이 있으면 orderList 에 담는다.
		 * 2. 대상 목록에 있는 리스트를 모두 가져와서 unOrderedList 변수에 담는다. 
		 * 3. 선택한 목록에 대한 정보 checkedAcquisitionNos 의 값들과 일치하는 아이템들을 unOrderedList 에서 하나씩 제거한다.
		 * 4. 선택한 목록을 orderList 에 담는다.
		 */
			
		
		//대상 목록의 리스트를 유지할 변수
		List<Map<String, String>> unOrderedList = new ArrayList<>();
		
		//선택 목록의 리스트를 유지할 변수
		List<Map<String, String>> orderList = new ArrayList<>();
		
		//거래처 정보
		List<TradeEnterprise> tradeEnterpriseList = tradeEnterpriseSv.getAllTradeEnterprise();
		
		//1. 이미 선택된 목록이 있으면 orderList 에 담는다.
		if(orAcquisitionNos != null && orCategorys != null
		&& orAcquisitionIsbns != null && orRegisteredDates != null) {
			for (int i = 0; i < orAcquisitionNos.size(); i++) {
				Map<String, String> orderOne = new HashMap<>();
				orderOne.put("acquisitionNo", orAcquisitionNos.get(i));
				orderOne.put("category", orCategorys.get(i));
				orderOne.put("acquisitionIsbn", orAcquisitionIsbns.get(i));
				orderOne.put("registeredDate", orRegisteredDates.get(i));
				
				orderList.add(orderOne);
			}
		}
		
		//2. 대상 목록을 모두 가져와서 유지
		if(acquisitionNos != null && categorys != null
		&& acquisitionIsbns != null && registeredDates != null) {
			for (int i = 0; i < acquisitionNos.size(); i++) {
				Map<String, String> unOrderedOne = new HashMap<>();
				unOrderedOne.put("acquisitionNo", acquisitionNos.get(i));
				unOrderedOne.put("category", categorys.get(i));
				unOrderedOne.put("acquisitionIsbn", acquisitionIsbns.get(i));
				unOrderedOne.put("registeredDate", registeredDates.get(i));
				
				unOrderedList.add(unOrderedOne);
			}//for end
		}//if end
			
		
		//3. 선택한 목록을 대상 목록에서 제외하기
		if(checkedAcquisitionNos != null) {
			for (Iterator<Map<String, String>> it = unOrderedList.iterator(); it.hasNext();) {
				Map<String, String> unOrderedOne = it.next();
				
				for (String checkedAcquisitionNo : checkedAcquisitionNos) {
					if(checkedAcquisitionNo.contentEquals(unOrderedOne.get("acquisitionNo"))) {
						it.remove();
						//4. 선택한 목록을 orderList 에 추가한다.
						orderList.add(unOrderedOne);
					}
				}//second for end
			}//first for end
		}//if end
		
		//거래처 정보
		model.addAttribute("tradeEnterpriseList", tradeEnterpriseList);
		
		//위에서 처리된(선택된 대상을 제외한) 대상 목록을 유지한다.
		model.addAttribute("unOrderedList", unOrderedList);
		
		//위에서 처리된 선택 목록을 유지한다.
		model.addAttribute("orderList", orderList);
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/librarian/order/insertOrder.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//addOrderList end
	
	
	@Override
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public String order(HttpServletRequest req
					  , @RequestParam("tradeEnterpriseInfo") String tradeEnterpriseInfo
					  , @RequestParam("orderIsbn") List<String> orderIsbns
					  , @RequestParam("orderCount") List<String> orderCounts
					  , Model model) {
		
		//주문 건수를 표시하기 위한 변수
		int orderCnt = 0;
		int orderSuccessCnt = 0;
		//사서 정보 가져오기
		HttpSession session = req.getSession();
		String librarianNo = (String)session.getAttribute("librarianNo");
		
		//주문 정보 포장
		Orders order = new Orders();
		order.setLibrarianNo(librarianNo);
		order.setTradeEnterpriseNo(tradeEnterpriseInfo);
		
		//orders 테이블에 인서트
		orderSuccessCnt = ordersSv.insertOrders(order);
		
		String orderNo = ordersSv.getOrderNo(librarianNo);
		
		if(orderSuccessCnt > 0) {
			for (int i = 0; i < orderIsbns.size(); i++) {
				int successCnt = 0;
				
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrderIsbn(orderIsbns.get(i));
				orderDetail.setOrderCount(orderCounts.get(i));
				orderDetail.setOrderNo(orderNo);
				
				successCnt = orderDetailSv.insertOrderDetail(orderDetail);
				orderCnt += successCnt;
			}		
			model.addAttribute("message", orderCnt + "건의 주문이 신청되었습니다.");			
		} else {
			model.addAttribute("message", "주문에 실패했습니다.");
		}
		
		model.addAttribute("next", "/librarian/toOrder");
		
		//출력할 화면 설정
		model.addAttribute("content", "/WEB-INF/views/main/message.jsp");
		
		// compositeView pattern 을 사용할 것이므로 항상 main/index 로 리턴
		return "main/index";
	}//order end


}
