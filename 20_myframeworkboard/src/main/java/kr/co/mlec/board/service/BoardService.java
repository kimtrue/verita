package kr.co.mlec.board.service;

import java.util.List;

import org.springframework.web.servlet.WebUtil;

import com.google.gson.JsonElement;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;
import kr.co.mlec.repository.vo.Comment;

public class BoardService {
	private BoardDAO dao;
	public BoardService() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	public List<Board> list() {
		
		return dao.selectBoard();
	}
	//게시판 등록
	public void insertBoard(Board board) {
		dao.insertBoard(board);
	}
	//게시판 수정
	public void updateBoard(Board board) {
		dao.updateBoard(board);
	}
	
	//게시판 삭제
	public void deleteBoard(int no) {
		dao.deleteBoard(no);
	}
	
	
	//상세 게시판
	public Board detailBoard(int no) {
		dao.updateViewCnt(no);
		return dao.selectOneBoard(no);
	}
	
	
	//댓글리스트 
	public List<Comment> selectComment(int no) {
		return dao.selectComment(no);
	}
		
	
	//댓글 작성 
	public List<Comment> insertComment(Comment comment) {
		dao.insertComment(comment);
		return dao.selectComment(comment.getNo());
	}
		
	//댓글 수정
	public List<Comment> updateComment(Comment comment) {
		dao.updateComment(comment);
		return dao.selectComment(comment.getNo());
	}
	
	//댓글 삭제
	public List<Comment> commentDelete(Comment comment) {
		dao.deleteComment(comment.getCommentNo());
		// 댓글 목록 공유
		return dao.selectComment(comment.getNo());
	}

	
	
	
}
