package ch08_method.board;

import java.util.Scanner;

public class BoardUI {
	// 사용자가 직접 보면서 입력하는 것을 넣는다
	// 로그인 사용자 아이디
	BoardDAO dao = new BoardDAO();
	String loginId = "hong";
	Scanner sc = new Scanner(System.in);


	int menu() {

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

	void service() {
		System.out.println("-----------------");
		System.out.println("자바로 구현하는 게시판 프로젝트");
		System.out.println("-----------------");
		while (true) {
			switch (menu()) {

			case 1:
				select();
				break;

			case 2:
				selectOne();
				break;

			case 3:
				write();
				break;

			case 4:
				modify();
				break;

			case 5:
				delete();
				break;

			case 0:
				exit();

			default:
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
			}

		}
	}

	void select() {
		//화면에 출력할 전체 게시물. DAO가 갖고 있따
		//전체의 게시물 목록을 DAO에게 달라고하라
		Board[] list = dao.selectBoard(); //전체를 보는 거라
		
		System.out.println("전체 " + list.length + "개");
		System.out.println("-------------------------------");
		System.out.println("번호 글쓴이 제목  작성일");
		System.out.println("-------------------------------");
		if (list.length == 0) {
			System.out.println("게시물이 없습니다.");
		}
		//최신글부터 보려고 작업
		for (int i = list.length - 1; i >= 0; i--) {
			Board b = list[i];
			System.out.printf("%3d %10s %20s %15s\n", b.getNo(), b.getWriter(), b.getTitle(), b.getRegDate());
		}

	}
	
	/**
	 * 게시글 하나를 찾는 것
	 */

	void selectOne() {
		System.out.print("조회할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		/**하나도 이해 못했음*/
		//dao 글번호에 해당하는 게시물 요청
		Board b = dao.selectOneBoard(no);
		System.out.println("-------------------------------");
		if(b != null) {
			System.out.println("번호 : " + no);
			System.out.println("글쓴이 : " + b.getWriter());
			System.out.println("제목 : " + b.getTitle());
			System.out.println("내용 : " + b.getContent());
			System.out.println("작성일시 : " + b.getRegDate());
			System.out.println("-------------------------------");
			return;
		}

			System.out.println("입력된 번호는 존재하지 않습니다.");

	}

	void write() {
		// 데이터 관리 배열
		Board b = new Board(); // 보드가 여러개의 값을 갖고 여러개를 한번에 갖고다닌다
		System.out.print("제목을 입력하세요 : ");
		b.setTitle(sc.nextLine());
		System.out.print("내용을 입력하세요 : ");
		b.setContent(sc.nextLine());
		System.out.print("작성일시를 입력하세요 : ");
		b.setRegDate(sc.nextLine());

// 로그인 정보에 있는 이름으로 작성자를 설정한다.
		b.setWriter(loginId);

		// 입력받은 값을 다 주면 등록
		//dao 출력
		dao.insertBoard(b);

		System.out.println();
		System.out.println("게시글이 등록되었습니다.");

	}
		



	

	void modify() {
		//입력된 글번호가 있는지 check
		
		System.out.print("수정할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		
		//board 타입을 넘겨서 주소나 없으면 null 
		Board board = dao.selectOneBoard(no); 
		if(board == null) {
			System.out.println("해당 게시물이 존재하지 않습니다.");
			return;
		}
		//글번호가 확실히 있다는 것을 알았다 수정할 내용을 받는다.
		System.out.print("제목을 입력하세요 : ");
		board.setTitle(sc.nextLine());
		System.out.print("내용을 입력하세요 : ");
		board.setContent(sc.nextLine());
		
		//업데이트 구현하러 업데이트 DAO로..
		dao.upDateBoard(board);

		System.out.println();
		System.out.println("게시글이 수정되었습니다.");
	}
		
		
		
		
	void exit() {
		sc.close();
//완전히 끝내기	
		System.exit(0);
	}

	void delete() {
		System.out.print("삭제할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		int result = dao.deleteBoard(no);
		if (result == 1) {
			System.out.println();
			System.out.println("게시글이 삭제되었습니다.");
			return;
		}
		System.out.println("해당 게시물이 존재하지 않습니다.");
	}

		
		
		
		

	

}
