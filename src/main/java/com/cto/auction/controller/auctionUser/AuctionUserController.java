package com.cto.auction.controller.auctionUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cto.auction.service.auctionUser.AuctionUserService;
import com.cto.auction.vo.auctionUser.AuctionUser;
import com.cto.auction.vo.auctionUser.UserPayment;


@Controller
public class AuctionUserController {
	@Autowired(required = false)
	private AuctionUserService service;
	
	@RequestMapping("ttt.do")
	public String auctionUserList(@ModelAttribute("testCtrlModelAttribute") AuctionUser sch, Model m) {
		m.addAttribute("ttt", service.auctionUserList(sch));
		return "main/testlist";
	}
	
	// 로그인 접속
	@RequestMapping("/auctionUser/login.do")
	public String login() {
		return "login/login";
	}

	// 로그인 체크
	@RequestMapping("/auctionUser/loginCheck.do")
	public ModelAndView loginCheck(AuctionUser mem, HttpSession session, ModelAndView mav) {
		// 로그인 체크시 null값이 아니면(회원정보가 있으면)
		if (service.loginCheck(mem) != null) {
			// 해당 멤버의 정보를 "mem"이라는 이름으로 세션에 넣겠다.
			session.setAttribute("mem", service.loginCheck(mem));
			session.setAttribute("sessionUser_id", service.loginCheck(mem).getUser_id());
		/*
			// 세션 id : 로그인 한 계정의 user_id
			session.setAttribute("id", service.loginCheck(mem).getUser_id());
			// 세션 email : 로그인 한 계정의 email
			session.setAttribute("email", service.loginCheck(mem).getEmail());
			// 세션 name : 로그인 한 계정의 이름
			session.setAttribute("name", service.loginCheck(mem).getUser_name());
		*/
			// 보여주는 view 경로 설정( 로그인이 성공 했으면 main으로)
			mav.setViewName("main/main");
			// 해당 view에 포함시킬 객체 설정(로그인 여부 msg를 설정함-success)
			mav.addObject("msg", "success");
		} else {
			// 로그인 체크 null값이면 다시 login 페이지로
			mav.setViewName("login/login");
			// 해당 view에 포함시킬 객체 설정
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	// 회원가입폼으로 이동
	@RequestMapping("/auctionUser/signUp.do")
	public String signUp() {
		return "login/signup";
	}

	// 실질적인 회원가입 진행로직
	@RequestMapping("/auctionUser/signUpProc.do")
	public String signUpProc(AuctionUser ins) {
		service.signUpProc(ins);
		return "redirect:login.do";
	}

	// 로그아웃
	@RequestMapping("/auctionUser/logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		service.logout(session);
		mav.setViewName("/main/main");
		mav.addObject("msg", "logout");
		return mav;
	}

	// 회원개인 정보 + 주소정보
	@RequestMapping("/myPage/userInfo.do")
	public ModelAndView myPageUserInfo(AuctionUser info, HttpSession session, ModelAndView mav) {
		mav.setViewName("menu/menu");
		mav.addObject("pageName", "myPage/userInfo");
		mav.addObject("userInfo", service.myPageUserInfo(info, session));
		return mav;
	}
	@RequestMapping("/myPage/locationInfo.do")
	public ModelAndView myPageLocationInfo(AuctionUser info, HttpSession session, ModelAndView mav) {
		mav.setViewName("menu/menu");
		mav.addObject("pageName", "myPage/locationInfo");
		mav.addObject("userInfo", service.myPageUserInfo(info, session));
		return mav;
	}

	// 회원정보 수정
	@RequestMapping("/myPage/update.do")
	public String myPageUserUpdate(AuctionUser upt) {
		service.myPageUserUpdate(upt);
		return "redirect:/myPage/userInfo.do";
	}
	@RequestMapping("/myPage/locUpdate.do")
	public String myPageLocUpdate(AuctionUser upt) {
		service.myPageLocUpdate(upt);
		return "redirect:/myPage/locationInfo.do";
	}

	// 회원 삭제
	@RequestMapping("/myPage/delete.do")
	public String myPageUserDelete(AuctionUser del, HttpSession session) {
		service.myPageUserDelete(del, session);
		return "redirect:/main.do";
	}
	
	@RequestMapping("/myPage/userPayment.do")
	public ModelAndView myPageUserPayment(UserPayment info, HttpSession session, ModelAndView mav) {
		mav.setViewName("menu/menu");
		mav.addObject("pageName", "myPage/userPayment");
		mav.addObject("payInfo", service.myPageUserPayment(info, session));
		return mav;
	}
	@RequestMapping("/myPage/payUpdate.do")
	public String myPagePayUpdate(UserPayment upt) {
		service.myPagePayUpdate(upt);
		return "redirect:/myPage/userPayment.do";
	}
	@RequestMapping("/myPage/payInsert.do")
	public String myPagePayInsert(UserPayment upt) {
		service.myPagePayInsert(upt);
		return "redirect:/myPage/userPayment.do";
	}
	
	
	// 회원정보에 합침.
	/*@RequestMapping("myPage/locationInfo.do")
	public ModelAndView myPageLocationInfo(AuctionUser info, HttpSession session, ModelAndView mav) {
		// menu/menu 페이지로 이동
		mav.setViewName("menu/menu");
		// menu.jsp 에 포함된 인클루드 페이지 auctionInfo.jsp
		mav.addObject("pageName", "myPage/locationInfo");
		// 입찰중인 물품(경매시간 남은 경우. 입찰가와 상관없음)
		mav.addObject("bidding", service.auctionUserInfo(info, session));
		return mav;
	}*/

	@RequestMapping("myPage/message.do")
	public ModelAndView myPageMessage(ModelAndView mav) {
		mav.setViewName("menu/menu");
		mav.addObject("pageName", "myPage/message");
		return mav;
	}

	@RequestMapping("myPage/delivery.do")
	public ModelAndView myPageDelivery(ModelAndView mav) {
		mav.setViewName("menu/menu");
		mav.addObject("pageName", "myPage/delivery");
		return mav;
	}



}
