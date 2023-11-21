package com.ssafy.member.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ssafy.board.model.BoardDto;

public class MemberDto {

	@NotBlank(message = "User ID is required")
	private String userId;
	
    @NotBlank(message = "User Name is required")
    private String userName;

    @NotBlank(message = "Password is required")
    private String userPwd;
    
	private String email;
	
	private String sido;
	
	private String gungu;
	
	private String joinDate;
	
	private MemberRole role;
	
	private List<BoardDto> userPosts;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGungu() {
		return gungu;
	}

	public void setGungu(String gungu) {
		this.gungu = gungu;
	}
	
    public List<BoardDto> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<BoardDto> userPosts) {
        this.userPosts = userPosts;
    }
    
	public MemberRole getRole() {
		return role;
	}

	public void setRole(MemberRole role) {
		this.role = role;
	}


    @Override
    public String toString() {
        return "MemberDto [userId=" + userId + ", userName=" + userName + 
                ", userPwd=" + userPwd + ", email=" + 
                email + ", joinDate=" + joinDate + ", userPosts=" + userPosts + "]";
    }


}
