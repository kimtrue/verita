/**
 * 객체 이해하기
 * 
 * - 객체를 만드는 법
 * - 생성된 객체에 값을 설정
 * - 객체의 값을 꺼내는 방법
 * 
 */

 //빈 객체 생성
 let member = {};


//객체 프로퍼티 설정
//객체에 값 넣어주기
// 없으면 id를 만들어주고 있으면 id프로퍼티의 값을 변경해준다
 member.id = "hong";

 //객체에 프로퍼티 추가하는 방법. 권장X...
 member["email"] = "hong@.com"


 //객체 프로퍼티 확인 
 console.log(member.id);
 console.log(member["email"]);

 //member.id 처럼 . 방식이 안되는 경우...
 member["home-page"] = "a.com";
//  console.log(member.home-page);
 //ReferenceError: page is not defined 
 // => member.home 에서 page라는 변수를 빼겠다는 걸로 해석한다..
 //특수문자가 들어가는 것들은 이렇게 써주는 수 밖에 없다.. 
 console.log(member["home-page"]);