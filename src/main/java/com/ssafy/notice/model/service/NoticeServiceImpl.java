package com.ssafy.notice.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.notice.model.NoticeDto;
import com.ssafy.notice.model.dao.NoticeDao;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao;
	

	public NoticeServiceImpl(NoticeDao noticeDao) {
		super();
		this.noticeDao = noticeDao;
	}

	@Override
	public void writeArticle(NoticeDto noticeDto) throws SQLException {
		noticeDao.writeArticle(noticeDto);

	}

	@Override
	public List<NoticeDto> listArticle(Map<String, Object> param) throws SQLException {
		return noticeDao.listArticle(param);
	}

	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		return noticeDao.getTotalArticleCount(param);
	}

	@Override
	public NoticeDto getArticle(int noticeNo) throws SQLException {
		return noticeDao.getArticle(noticeNo);
	}

	@Override
	public void updateHit(int noticeNo) throws SQLException {
		noticeDao.updateHit(noticeNo);
	}

	@Override
	public void modifyArticle(NoticeDto noticeDto) throws SQLException {
		noticeDao.modifyArticle(noticeDto);
	}

	@Override
	public void deleteArticle(int noticeNo) throws SQLException {
		noticeDao.deleteArticle(noticeNo);
	}

}
