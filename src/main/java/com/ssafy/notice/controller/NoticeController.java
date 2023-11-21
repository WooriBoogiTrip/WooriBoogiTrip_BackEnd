package com.ssafy.notice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.MemberRole;
import com.ssafy.notice.model.NoticeDto;
import com.ssafy.notice.model.service.NoticeService;

@RestController
@RequestMapping("/api/v1/notices")
public class NoticeController {
	
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public ResponseEntity<List<NoticeDto>> list(@RequestParam Map<String, Object> params) {
        try {
            List<NoticeDto> list = noticeService.listArticle(params);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view/{noticeNo}")
    public ResponseEntity<NoticeDto> view(@PathVariable int noticeNo) {
        try {
            NoticeDto noticeDto = noticeService.getArticle(noticeNo);
            noticeService.updateHit(noticeNo);
            return new ResponseEntity<>(noticeDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody NoticeDto noticeDto, HttpSession session) {
        try {
        	MemberDto currentMember=(MemberDto) session.getAttribute("userinfo");
        	
        	if(currentMember==null||!MemberRole.ADMIN.equals(currentMember.getRole())) {
        		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        	}
   
            noticeService.writeArticle(noticeDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/modify/{noticeNo}")
    public ResponseEntity<NoticeDto> mvModify(@PathVariable int noticeNo) {
        try {
            NoticeDto noticeDto = noticeService.getArticle(noticeNo);
            return new ResponseEntity<>(noticeDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<Void> modify(@RequestBody NoticeDto noticeDto) {
        try {
            noticeService.modifyArticle(noticeDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{noticeNo}")
    public ResponseEntity<Void> delete(@PathVariable int noticeNo) {
        try {
            noticeService.deleteArticle(noticeNo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
