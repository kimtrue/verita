//button 을 눌렀을 때 처리해야 할 일들
function doAction(){
    // alert("클릭"); 확인해주는 작업
    //button을 눌렀을때 span 부분의 text 부분을 바꾸기

    //.s1엘리먼트에 접근하기
    let spanEle = document.querySelector("#s1");
    //안의 내용만 확인하고 싶을 때 
    // console.dir(spanEle.innerText);
    
    //안의 내용을 바꾸고 싶다면
    spanEle.innerText = "고향의 맛";
    

} 