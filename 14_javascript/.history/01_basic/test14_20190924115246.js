/**
 * javascript 의 문자열
 * - ""로 감싸는 문자열
 * - ''로 감싸는 문자열 
 * - ``(bakctick)로 감싸는 문자열 (위 숫자키보드 1 옆에있다) 템플릿 문자열
 * 
 * 
 * 
 */

 let msg = "자바스크립트 문자열";
 console.log(msg);
 
 msg = '싱글 자바스크립트 문자열';
 console.log(msg);
 
 msg = `백틱 자바스크립트 문자열`;
 console.log(msg);

 name = "고길동";
 msg = "나의 이름은 " + name + "입니다."
 console.log(msg);

 //이름에 더블쿼티션 붙이기
 name = "고길동";
 msg = "나의 이름은 \"" + name + "\"입니다."
 console.log(msg);
 
 //javascript
 name = "고길동";
 msg = '나의 이름은 "' + name + '"입니다.'
 console.log(msg);

 msg = <input type='text' onclick='alert("클릭됨")'></input>
 