package com.cto.auction.controller.menu;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Service
@RequestMapping("/*")
public class MenuController {
	/*private AuctionUserService auctionUserservice;*/
	//메뉴홈가기
	@RequestMapping("menuHome.do")
	public ModelAndView mainMenuList(ModelAndView mav){
		mav.setViewName("menu/menuHome");
		mav.addObject("pageName", "menuHome");
		return mav;
	}
	
	//공지 및 문의 가기
	@RequestMapping("notice/notice.do")
	public ModelAndView noticeNotice(ModelAndView mav){
		mav.setViewName("menu/menu");
		mav.addObject("pageName", "notice/notice");
		return mav;
	}
	
	//판매자 정보가기
	
	@RequestMapping("menuPageLoc.do")
	public ModelAndView pageLoc(@RequestParam("pl") String pl,ModelAndView mav){
		mav.setViewName("menu/menu");
		mav.addObject("pageName",pl);
		return mav;
	}
}
