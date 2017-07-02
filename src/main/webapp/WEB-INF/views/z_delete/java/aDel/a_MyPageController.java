package com.cto.auction.aDel;

필요없나?
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping("/myPage/*")
public class a_MyPageController {
	/*@Autowired(required=false)*/
	/*private UserPaymentService service2;*/
	
	
	/*
	
	
/*	@RequestMapping("pageMove.do")
	public ModelAndView pageMove(AuctionUser mem, HttpSession session, ModelAndView mav) {
		// 로그인 필요한 화면인동
		if (AuctionUserService.loginCheck(mem) != null) {
			// 해당 멤버의 정보를 "mem"이라는 이름으로 세션에 넣겠다.
			session.setAttribute("mem", service.loginCheck(mem));
			session.setAttribute("email", mem.getEmail());
			// 보여주는 view 경로 설정( 로그인이 성공 했으면 main으로)
			mav.setViewName("main/main");
			// 해당 view에 포함시킬 객체 설정(로그인 여부 msg를 설정함-success)
			mav.addObject("msg", "success");
		}// 로그인 필요없는 화면
		else{
			// 로그인 체크 null값이면 다시 login 페이지로
			mav.setViewName("login/login");
			// 해당 view에 포함시킬 객체 설정
			mav.addObject("msg", "failure");
		}
		return mav;
	}*/
	
	// TODO 같은코드 반복.. 줄이는 방법모색
/*	@RequestMapping("auctionInfo.do")
	public ModelAndView myPageAuctionInfo(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/auctionInfo");
		return mav;
	}
	@RequestMapping("message.do")
	public ModelAndView myPageMessage(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/message");
		return mav;
	}
	@RequestMapping("getInfo.do")
	public ModelAndView myPageGetInfo(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/getInfo");
		return mav;
	}
	@RequestMapping("locationInfo.do")
	public ModelAndView myPageLocationInfo(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/locationInfo");
		return mav;
	}
	@RequestMapping("userPayment.do")
	public ModelAndView myPageUserPayment(ModelAndView mav){
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/UserPayment");
		return mav;
	}
	
	@RequestMapping("userPaymentProc.do")
	public String myPageUserPaymentProc(UserPayment pay){
		service2.myPageUserPaymentProc(pay);
		return "redirect:myPage/UserPayment.do";
	}
	
	@RequestMapping("userPaymentInfo.do")
	public String userPaymentInfo(UserPayment pay){
		ModelAndView mav = new ModelAndView();
		service2.userPaymentInfo(pay);
		return "redirect:myPage/UserPayment.do";
	}
	
	
	
	
	
	
	@RequestMapping("userInfo.do")
	public ModelAndView myPageUserInfo(AuctionUser info, HttpSession session, Model m, ModelAndView mav){
		m.addAttribute("mem", service.auctionUserInfo(info, session));
		mav.setViewName("main/menuHome");
		mav.addObject("paramPage01", "myPage/userInfo");
		return mav;
	}
	
	// TODO 공지, 판매자, 등록..
	
	
//	회원정보 수정
	@RequestMapping("userUpdate.do")
	public String auctionUserUpdate(AuctionUser upt){
		service.auctionUserUpdate(upt);
		return "redirect:/myPage/userInfo.do";
		}

//	회원 삭제
	@RequestMapping("myPage/userLeave.do")
	public String auctionUserDelete(AuctionUser del, HttpSession session){
		service.auctionUserDelete(del, session);
		return "redirect:/main.do";
	}
	
*/
}
