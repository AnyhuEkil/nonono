package com.cto.auction.service.auctionItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cto.auction.repository.auctionItem.AuctionItemDAO;
import com.cto.auction.vo.auctionItem.AuctionItem;

@Service
public class AuctionItemService {
	// 로그 확인
	private static final Logger logger = LoggerFactory.getLogger(AuctionItemService.class);
	// servelet.xml에서 bean(임시폴더 경로) 자원 사용
	@Resource(name="tempPath")
	private String tempPath;
	
	@Autowired(required=false)
	private AuctionItemDAO dao;
	// 아이템 리스트
	public ArrayList<AuctionItem> itemList(){
		return dao.itemList();
	}
	// 아이템 등록
	public void itemInsert(AuctionItem ins, MultipartFile file) throws IOException{
		//임시저장소에서 이동시킬 경로
		String realPath = "C:/a01_prog/eclipse/workspace_auction/auctionweb/src/main/webapp/resources/upload/";
		// uuid 생성(Universal Unique IDentifier, 범용 고유 식별자)
		UUID uuid = UUID.randomUUID();
		// 파일명 : uuid_기존파일명 ==> 파일명 중복 안되게 처리
        String filename = uuid.toString()+"_"+file.getOriginalFilename();
        // 임시파일(서버 임시저장소)과 타켓파일 설정(워크스페이스내 실제 저장소)
        File temp = new File(tempPath+filename);
        File target = new File(realPath+filename);
        // 임시폴더에 파일 저장
        file.transferTo(temp);
        // 임시폴더 내의 파일을 실제 경로로 저장
        FileCopyUtils.copy(temp, target);
        // 경로확인 로그
        logger.info("파일이름 :"+file.getOriginalFilename());
        logger.info("파일크기 : "+file.getSize()/1024+"kb");
        logger.info("컨텐트 타입 : "+file.getContentType());
        logger.info("임시파일 경로:"+temp.getPath());
        logger.info("타겟파일 경로:"+target.getPath());
		// 파일이름을 테이블 컬럼에 설정
		ins.setPicture_location(filename);
		dao.itemInsert(ins);
	}
/*
	public void copy(File temp, File target) throws IOException{
		FileInputStream in = new FileInputStream(temp);
		FileOutputStream out = new FileOutputStream(target);
		byte[] buff = new byte[1024*8];
		int inRead;
		while( (inRead=in.read(buff))!=-1){
			out.write(buff, 0, inRead);
		}
		in.close();
		out.close();
	}*/
	
	// 종원~
	public List<AuctionItem> auctionUserInfoWinBid(AuctionItem info, HttpSession session) {
		info.setAuctioneer_id((Integer)session.getAttribute("sessionUser_id"));
		return dao.auctionUserInfoWinBid(info);
	}
	public List<AuctionItem> auctionUserInfoBidding(AuctionItem info, HttpSession session) {
		info.setAuctioneer_id((Integer)session.getAttribute("sessionUser_id"));
		return dao.auctionUserInfoBidding(info);
	}
	public List<AuctionItem> auctionUserInfoLoseBid(AuctionItem info, HttpSession session) {
		info.setAuctioneer_id((Integer)session.getAttribute("sessionUser_id"));
		return dao.auctionUserInfoLoseBid(info);
	}
	
}
