/**
 * ecma6 추가
 * 
 * let 
 * : 변수 선언시 var를 사용하기 보단
 *   선언된 블럭에서만 사용가능
 *   자바와 비슷하다
 *   덮어쓰지 않는다
 * 
 * 
 */

var msg = 1;
if(msg == 1){
    let msg = 2;
    console.log(msg);
}
console.log(msg);
{
    
}