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
public class AttractionController {

    @Autowired
    private AttractionService attractionService;

    @Autowired
    private SidoGugunService sidoGugunService;

    
    @GetMapping("/sido")
    public ResponseEntity<List<SidoDto>> getSido() {
        List<SidoDto> sidoList = sidoGugunService.sidoList();
        return new ResponseEntity<>(sidoList, HttpStatus.OK);
    }

    @GetMapping("/gugun/{sidoCode}")
    public ResponseEntity<List<GugunDto>> getGugun(@PathVariable int sidoCode) {
        List<GugunDto> gugunList = sidoGugunService.gugunList(sidoCode);
        return new ResponseEntity<>(gugunList, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AttractionInfoDto>> getList(
            @RequestParam(required = false) Integer contentTypeId,
            @RequestParam(required = false) Integer sidoCode,
            @RequestParam(required = false) Integer gugunCode) {
        AttractionInfoDto info = new AttractionInfoDto();

        if (contentTypeId != null) {
            info.setContentTypeId(contentTypeId);
        }
        if (sidoCode != null) {
            info.setSidoCode(sidoCode);
        }
        if (gugunCode != null) {
            info.setGugunCode(gugunCode);
        }
        List<AttractionInfoDto> attractionList = attractionService.selectAttractioninfo(info);
        return new ResponseEntity<>(attractionList, HttpStatus.OK);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<AttractionInfoDto> getAttraction(@PathVariable int contentId) {
        AttractionInfoDto attractionInfo = attractionService.selectAttraction(contentId);
        return new ResponseEntity<>(attractionInfo, HttpStatus.OK);
    }
}
