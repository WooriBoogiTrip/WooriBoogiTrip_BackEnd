package com.ssafy.plan;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlanDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(nullable = false)
    private Long userId;

    private String title;
    private String description;


    private List<Long> attractionIds = new ArrayList<>();

}
