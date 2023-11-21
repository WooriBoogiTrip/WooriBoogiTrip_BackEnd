package com.ssafy.enjoytrip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.dao.AttractionDao;

@Service
public class AttractionServiceImpl implements AttractionService {
	
    @Autowired
    private AttractionDao attractionDao;


	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		return attractionDao.attractionList(attractionInfoDto);
	}

	@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		return attractionDao.searchByTitle(title, sidoCode);
	}

	@Override
	public List<AttractionInfoDto> getKoreaTouristSpots(int sidoCode) {
		List<AttractionInfoDto> attractionDaoList = attractionDao.getKoreaTouristSpots(sidoCode);
		return attractionDaoList;
	}

}
