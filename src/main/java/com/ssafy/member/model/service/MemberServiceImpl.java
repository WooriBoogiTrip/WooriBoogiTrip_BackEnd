package com.ssafy.member.model.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
    @Autowired
    private MemberDao memberDao;

    @Override
    public int idCheck(String userId) {
        return memberDao.idCheck(userId);
    }
    
    @Override
    public int joinMember(MemberDto memberDto) {
    	return memberDao.joinMember(memberDto);
    }
    
    @Override
    public int updateMember(MemberDto memberDto) {
    	return memberDao.updateMember(memberDto);
    }
    
    @Override
    public int deleteMember(String user_id) {
    	return memberDao.deleteMember(user_id);
    }
    
    @Override
    public MemberDto loginMember(String userId, String userPwd) {
    	return memberDao.loginMember(userId, userPwd);
    }
    
    @Override
    public List<BoardDto> getMemberBoards(String userId) {
    	return memberDao.getMemberBoards(userId);
    }

	@Override
	public MemberDto findMemberByEmail(String email) {
		return memberDao.findMemberByEmail(email);
	}

	@Override
	public String generateRandomPassword() {
	    Random random = new Random();
	    StringBuilder tempPassword = new StringBuilder();

	    for (int i = 0; i < 8; i++) {
	        tempPassword.append(random.nextInt(10));
	    }
	    System.out.println(tempPassword);

	    return tempPassword.toString();
	}

	@Override
	public List<MemberDto> findAll() {
		return memberDao.findAll();
	}
}
