/**
 * 
 * Node를 이용한 서드파티 모듈 사용하기
 * => 기본적으로 제공되지 않는 것을 사용한다
 * 
 * java| Scanner
 * Node| prompt-sync
 *       npm install prompt-sync =>터미널에 입력. 실행. node modules이 생긴다.  
 *      
 * 
 * nodejs 에서 설치된 모듈 사용하기
 * 변수를 주고 가져올 때 require("설치된 모듈명")
 * let prompt = require("prompt-sync")();
 * let prompt = require("prompt-sync")();
 * 
 */
 let prompt = require("prompt-sync")();
 let name = prompt("이름 : ")