/**
 * 예외
 */

function isMan(juminNo) {
    console.log(juminNo, juminNo.length);
    if(juminNo.length != 13){
        //에러발생시키기
        throw new Error("주민번호는 13자리입니다.")
    }

}
try {
    //이 메서드를 불러 매개변수자리에 주겠다
    isMan('123456');
    //try문에서 에러가나면 중단되지 않고 끝까지 하기 위해

} catch (e) {
    console.log("에러발생");
    console.log(e);

} finally {
    console.log("항상 수행하는 블럭");
}
console.log("정상종료됨..");