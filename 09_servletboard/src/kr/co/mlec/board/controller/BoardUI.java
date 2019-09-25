package kr.co.mlec.board.controller;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;

public class BoardUI {
	
	private BoardDAO dao;
	private Scanner sc = new Scanner(System.in);

	public BoardUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		dao = session.getMapper(BoardDAO.class);
	}
	
	private void exit() {
		sc.close();
		// 프로세스 종료
		System.out.println("게시판 시스템을 종료합니다.");
		System.exit(0);
	}
	
	private int menu() {
		System.out.println("-----------------");
		System.out.println("1. 전체 조회");
		System.out.println("2. 글번호 조회");
		System.out.println("3. 글등록");
		System.out.println("4. 글수정");
		System.out.println("5. 글삭제");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		return Integer.parseInt(sc.nextLine());	
	}
	
	public void service() {
		System.out.println("-----------------");
		System.out.println("자바로 구현하는 게시판 프로젝트");
		System.out.println("-----------------");
		BaseUI ui = null;
		/*
		while (true) {
			switch (menu()) {
			case 1: ui = new ListBoardController(dao); break;
			case 2: ui = new DetailBoardController(dao); break;
			case 3: ui = new WriteFormBoardController(dao); break;
			case 4: ui = new UpdateBoardController(dao); break;
			case 5: ui = new DeleteBoardUI(dao);  break;
			case 0: exit();
			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}
			
			if (ui != null) ui.service();
		}		
		 */
	}
}








