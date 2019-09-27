/**
 * 객체의 디스트럭처링
 * 
 */

 function getMember(){
     return {
         id: "a",
         name: "aba",
         age: 1
     };
 }
 let m = getMember();
 console.log(m.id, m.name, m.age); //a aba 1
/*
 //객체
 //변수 선언자리에 {} or [] 가 오면 destructuring 하겠다는 의미
 let {id, name, age} = getMember();
console.log(id, name, age); //a aba 1


//받아오는 변수명 바꾸기
let {id: id1, name: name1, age: age1} = getMember();
console.log(id1, name1, age1);

//email을 eee로 변수명 바꾼것.
let{email: eee, addr} = {email: "jay@a.com", addr: "seoul gangnam"};
// console.log(email);email is not define
console.log(eee);
*/




/*
//위 getMember에는 정의되지 않은 email
let {id, name, age, email} = getMember();
console.log(id, name, age, email);
//email 변수는 만들어졌지만 email이 없어서 undefined
//디폴트값을 설정해줄 수 있다
*/
let {id, name, age, email="jay@a.com"} = getMember();
console.log(id, name, age, email);