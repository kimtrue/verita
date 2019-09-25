/**
 * 예외
 */

function isMan(juminNo) {
    console.log(juminNo, juminNo.length);
    if(juminNo.length != 13){
        //에러발생시키기
        throw new Error("")
    }

}

//이 메서드를 불러 매개변수자리에 주겠다
isMan('123456');