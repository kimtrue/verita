/**
 * ES6 활용
 * 
 * spread 연산자
 * 객체활용
 * 라이브러리가 기존객체를 변경하지 않으면서 새로운 객체를 생성해낸다
 * 
 * 객체의 내용을 복사해서 다른객체를 만들 때 편리하다 
 * 
 */
let member = {
    id: "a",
    name: "b",
    age: 31
};

//member.email = "a@a.com" 을 라이브러리가 허용하지 않는다
member = {
    id: member.id,
    name: member.name,
    age: member.age,
    email: "a@a.com"
};

let member2 = {
    //기존의 멤버가 갖고있는 값과 이름을 그대로 갖고와야한다
    //스프레드 연산자를 이용해 활용
    ...member,
    email: "a@a.com"
}
// console.log(member2);

//값 오버라이딩하기
let member3 = {
    ...member,
    id: "ccc"
}
console.log(member3);

//순서에 영향이 있어서 id값이 안바뀐다
//기존의 프로퍼티 변경하면서 복사 실패
let member4 = {
    id: "ccc",
    ...member
}
console.log(member4);