package com.ssafy.board.model;

import java.time.LocalDateTime;

public class BoardDto {

    private int noticeNo;
    private String userId;
    private String subject;
    private String content;
    private int hit;
    private LocalDateTime registerTime;  

    public int getArticleNo() {
        return noticeNo;
    }

    public void setArticleNo(int noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "NoticeDto [noticeNo=" + noticeNo + ", userId=" + userId +
               ", subject=" + subject + ", content=" + content +
               ", hit=" + hit + ", registerTime=" + registerTime + "]";
    }
}