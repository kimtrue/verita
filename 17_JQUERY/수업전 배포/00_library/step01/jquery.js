//$ 는 펑션
let $ = mlec;
//$를 실행하기
// $("button");



function mlec(val){
    let elements = [];
    
    //셀렉터가 몇 개 있을지 모르니 일단 All 로 선언
    // let arr = document.querySelectorAll(val);


    /*
     for 문
     arr = {a:1, b:2, c:3}
    - for(let i=0; i < arr.length; i++){}
    - for(let el in arr ) {} key 값반환 a, b, c
    - for(let el of arr ) {} value 값반환 1, 2, 3
    - arr.forEach(() => {}) 
    */
    //객체의 value값 반환
    for(let el of document.querySelectorAll(val)){
        elements.push(el);
    }

    //mlec 함수를 부르면 elements를 넘겨주도록한다
    return elements;
}