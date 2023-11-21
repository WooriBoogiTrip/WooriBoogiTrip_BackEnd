package com.ssafy.enjoytrip.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.model.AttractionInfoDto;

@Mapper
public interface AttractionDao {

	List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto);
	List<AttractionInfoDto> searchByTitle(String title, int sidoCode);
	List<AttractionInfoDto> getKoreaTouristSpots(int sidoCode);

}
