package com.ssafy.plan;

import java.util.List;

public class PlanDto {
    private Long planId;
    private Long userId;
    private String title;
    private String description;
    private List<Long> attractionIds;
	public Long getPlanId() {
		return planId;
	}
	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getAttractionIds() {
		return attractionIds;
	}
	public void setAttractionIds(List<Long> attractionIds) {
		this.attractionIds = attractionIds;
	} 
    
    
}
