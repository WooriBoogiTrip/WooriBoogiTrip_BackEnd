package com.ssafy.member.controller;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/checkUserId")
    public ResponseEntity<Boolean> checkUserId(@RequestParam String userId) {
        boolean exists = memberService.idCheck(userId) > 0;
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
    
    @GetMapping("/mypage")
    public ResponseEntity<MemberDto> getUserInfo(HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if (memberDto != null) {
            return new ResponseEntity<>(memberDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/join")
    public ResponseEntity<Void> joinMember(@Valid @RequestBody MemberDto memberDto) {
        try {
            memberService.joinMember(memberDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/oauth2/login")
    public ResponseEntity<OAuth2AuthenticationToken> oauth2Login(OAuth2AuthenticationToken authentication) {
        // OAuth2 인증을 성공한 후의 로직
        OAuth2User oAuth2User = authentication.getPrincipal();
        // MemberDto memberDto = convertToMemberDto(oAuth2User); // 필요에 따라 변환
        // session.setAttribute("userinfo", memberDto); // 세션에 사용자 정보 설정
        return new ResponseEntity<>(authentication, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberDto> login(
            @RequestParam String userid,
            @RequestParam String userpwd,
            @RequestParam(required = false) String saveid,
            HttpSession session,
            HttpServletResponse response) {
        try {
            MemberDto memberDto = memberService.loginMember(userid, userpwd);
            if (memberDto != null) {
                session.setAttribute("userinfo", memberDto);

                if ("ok".equals(saveid)) {
                    Cookie cookie = new Cookie("ssafy_id", userid);
                    cookie.setPath("/");
                    cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
                    response.addCookie(cookie);
                }

                return new ResponseEntity<>(memberDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/find-password")
    public ResponseEntity<Void> findPassword(@RequestParam String email) {
        try {
            
            MemberDto member = memberService.findMemberByEmail(email);
            
            System.out.println(email);
            if (member != null) {
                String tempPassword = memberService.generateRandomPassword();
                System.out.println(tempPassword);
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(email);
                message.setSubject("발급된 임시 비밀번호입니다.");
                message.setText("임시 비밀번호 : " + tempPassword);
                mailSender.send(message);

                member.setUserPwd(tempPassword);
                memberService.updateMember(member);
                
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PutMapping("/update")
    public ResponseEntity<Void> updateMember(@RequestBody MemberDto memberDto, HttpSession session) {
        try {
            memberService.updateMember(memberDto);
            session.invalidate();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMember(HttpSession session) {
        String id = ((MemberDto) session.getAttribute("userinfo")).getUserId();
        try {
            memberService.deleteMember(id);
            session.invalidate();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<MemberDto>> findAll(){
    	
    	List<MemberDto> memberList = memberService.findAll();
    	
    	return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    
}
