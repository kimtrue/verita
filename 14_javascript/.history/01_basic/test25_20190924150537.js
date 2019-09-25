/**
 * undefined, null, NaN 은 값을 직접 줄 수 있다
 * 
 */
let msg1;
if(msg1 === undefined) console.log("변수는 존재하지만 값이 없다");

let msg2 = 20;
msg2 = undefined; //직접 type이 없는 상태로 만들어준다

msg2 === undefined && console.log("undefined 직접 비교 가능함");

msg3 = null; //특정개체를 가르키고 있지 않다
if(msg3 === null) console.log("msg3는 null이다");

//NaN : Not a Number
//number type
let msg4 = 10 - 'a';
console.log(msg4, typeof(msg4));
msg4 = 10;
console.log(msg4);
msg4 = NaN;
console.log(msg4);