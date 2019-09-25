/* 
basic 종합문제

게시판 관리 프로그램 작성하기 
목표 : 지금까지 배운 문법을 이용하여 작성하면서 자바스크립트에 대해서 익숙해진다.

아래와 같이 출력 될 수 있도록 게시판 관리 프로그램을 작성한다.

------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 1
전체 0개
-------------------------------
번호	글쓴이	제목
-------------------------------
게시물이 존재하지 않습니다.
-------------------------------
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 2
조회할 글번호를 입력하세요 : 1
-------------------------------
입력된 번호는 존재하지 않습니다.
-------------------------------
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 3
제목을 입력하세요 : test
글쓴이를 입력하세요 : 홍길동
게시글 등록이 완료되었습니다.
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 1
전체 1개
-------------------------------
번호	글쓴이	제목
-------------------------------
1	홍길동	test
-------------------------------
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 2
조회할 글번호를 입력하세요 : 1
-------------------------------
번호 : 1
글쓴이 : 홍길동
제목 : test
-------------------------------
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 4
수정할 글번호를 입력하세요 : 1
변경할 제목을 입력하세요 : 수정된 제목
게시글이 수정되었습니다.
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 2
조회할 글번호를 입력하세요 : 1
-------------------------------
번호 : 1
글쓴이 : 홍길동
제목 : 수정된 제목
-------------------------------
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 5
삭제할 글번호를 입력하세요 : 1
게시글이 삭제되었습니다.
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 1
전체 0개
-------------------------------
번호	글쓴이	제목
-------------------------------
게시물이 존재하지 않습니다.
-------------------------------
------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------
메뉴 중 처리할 항목을 선택하세요 : 0
게시판 프로그램을 종료합니다    
 */
let prompt = require("prompt-sync")();

 let board = [];
 

 let msg;
 let flag = true; 
 while(flag){

msg = `------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글등록
4. 글수정
5. 글삭제
0. 종료
------------------------------------ 
 `;
console.log(msg);
let num = prompt("메뉴 중 처리할 항목을 선택하세요 :");

switch(num){
case "1":
    if(board.length == 0)console.log("게시물이 없습니다");
    else
     for(let i = 0; i < board.length; i++){
        arr = board[i]; 
        console.log(arr[0], arr[1], arr[2]);
        }
     break;     
case "2":
    let two = prompt("조회할 번호 입력 : ");
    if(board[parseInt(two)-1] == null)console.log("해당번호는 없습니다");
    else
        console.log(board[parseInt(two)-1]);   
    break;

case "3":
    arr = [];
    no = board.length+1;
    title = prompt("글제목 입력 : ");
    writer = prompt("글쓴이 : ");
    content = prompt("내용 : ");  
     arr.push(no, title, writer, content);
     board.push(arr);
    console.log("글이 등록되었습니다"); 
    break;
case "4":
    arr = [];
    let four = prompt("수정할 번호 입력: ");
    if(board[parseInt(four)-1] == null)console.log("해당번호는 없습니다");
    else{
    title = prompt("수정할 글제목 입력 : ");
    writer = prompt("수정할 글쓴이 입력 : ");
    content = prompt("수정할 내용 입력 : ");
    arr.push(title, writer, content);
    board.splice(parseInt(four-1), 1, arr);
    console.log("수정되었습니다");
     }
    break;
case "5":
     let five = prompt("삭제할 번호 입력: ");
     if(board[parseInt(four)-1] == null)console.log("해당번호는 없습니다"); 
     else {
     arr.splice(parseInt(five-1), 1);
     }
     break;
case "0": flag = false;
          console.log("종료합니다");               



}



}