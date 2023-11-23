package com.ssafy.plan.model.service;

import java.util.List;

import com.ssafy.plan.PlanDto;

public interface PlanService {
    PlanDto createPlan(PlanDto planDto);
    List<PlanDto> getPlansByUserId(Long userId);
}
