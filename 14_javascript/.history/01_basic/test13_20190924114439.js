/**
 * es6에서 추가된 키워드
 * 
 * const : let와 유사. 상수개념. 변경X 
 *         중복선언이 안된다. 
 *         호이스팅이 안된다.
 * 
 * 
 * 
 */

 const msg = "hi";
 const msg = "hello";//SyntaxError: Identifier 'msg' has already been declared
 console.log(msg);


 msg = "bye"; 
 console.log(msg); //TypeError: Assignment to constant variable