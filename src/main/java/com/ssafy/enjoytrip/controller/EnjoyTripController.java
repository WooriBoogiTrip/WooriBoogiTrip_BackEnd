package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.GugunDto;
import com.ssafy.enjoytrip.model.SidoDto;
import com.ssafy.enjoytrip.model.service.AttractionService;
import com.ssafy.enjoytrip.model.service.SidoGugunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attractions")
public class EnjoyTripController {

    @Autowired
    private AttractionService attractionService;

    @Autowired
    private SidoGugunService sidoGugunService;

    
    @GetMapping("/korea-tourist-spots/{sidoCode}") // 부산 : sidoCode 6 !
    public ResponseEntity<?> getTouristSpots(@PathVariable int sidoCode) {
        try {
            // 한국관광공사 API를 호출하는 서비스 메소드
            List<AttractionInfoDto> attractions = attractionService.getKoreaTouristSpots(sidoCode);
            return ResponseEntity.ok(attractions);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/updateDefault")
    public List<SidoDto> updateDefault() {
        return sidoGugunService.sidoList();
    }

    @GetMapping("/updateGugun/{sidoCode}")
    public List<GugunDto> updateGugun(@PathVariable int sidoCode) {
        return sidoGugunService.gugunList(sidoCode);
    }

    @GetMapping("/updateMap")
    public List<AttractionInfoDto> updateMap(@RequestParam int sidoCode, @RequestParam int contentTypeId) {
        AttractionInfoDto attractionInfoDto = new AttractionInfoDto();
        attractionInfoDto.setSidoCode(sidoCode);
        attractionInfoDto.setContentTypeId(contentTypeId);
        return attractionService.attractionList(attractionInfoDto);
    }
}
