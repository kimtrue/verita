let msg1;
if(msg1 === undefined) console.log("변수는 존재하지만 값이 없다");

let msg2 = 20;
msg2 = undefined; //직접 type이 없는 상태로 만들어준다

msg2 === undefined && console.log("undefined 직접 비교 가능함");

msg3 = null; //특정개체를 가르키고 있지 않다
