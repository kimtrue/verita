//$ 는 펑션
let $ = mlec;
//$를 실행하기
// $("button");

function mlec(val){
    let elements = [];

    for(let el of document.querySelectorAll(val)){
        elements.push(el);
    }

    elements.html = function(html) {
        //this는 html 객체를 부른 애 . bDiv.. 
        /*
        문자열 넘겨주기 
        bDiv.innerHTML = "2번 버튼 클릭됨";
        이 되어야한다 
      
          for(let el of elements){
              el.innerHTML = html;
           } 
       */


      //값이 없을때 추출시키기
      if(html !== undefined){
          for(let el of this){
              el.innerHTML = html;
            }
            
            return this;
        }
        return this[0].innerHTML;  
        
        /*
        if, else 는 가급적 사용하지 않는게 가독성이 좋다
         else {
          //this = $("div");
          return this[0].innerHTML;  
        }
        */

    };

    return elements;
}