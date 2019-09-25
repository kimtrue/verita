/**
 *  글로벌변수(전역변수) 와 로컬변수 
 * 
 * 자바에서 로컬변수는 메서드 안에서 선언된 변수 
 * 
 * 함수안에서 선언된 변수와 함수밖에서 선언된 변수
 * 
 * - 글로벌 변수 : 함수밖에서 선언된 변수. 모든 영역에서 사용가능하다 
 * - 로컬 변수 : 함수안에서 선언된 변수. 함수 영역에서만 사용가능하다. 함수가 끝나면 같이 제거됨 
 * 
 * -스코프 체이닝 찾아볼것..
 *
 * 
 */

 let msg = "글로벌 변수 ";
 console.log("msg : " , msg);
 
 function func(){
     let msg2 = "로컬변수";
     console.log("msg2 : " , msg2);
     console.log("msg : " , msg);
     
    }
    
    func();
    console.log("msg : " , msg);
    // console.log("msg2 : " , msg2);//ReferenceError: msg2 is not defined