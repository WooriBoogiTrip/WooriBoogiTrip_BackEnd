package com.ssafy.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.plan.PlanDto;
import com.ssafy.plan.model.service.PlanService;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {

    private final PlanService planService;

    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<PlanDto> createPlan(@RequestBody PlanDto planDto) {
        return new ResponseEntity<>(planService.createPlan(planDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PlanDto>> getPlansByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(planService.getPlansByUserId(userId));
    }

    // 기타 CRUD 메소드 ...
}

