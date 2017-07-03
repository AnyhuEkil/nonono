package com.cto.auction.repository.auctionUser;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.cto.auction.vo.auctionUser.AuctionUser;
import com.cto.auction.vo.auctionUser.UserPayment;

@Repository
public interface AuctionUserDAO {

	// 테스트용 코드 삭제해도됨
	public List<AuctionUser> auctionUserList(AuctionUser list);

	public AuctionUser loginCheck(AuctionUser mem);

	public void signUpProc(AuctionUser ins);

	public void logout(HttpSession session);

	public AuctionUser myPageUserInfo(AuctionUser info);

	public void myPageUserUpdate(AuctionUser upt);

	public void myPageLocUpdate(AuctionUser upt);

	public void myPageUserDelete(AuctionUser del);

	public UserPayment myPageUserPayment(UserPayment info);

	public void myPagePayUpdate(UserPayment upt);

	public void myPagePayInsert(UserPayment upt);

}
