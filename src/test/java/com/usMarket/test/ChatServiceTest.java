package com.usMarket.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.usMarket.dao.chat.ChatDao;
import com.spring.usMarket.domain.chat.ChatDto;
import com.spring.usMarket.domain.chat.ChatRoomDto;
import com.spring.usMarket.service.chat.ChatService;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ChatServiceTest {
	
	@Autowired private ChatService chatService;
	
	@Test
	public void addChatTest() throws Exception{
		Integer current_no = 2;
		Integer seller_no = 3;
		ChatRoomDto roomDto = chatService.getChatRoomByInfo(current_no, seller_no);
		if(roomDto == null) {
			ChatDto chatDto = chatService.addChatRoom(current_no, seller_no, "test message", 0, "");
		}
		List<ChatDto> chatInfo = chatService.getChatInfo(roomDto.getRoom_no());
		for(ChatDto chatDto : chatInfo){
			System.out.println(chatDto.toString());
		}
		
		assertEquals(chatInfo.size(), 1);
	}
}
