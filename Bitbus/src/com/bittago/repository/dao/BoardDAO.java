package com.bittago.repository.dao;

import java.util.List;

import com.bittago.repository.vo.Board;
import com.bittago.repository.vo.File;
import com.bittago.repository.vo.Page;

public interface BoardDAO {
		//관리자 게시글 조회
		List<Board> selectAdminBoard();
		// 전체 게시글 조회
		List<Board> selectBoard(Page page);
		// 전체 게시글 갯수
		int selectBoardCount();
		// 전체 검색
		List<Board>selectSearch(Page page);
		// 게시글1, 이전, 다음글 조회
		Board selectOneBoard(int boardNo);
		// 게시글 파일 조회
		File selectOneBoardFile(int boardNo);
		// 다운로드 파일 조회
		File selectDownloadFile(File file);
		// 게시글 조회수 증가
		void updateViewCnt(int boardNo);  
		// 게시물 등록
		void insertBoard(Board board);
		// 파일 등록
		void insertFile(File file);
		
}







