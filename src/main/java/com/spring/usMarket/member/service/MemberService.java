package com.spring.usMarket.member.service;

import java.util.Map;

import com.spring.usMarket.member.domain.MemberDto;

public interface MemberService {
	void addMember(MemberDto member);
	int checkID(String member_id);
	int checkNick(String member_nick);
	int checkEmail(String member_email);
	void checkOvelap(String joinMember);
	Map<String, Object> loginCheckID(String member_id) throws Exception;
}
