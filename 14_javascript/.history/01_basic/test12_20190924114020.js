/**
 * ecma6 추가
 * 
 * let 
 * : 변수 선언시 var를 사용하기 보단
 *   선언된 블럭에서만 사용가능
 *   자바와 비슷하다
 *   덮어쓰지 않는다
 * 
 * =>호이스팅에서 제외된다
 * 
 */

var msg = 1;
if(msg == 1){
    let msg = 2;
    console.log(msg);
}
console.log(msg);
{
    let msg2 = 3;
}
console.log(msg2);
