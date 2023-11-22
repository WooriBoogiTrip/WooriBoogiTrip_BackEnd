package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;

public interface AttractionService {

	List<AttractionInfoDto> selectAttractioninfo(AttractionInfoDto info);

	AttractionInfoDto selectAttraction(int contentId);

}
