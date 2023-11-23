package com.ssafy.plan.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.PlanDto;

@Mapper
public interface PlanDao {
    PlanDto createPlan(PlanDto planDto);
    List<PlanDto> getPlansByUserId(Long userId);
}
