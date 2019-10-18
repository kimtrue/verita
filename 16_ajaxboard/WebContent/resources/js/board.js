/* 스크립트 경로가 잘 지정되었는지 확인 alert(1);*/

// detail.jsp에서 스크립트로 넘긴 board.no 값 받는지 확인
//alert(no);


/**
 * ajax에서는 댓글의 삭제 수정할 때 게시글의 번호가 필요없다. 새로고침 하지 않기때문에
 * 
 * 삭제를 눌렀을 때 a링크로 페이지로 이동하면 안된다.
 * 
 */


/*댓글 목록을 가져오는 함수*/
function commentListAjax() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				//댓글 목록 처리
				//서버에서 가져오는 데이터를 넣어줄 곳
				//잘 갖고오는지 확인
				console.log(xhr.responseText);
				let list = JSON.parse(xhr.responseText);
				makeCommentList(list);				
			}
		}
	};
	/**
	 *  특정 게시글 에대한 댓글을 가져와야한다
	 *  `${board.no}` 는 자바스크립트의 값으로 인식한다. 
	 *  jsp에 스크립트를 하나 만들어 board.no 를 넘겨준다
	 *  
	 *  
	 *  commentList.do 서블릿 만들기
	 */
	xhr.open("GET","comment_list.do?no="+no, true);
	xhr.send();
}

/*페이지가 로딩됨과 동시에 댓글을 가져와야한다*/
commentListAjax(); 

// 댓글목록 뽑아주는 같은 작업
function makeCommentList(list) {
	let commentList = document.querySelector("#commentList");
	let html = "<table>";	
	for(let i = 0 ; i < list.length; i++){
		let comment = list[i];
		html += `
		<tr>
		  <td>${comment.writer}</td>
		  <td>${comment.content}</td>
		  <td>${comment.regDate}</td>
			  <td>
		  	  <a href="#" onclick="commentDeleteAjax(${comment.commentNo});">삭제</a>	
		  	  <a href="detail.do?commentNo=${comment.commentNo}">수정</a>	
		  </td>
	    </tr>
	    `
	}
	html += "</table>";
	commentList.innerHTML = html;
}






//댓글 삭제하는 함수
function commentDeleteAjax(commentNo){
	alert(commentNo);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				makeCommentList(JSON.parse(xhr.responseText));				
			}
		}
	};
	/**
	 *  특정 게시글 에대한 댓글을 가져와야한다
	 *  `${board.no}` 는 자바스크립트의 값으로 인식한다. 
	 *  jsp에 스크립트를 하나 만들어 board.no 를 넘겨준다
	 *  
	 *  
	 *  commentList.do 서블릿 만들기
	 */
	xhr.open("GET",`comment_delete.do?commentNo=${commentNo}&no=${no}`, true);
	xhr.send();

}



//새로고침을 막아주는 함수 
function commentRegistAjax(){
//	alert("commentR ajax"); 확인용
//	alert(commentNo);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				makeCommentList(JSON.parse(xhr.responseText));				
			}
		}
	};
	xhr.open("POST","comment_regist.do", true);
	//post 방식으로 파라미터 날리기
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	let f = document.crForm;
	
	//전송할 값들
	xhr.send(`no=${no}&writer=${f.writer.value}&content=${f.content.value}`);
    //새로고침X
	return false;
	
}



