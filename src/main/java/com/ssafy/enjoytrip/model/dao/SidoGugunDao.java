package com.ssafy.enjoytrip.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.model.SidoDto;
import com.ssafy.enjoytrip.model.GugunDto;

@Mapper
public interface SidoGugunDao {
	
	List<SidoDto> sidoList();
	List<GugunDto> gugunList(int sidoCode);
}
