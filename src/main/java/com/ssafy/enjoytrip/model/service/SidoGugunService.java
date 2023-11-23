package com.ssafy.enjoytrip.model.service;

import java.util.List;

import com.ssafy.enjoytrip.model.SidoDto;
import com.ssafy.enjoytrip.model.GugunDto;

public interface SidoGugunService {

	List<SidoDto> sidoList();
	List<GugunDto> gugunList();
	List<GugunDto> gugunList_fake();

}
