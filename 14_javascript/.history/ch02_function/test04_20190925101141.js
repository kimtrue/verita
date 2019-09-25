//호이스팅
/**
 * foo 올라간다..
 * 이미 있네... 넘어간다..
 * 함수 foo 이미 있다.. 주소값이 대입된다...
 * 
 * 
 */
//3이 찍힌다
/** 
function foo(){
    console.log(1);
}
foo(); 
var foo = function(){
    console.log(2);
}
foo();

function foo(){
    console.log(3);
}