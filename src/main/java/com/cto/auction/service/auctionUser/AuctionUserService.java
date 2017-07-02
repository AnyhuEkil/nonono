package com.cto.auction.service.auctionUser;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cto.auction.repository.auctionUser.AuctionUserDAO;
import com.cto.auction.vo.auctionUser.AuctionUser;
import com.cto.auction.vo.auctionUser.UserPayment;

@Service
public class AuctionUserService {
	@Autowired(required = false)
	private AuctionUserDAO dao;

	// 테스트용 리스트
	public List<AuctionUser> auctionUserList(AuctionUser list) {
		return dao.auctionUserList(list);
	}

	// 로그인 데이터확인
	public AuctionUser loginCheck(AuctionUser mem) {
		return dao.loginCheck(mem);
	}

	// 회원가입
	public void signUpProc(AuctionUser ins) {
		dao.signUpProc(ins);
	}

	// 로그아웃
	public void logout(HttpSession session) {
		session.invalidate();
	}

	// 회원정보페이지
	public AuctionUser myPageUserInfo(AuctionUser info, HttpSession session) {
		info.setUser_id((Integer) session.getAttribute("sessionUser_id"));
		return dao.myPageUserInfo(info);
	}
	// 회원정보페이지-수정
	public void myPageUserUpdate(AuctionUser upt) {
		dao.myPageUserUpdate(upt);
	}
	// 회원정보페이지-삭제
	public void myPageUserDelete(AuctionUser del, HttpSession session) {
		dao.myPageUserDelete(del);
		session.invalidate();
	}
	public void myPageLocUpdate(AuctionUser upt) {
		dao.myPageLocUpdate(upt);
	}

	public UserPayment myPageUserPayment(UserPayment info, HttpSession session) {
		info.setUser_id((Integer) session.getAttribute("sessionUser_id"));
		return dao.myPageUserPayment(info);
	}

	public void myPagePayUpdate(UserPayment upt) {
		dao.myPagePayUpdate(upt);
	}

}
