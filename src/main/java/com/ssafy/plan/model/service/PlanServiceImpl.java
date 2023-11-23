package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.plan.PlanDto;
import com.ssafy.plan.model.dao.PlanDao;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
    private PlanDao planDao;

    @Override
    public PlanDto createPlan(PlanDto planDto) {
    	return planDao.createPlan(planDto);
    }

    @Override
    public List<PlanDto> getPlansByUserId(Long userId) {
        return planDao.getPlansByUserId(userId);
    }
}
