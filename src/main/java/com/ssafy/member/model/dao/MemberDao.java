package com.ssafy.member.model.dao;

import com.ssafy.board.model.BoardDto;
import com.ssafy.member.model.MemberDto;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    int idCheck(String userId);
    int joinMember(MemberDto memberDto);
    int updateMember(MemberDto memberDto);
    int deleteMember(String user_id);
    MemberDto loginMember(String userId, String userPwd);
    List<BoardDto> getMemberBoards(String userId);
    MemberDto findMemberByEmail(String email);
    List<MemberDto> findAll();
}
