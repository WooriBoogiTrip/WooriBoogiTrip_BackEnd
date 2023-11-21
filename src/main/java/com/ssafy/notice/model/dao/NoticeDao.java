package com.ssafy.notice.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.notice.model.NoticeDto;

@Mapper
public interface NoticeDao {
    void writeArticle(NoticeDto noticeDto) throws SQLException;
    List<NoticeDto> listArticle(Map<String, Object> param) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	NoticeDto getArticle(int noticeNo) throws SQLException;
	void updateHit(int noticeNo) throws SQLException;
	void modifyArticle(NoticeDto noticeDto) throws SQLException;
	void deleteArticle(int noticeNo) throws SQLException;

}
