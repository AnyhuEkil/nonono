package com.cto.auction.controller.auctionItem;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cto.auction.service.auctionItem.AuctionItemService;
import com.cto.auction.vo.auctionItem.AuctionItem;

@Controller
@RequestMapping("/*")
public class AuctionItemController {
	
	@Autowired(required=false)
	private AuctionItemService service;
	// 아이템 리스트 // 메인컨트롤러로 옮김 ("item.do")맵핑이름 바꿈
	/*@RequestMapping("main.do")
	public ModelAndView itemList(ModelAndView mav, Model m, HttpSession session){
		// view화면에서 item값이 list면 아이템 목록이 나옴
		m.addAttribute("item", "list");
		mav.addObject("itemList", service.itemList());
		mav.setViewName("main/main");
		return mav;
	}*/
	// 아이템 등록화면 이동
	@RequestMapping("item/insert.do")
	public String insert(Model m){
		// view화면에서 item값이 insert면 등록화면이 나옴
		m.addAttribute("item", "insert");
		return "main/main";
	}
	// 아이템 등록실행
	@RequestMapping("item/insertProc.do")
	public String insertProc(@ModelAttribute AuctionItem ins, HttpSession session, MultipartFile file) throws IOException{
		int id = (Integer) session.getAttribute("id");
		ins.setAuctioneer_id(id);
		service.itemInsert(ins, file);
		return "redirect:/main.do";
	}
	
	
	

	@RequestMapping("myPage/auctionInfo.do")
	public ModelAndView myPageAuctionInfo(AuctionItem info, HttpSession session, ModelAndView mav) {
		// menu/menu 페이지로 이동
		mav.setViewName("menu/menu");
		// menu.jsp 에 포함된 인클루드 페이지 auctionInfo.jsp
		mav.addObject("pageName", "myPage/auctionInfo");
		// 입찰중인 물품(경매시간 남은 경우. 입찰가와 상관없음)
		if (service.auctionUserInfoBidding(info, session) != null) {
			mav.addObject("bidding", service.auctionUserInfoBidding(info, session));
		} else {
			mav.addObject("biddingMsg", "nothing");
		}
		// 낙찰된 물품(경매시간이 끝났고, 입찰가가 1등인경우)
		if (service.auctionUserInfoWinBid(info, session) != null) {
			mav.addObject("winBid", service.auctionUserInfoWinBid(info, session));
		} else {
			mav.addObject("winBidMsg", "nothing");
		}
		// 낙찰에 실패한 물품(경매시간끝났고, 입찰가가 1등이 아닌경우)
		if (service.auctionUserInfoLoseBid(info, session) != null) {
			mav.addObject("loseBid", service.auctionUserInfoLoseBid(info, session));
		} else {
			mav.addObject("loseBidMsg", "nothing");
		}
		return mav;
	}
	

	


	
	
}
