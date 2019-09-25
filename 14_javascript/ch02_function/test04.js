//호이스팅
/**
 * foo 올라간다..
 * 이미 있네... 넘어간다..
 * 함수 foo 이미 있다.. 주소값이 대입된다...
 * var가 있어서
 * 
 * let를 사용하면 중복을 허용하지 않아서 코딩이 정확해진다
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
*/
    function foo(){
        console.log(1);
    }
    foo(); 
    let foo = function(){
        console.log(2);
    }
    foo();
    
    function foo(){
        console.log(3);
    }