package com.ssafy.plan.mapper;

import com.ssafy.plan.PlanDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PlanMapper {
    void insertPlan(PlanDto planDto);
    List<PlanDto> selectPlansByUserId(Long userId);
    // 기타 필요한 메소드 정의
}

