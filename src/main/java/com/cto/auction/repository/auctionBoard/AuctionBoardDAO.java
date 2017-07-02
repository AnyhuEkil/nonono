package com.cto.auction.repository.auctionBoard;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cto.auction.vo.auctionBid.AuctionBid;
import com.cto.auction.vo.auctionBoard.AuctionBoard;
import com.cto.auction.vo.auctionItem.AuctionItem;

@Repository
public interface AuctionBoardDAO {
	//	게시판 리스트
	public ArrayList<AuctionBoard> boardList(Map<String, Object> map);
	// 게시판 읽기
	public AuctionBoard read(int board_id);
	// 게시글 작성
	public void insert(AuctionBoard ins);
	// 게시글 수정
	public void update(AuctionBoard upt);
	// 게시글 삭제
	public void delete(int board_id);
	// 게시글 조회수 증가
	public void increaseHit(int board_id);
	// 게시글 갯수 확인
	public int countBoard(Map<String, Object> map);
	// 리플 달기
	public void insertReply(AuctionBoard reply);
	// 리플 모양
	public void shapeReply(AuctionBoard shape);
	// 물품상세정보
	public AuctionItem itemInfo(int auction_id);
	// 입찰테이블에 입찰자가 있는지 없는지 확인
	public AuctionBid bidCheck(AuctionBid bid);
	// 입찰시 아이템테이블 비드값, 비드아이디 수정
	public void itemUpdate(AuctionItem upt);
	// 입찰로그 확인
	public ArrayList<AuctionBid> bidList(int auction_id);
	// 첫입찰자면 비드테이블 값 추가
	public void bidInsert(AuctionBid bid);
	// 기존 입찰자면 비드테이블 값 수정
	public void bidUpdate(AuctionBid bid);
}
