/**
 * 객체의 단축 표현 이해하기
 * 
 */

 let id = 'jay', 
    name = '정',
    age = 24;
 
 //변수의 이름을 프로퍼티명으로 사용   
let member1 = {
    //위의 것과 동일하다면 생략가능하다.
    // id: id,
    id,
    // name: name,
    name,
    // age: age, 
    age,
    info: function(){
        console.log("info펑션..")

    }
};
console.log(member1);

//함수의 단축
let member2 = {
    id,
    name,
    age,
    info(){console.log("info펑션..");}
};

console.log(member2);



 function setInfo(id, name, age){
     return {
         id: id,
         name: name,
         age: age
     };
 }   
 let m = setInfo("hong", "홍", 28);
