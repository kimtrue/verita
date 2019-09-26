
/**
 * let id = setInterval(콜백함수, 밀리세컨드);
 * -> 시간마다 계속 호출
 * 
 * clearInterval(id);
 * 
 * 
 */

 function func() {
   console.log("func호출됨");
 }
 //1초뒤 func을 호출해줭
//  setTimeout(func, 1000);
 let id = setInterval(func, 1000);

//  5초정도 뒤에
 //중단시키고싶을 때
//  setTimeout(function(){clearInterval(id);}, 5100);
//화살표 함수로 바꾸기
 setTimeout(() => clearInterval(id), 5100);