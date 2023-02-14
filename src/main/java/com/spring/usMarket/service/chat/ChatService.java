package com.spring.usMarket.service.chat;

import java.util.List;
import java.util.Map;

import com.spring.usMarket.domain.chat.ChatDto;
import com.spring.usMarket.domain.chat.ChatRoomDto;

public interface ChatService {
	ChatRoomDto getChatRoomByInfo(Integer current_no, Integer seller_no) throws Exception;
	ChatRoomDto addChatRoom(Integer current_no, Integer seller_no, String message) throws Exception;
	List<Map<String, Object>> getChatList(Integer member_no) throws Exception;
	int modifyChatRead(String room_no, Integer chat_to) throws Exception;
	int addChat(ChatDto dto) throws Exception;
	List<ChatDto> getChatInfo(String room_no) throws Exception;
	String getNickName(Integer member_no) throws Exception;
}
