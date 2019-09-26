/**
 * 여러개의 객체 관리 
 *
 * 정재현 24 남 강남
 * 이마크 21 남 캐나다
 * 서존전 26 남 미국
 * 김동영 25 남 구리 
 * 
 */

 /*
 let m1 = {name: '정재현', age: 24, gender: '남', addr:'강남'};
 let m2 = {name: '이마크', age: 21, gender: '남', addr:'캐나다'};
 let m3 = {name: '서존전', age: 26, gender: '남', addr:'미국'};
 let m4 = {name: '김동영', age: 25, gender: '남', addr:'구리'};
*/
 // => key값은 동일하다

function setInfo(name, age, gender, addr){
    return {name: name, age: age, gender: gender, addr: addr};
}
let m1 = setInfo('정재현',24,'남','강남');
let m2 = setInfo('이마크',21,'남','캐나다');
let m3 = setInfo('서존전',26,'남','미국');
let m4 = setInfo('김동영',25,'남','구리');