function foo(){
    console.log(1);
}
//호이스팅
/**
 * foo 올라간다..
 * 
 * 
 */
//3이 찍힌다
foo(); 
var foo = function(){
    console.log(2);
}
foo();

function foo(){
    console.log(3);
}