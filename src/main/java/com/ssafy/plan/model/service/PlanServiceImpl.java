package com.ssafy.plan.model.service;

import com.ssafy.plan.PlanDto;
import com.ssafy.plan.mapper.PlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanMapper planMapper;

    @Autowired
    public PlanServiceImpl(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Override
    public PlanDto createPlan(PlanDto planDto) {
        planMapper.insertPlan(planDto);
        return planDto; // 마이바티스는 삽입 후 생성된 객체를 반환하지 않습니다.
    }

    @Override
    public List<PlanDto> getPlansByUserId(Long userId) {
        return planMapper.selectPlansByUserId(userId);
    }

    // 기타 필요한 메소드 구현
}