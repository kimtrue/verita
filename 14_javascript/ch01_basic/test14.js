/**
 * javascript 의 문자열
 * - ""로 감싸는 문자열
 * - ''로 감싸는 문자열 
 * - ``(bakctick)로 감싸는 문자열 (위 숫자키보드 1 옆에있다) 템플릿 문자열
 * 
 * 백틱을 사용하는 이유
 *   "" '' 도 다 사용했을 때 문자열로 묶어주기 위해
 *  변수를 같이 사용 가능하다. ${변수명}
 *  주의할 점. 
 *  .jsp 에서 다이렉트로 사용하면 
 *   =>톰캣엔진이 먼저 해석해서 el로 인식해서 name을 공유영역에서 찾아 길이가 0이 나온다
 *  .js 파일로 따로 빼서 사용해야한다
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
 
 //백틱
 msg = `나의 이름은 "${name}" 입니다.`;
 console.log(msg);
 


 //백틱
 msg = `<input type='text' onclick='alert("클릭됨")' />`;

 