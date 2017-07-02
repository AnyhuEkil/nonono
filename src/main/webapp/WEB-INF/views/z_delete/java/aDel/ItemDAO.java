package com.cto.auction.aDel;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.cto.auction.vo.Item;

@Repository
public interface ItemDAO {
	// 아이템 리스트 
	public ArrayList<Item> itemList();
	// 아이템 등록
	public void itemInsert(Item ins);

}
