package com.ssafy.member.model.service;

import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.member.model.MemberDto;

public interface MemberService {
    int idCheck(String userId);
    int joinMember(MemberDto memberDto);
    int updateMember(MemberDto memberDto);
    int deleteMember(String user_id);
    MemberDto loginMember(String userId, String userPwd);
    List<BoardDto> getMemberBoards(String userId);
	MemberDto findMemberByEmail(String email);
	String generateRandomPassword();
	List<MemberDto> findAll();
}
