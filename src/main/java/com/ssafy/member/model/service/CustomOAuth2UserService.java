package com.ssafy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private MemberService memberService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // OAuth2 공급자로부터 사용자 정보를 가져옴
        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 필요한 경우 사용자 정보를 데이터베이스에 저장하거나 업데이트
        // 예: MemberDto member = convertToMemberDto(oAuth2User);
        // memberService.saveOrUpdateMember(member);

        return oAuth2User;
    }

    // OAuth2User를 MemberDto로 변환하는 메서드
    private MemberDto convertToMemberDto(OAuth2User oAuth2User) {
        // ...
    }
}
