package com.ssafy.board.controller;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/articles")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> list(@RequestParam Map<String, Object> params) {
        try {
            List<BoardDto> list = boardService.listArticle(params);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view/{articleNo}")
    public ResponseEntity<BoardDto> view(@PathVariable int articleNo) {
        try {
            BoardDto boardDto = boardService.getArticle(articleNo);
            boardService.updateHit(articleNo);
            return new ResponseEntity<>(boardDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/write")
    public ResponseEntity<Void> write(@RequestBody BoardDto boardDto) {
        try {
            boardService.writeArticle(boardDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/modify/{articleNo}")
    public ResponseEntity<BoardDto> mvModify(@PathVariable int articleNo) {
        try {
            BoardDto boardDto = boardService.getArticle(articleNo);
            return new ResponseEntity<>(boardDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<Void> modify(@RequestBody BoardDto boardDto) {
        try {
            boardService.modifyArticle(boardDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{articleNo}")
    public ResponseEntity<Void> delete(@PathVariable int articleNo) {
        try {
            boardService.deleteArticle(articleNo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
