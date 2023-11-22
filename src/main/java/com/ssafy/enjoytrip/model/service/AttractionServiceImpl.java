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
    public List<AttractionInfoDto> selectAttractioninfo(AttractionInfoDto info){
        return attractionDao.selectAttractioninfo(info);
    }

    @Override
    public AttractionInfoDto selectAttraction(int contentId) {
        return attractionDao.selectAttraction(contentId);
    }
}

