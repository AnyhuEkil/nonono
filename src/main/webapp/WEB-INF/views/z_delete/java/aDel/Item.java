/*CREATE TABLE AUCTION_ITEM
(
   AUCTION_ID           NUMBER (10),
   AUCTIONEER_ID        NUMBER (10),
   ITEM_NAME            VARCHAR2 (100),
   ITEM_CONTENT         VARCHAR2 (300),
   START_DATE           DATE DEFAULT SYSDATE,
   END_DATE             DATE,
   STATE_CODE           NUMBER (1) DEFAULT 1,
   CURRNET_BIDDER_ID    NUMBER (10),
   CURRENT_BIDDER       VARCHAR2 (100),
   CURRENT_BID_AMOUNT   NUMBER (10),
   ACOUNT_HIT           NUMBER (4) DEFAULT 0,
   CATEGORY_ID          NUMBER (10),
   PARENT_CATEGORY_ID   NUMBER (10),
   PICTURE_LOCATION     VARCHAR2 (500)
)
NOCACHE
LOGGING;*/
package com.cto.auction.aDel;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class Item {
	private int auction_id;
	private int auctioneer_id;
	private String item_name;
	private String item_content;
	private Date start_date;
	private Date end_date;
	private int state_code;
	private int current_bidder_id;
	private String current_bidder;
	private int current_bid_amount;
	private int account_hit;
	private int category_id;
	private int parent_category_id;
	private String picture_location;
	private MultipartFile file;
	

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getCurrent_bidder_id() {
		return current_bidder_id;
	}
	public void setCurrent_bidder_id(int current_bidder_id) {
		this.current_bidder_id = current_bidder_id;
	}
	public int getAuction_id() {
		return auction_id;
	}
	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}
	public int getAuctioneer_id() {
		return auctioneer_id;
	}
	public void setAuctioneer_id(int auctioneer_id) {
		this.auctioneer_id = auctioneer_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getState_code() {
		return state_code;
	}
	public void setState_code(int state_code) {
		this.state_code = state_code;
	}
	public String getCurrent_bidder() {
		return current_bidder;
	}
	public void setCurrent_bidder(String current_bidder) {
		this.current_bidder = current_bidder;
	}
	public int getCurrent_bid_amount() {
		return current_bid_amount;
	}
	public void setCurrent_bid_amount(int current_bid_amount) {
		this.current_bid_amount = current_bid_amount;
	}
	public int getAccount_hit() {
		return account_hit;
	}
	public void setAccount_hit(int account_hit) {
		this.account_hit = account_hit;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getParent_category_id() {
		return parent_category_id;
	}
	public void setParent_category_id(int parent_category_id) {
		this.parent_category_id = parent_category_id;
	}
	public String getPicture_location() {
		return picture_location;
	}
	public void setPicture_location(String picture_location) {
		this.picture_location = picture_location;
	}
	
	
}
