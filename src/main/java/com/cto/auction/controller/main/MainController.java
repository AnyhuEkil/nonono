package com.cto.auction.controller.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cto.auction.service.auctionItem.AuctionItemService;


@Service
@RequestMapping("/*")
public class MainController {
	@Autowired(required=false)
	private AuctionItemService service;
	
	@RequestMapping("main.do")
	public String main(){
		return "main/main";
	}
	@RequestMapping("/")
	public String main2(){
		return "main/main";
	}
	// 아이템 리스트
	@RequestMapping("item.do")
	public ModelAndView itemList(ModelAndView mav, Model m, HttpSession session){
		// view화면에서 item값이 list면 아이템 목록이 나옴
		m.addAttribute("item", "list");
		mav.addObject("itemList", service.itemList());
		mav.setViewName("main/main");
		return mav;
	}
	
	
	
/*	// TODO 같은코드 반복.. 줄이는 방법모색
	
	
	@RequestMapping("myPage/auctionInfo.do")
	public ModelAndView myPageAuctionInfo(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/auctionInfo");
		return mav;
	}
	@RequestMapping("myPage/message.do")
	public ModelAndView myPageMessage(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/message");
		return mav;
	}
	@RequestMapping("myPage/getInfo.do")
	public ModelAndView myPageGetInfo(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/getInfo");
		return mav;
	}
	@RequestMapping("myPage/locationInfo.do")
	public ModelAndView myPageLocationInfo(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/locationInfo");
		return mav;
	}
	@RequestMapping("myPage/userPayment.do")
	public ModelAndView myPageUserPayment(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/UserPayment");
		return mav;
	}
	
	@RequestMapping("myPage/userPaymentProc.do")
	public String myPageUserPaymentProc(UserPayment pay){
		service2.myPageUserPaymentProc(pay);
		return "redirect:myPage/UserPayment.do";
	}
	
	@RequestMapping("myPage/userPaymentInfo.do")
	public String userPaymentInfo(UserPayment pay){
		ModelAndView mav = new ModelAndView();
		service2.userPaymentInfo(pay);
		return "redirect:myPage/UserPayment.do";
	}
	
	
	
	
	
	
	@RequestMapping("myPage/userInfo.do")
	public ModelAndView myPageUserInfo(AuctionUser info, HttpSession session, Model m, ModelAndView mav){
		m.addAttribute("mem", service.auctionUserInfo(info, session));
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/userInfo");
		return mav;
	}
	
	// TODO 공지, 판매자, 등록..
	
	
//	로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav){
		service.logout(session);
		mav.setViewName("/main/main");
		mav.addObject("msg", "logout");
		return mav;
	}*/
	
}
