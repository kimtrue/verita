/**
 * 배열
 * 생성하는 방법 :
 *  - []
 *  - Array()
 */


 let arr1 = []; //크기가 0인 배열
 let arr2 = new Array(); //크기가 0인 배열

 console.log("arr1.length : ", arr1.length);
 console.log("arr2.length : ", arr2.length);
 //index가 0번째 찍기
 console.log(arr1[0], arr2[0]); //undefined
 
 //자바스크립트의 배열의 크기는 마지막 인덱스 번호(가장 큰 번호) + 1 이다.
 //동적으로 값 넣어주기
 arr1[0] = 10;
 arr1[1] = 20;
 arr1[3] = 30;
 console.log("arr1.length : ", arr1.length); //4
 
 arr1["id"] = "홍"; //자바스크립트는 오류가 안나온다
 console.log("arr1.length : ", arr1.length); //4
 //숫자가 아니여서 길이에 포함되지 않는다
 //가능하지만 권장하지 않음
 //인덱스값으로 꺼내지지 않지만 값은 저장되어있다
 
 arr["99"] = 100;
 console.log("arr1.length : ", arr1.length); //100 "99"를 숫자로 바꾸고 처리한다

 //서로다른 데이터 타입도 입력이 가능하다
 arr1[4] = "문자열";
 arr1[5] = true;
 arr1[6] = [1, 2, 3];
 arr1[7]

