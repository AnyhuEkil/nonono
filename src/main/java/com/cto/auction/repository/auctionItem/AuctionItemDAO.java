package com.cto.auction.repository.auctionItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cto.auction.vo.auctionItem.AuctionItem;

@Repository
public interface AuctionItemDAO {
	// 아이템 리스트 
	public ArrayList<AuctionItem> itemList();
	// 아이템 등록
	public void itemInsert(AuctionItem ins);
	
	public List<AuctionItem> auctionUserInfoWinBid(AuctionItem info);
	public List<AuctionItem> auctionUserInfoBidding(AuctionItem info);
	public List<AuctionItem> auctionUserInfoLoseBid(AuctionItem info);

}
