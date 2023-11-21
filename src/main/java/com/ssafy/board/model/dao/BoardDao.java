package com.ssafy.board.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {
	
    void writeArticle(BoardDto boardDto) throws SQLException;
    List<BoardDto> listArticle(Map<String, Object> param) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	BoardDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
	
}
