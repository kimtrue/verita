package kr.co.mlec.board.controller;

import kr.co.mlec.repository.dao.BoardDAO;

public class DeleteBoardUI extends BaseUI {
	private BoardDAO dao;
	
	public DeleteBoardUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {
		int no = getInt("삭제할 글번호를 입력하세요 : ");
		int result = dao.deleteBoard(no);
		if (result == 1) {
			System.out.println();
			System.out.println("게시글이 삭제되었습니다.");
			return;
		}
		System.out.println("해당 게시물이 존재하지 않습니다.");
	}
}
