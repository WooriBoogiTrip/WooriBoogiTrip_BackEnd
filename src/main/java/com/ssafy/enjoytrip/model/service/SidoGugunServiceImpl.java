package com.ssafy.enjoytrip.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.model.GugunDto;
import com.ssafy.enjoytrip.model.SidoDto;
import com.ssafy.enjoytrip.model.dao.SidoGugunDao;

@Service
public class SidoGugunServiceImpl implements SidoGugunService {
	
    @Autowired
    private SidoGugunDao sidoGugunDao;

	@Override
	public List<SidoDto> sidoList() {
		return sidoGugunDao.sidoList();
	}

	@Override
	public List<GugunDto> gugunList() {
		return sidoGugunDao.gugunList();
	}

}
