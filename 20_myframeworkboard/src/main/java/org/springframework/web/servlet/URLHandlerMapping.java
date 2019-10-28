package org.springframework.web.servlet;

import java.util.HashMap;
import java.util.Map;

import kr.co.mlec.board.controller.CommentDeleteController;
import kr.co.mlec.board.controller.CommentListAjaxController;
import kr.co.mlec.board.controller.CommentRegistController;
import kr.co.mlec.board.controller.CommentUpdateController;
import kr.co.mlec.board.controller.DeleteBoardController;
import kr.co.mlec.board.controller.DetailBoardController;
import kr.co.mlec.board.controller.ListBoardController;
import kr.co.mlec.board.controller.UpdateBoardController;
import kr.co.mlec.board.controller.UpdateFormBoardController;
import kr.co.mlec.board.controller.WriteBoardController;
import kr.co.mlec.board.controller.WriterFormBoardController;
import kr.co.mlec.login.controller.LoginController;
import kr.co.mlec.login.controller.LoginFormController;
import kr.co.mlec.login.controller.LogoutController;
import kr.co.mlec.main.controller.MainController;

public class URLHandlerMapping {
	//url과 controller 관리. 누군가 자기를 부르면
	private Map<String, Controller> mappings = new HashMap<>();
	public URLHandlerMapping() {
		mappings.put("/main.do", new MainController());
		mappings.put("/login/login.do", new LoginController());
		mappings.put("/login/loginform.do", new LoginFormController());
		mappings.put("/login/logout.do", new LogoutController());
		mappings.put("/board/list.do", new ListBoardController());
		mappings.put("/board/write.do", new WriteBoardController());
		mappings.put("/board/writeform.do", new WriterFormBoardController());
		mappings.put("/board/detail.do", new DetailBoardController());
		mappings.put("/board/update.do", new UpdateBoardController());
		mappings.put("/board/updateform.do", new UpdateFormBoardController());
		mappings.put("/board/delete.do", new DeleteBoardController());
		mappings.put("/board/comment_list.do", new CommentListAjaxController());
		mappings.put("/board/comment_regist.do", new CommentRegistController());
		mappings.put("/board/comment_update.do", new CommentUpdateController());
		mappings.put("/board/comment_delete.do", new CommentDeleteController());
	}

	public Controller getContoController(String uri) {
		return mappings.get(uri);
	}
}
