/**
 * 자바스크립트의 false인 값
 * 
 * - null
 * - undefined
 * - NaN
 * - 숫자 0
 * - ''길이가 없는 문자   
 */

 console.log(0);//0
 console.log(!0);//not 0 => 논리형으로 바꿔서 true가 나온다
 console.log("0 : " , !!0);//notnot 0 => 논리형의 바꿔서 true의 반대 (원래의 값)이 나온다
 console.log("9 : ", !!9);//false 숫자0 빼고 다 true이다
 console.log("null : ", !!null);
 console.log("undefined : ", !!undefined);
 console.log("NaN : ", !!NaN);

let id; //undefined , false
if(id) { //if(false)
    console.log("id가 값을 갖고 있다")
}
else {
    console.log("id가 값이 없다..")
    id = "kong";
}
console.log("id : ", id);

//---------------------------------

let id="kim"; //true 
if(id) { //if(false)
    console.log("id가 값을 갖고 있다")
}
else {
    console.log("id가 값이 없다..")
    id = "kong";
}
console.log("id : ", id);
