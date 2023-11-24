package com.ssafy.plan.model.service;

import com.ssafy.plan.PlanDto;
import java.util.List;

public interface PlanService {
    PlanDto createPlan(PlanDto planDto);
    List<PlanDto> getPlansByUserId(Long userId);
    // 기타 필요한 서비스 메소드
}