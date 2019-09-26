/**
 * 자바스크립트 생성자 이해
 * 
 * - 일반함수와 동일하게 선언 사용 가능함
 * - 일반적으로 이름을 보통 대문자로 선언한다(Number, Array, Date)
 * - 생성자 역할로 사용하려면 반드시 "new"와 함께 사용해야 한다.
 * - 생성자 함수로 생성되면 함수내에서의 this의 해석이 달라진다
 *   원래 this는 자신을 부르는 애인데... 
 * 
 *   this 는 만들어진 공간을 가르킨다
 * 
 */

 function Member() {
     console.log(this);

 }

 //두 개의 차이를 확인해보자
 let m1 = Member(); //undefined 일반함수 
 let m2 = new Member();// 새로운 객체를 만들어준다 그 공간을 m2에게 반환해준다 return 이 없어도
 console.log("m1 : ", m1);
 console.log("m2 : ",m2);