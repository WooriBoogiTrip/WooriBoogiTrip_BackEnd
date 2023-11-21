package com.ssafy.board.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
    private BoardDao boardDao;
    

	public BoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}


	@Override
	public void writeArticle(BoardDto boardDto) throws SQLException {
		boardDao.writeArticle(boardDto);
	}

	
	@Override
	public List<BoardDto> listArticle(Map<String, Object> param) throws SQLException {
		return boardDao.listArticle(param);
	}


	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		return boardDao.getTotalArticleCount(param);
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
		return boardDao.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		boardDao.updateHit(articleNo);

	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
		boardDao.modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		boardDao.deleteArticle(articleNo);
	}

}
