let $ = mlec;

function mlec(val){
    let elements = [];
    for(let el of document.querySelectorAll(val)){
        elements.push(el);
    }

    //innerHTML
    elements.html = function(html) {
        //this는 html 객체를 부른 애 . bDiv.. 

      //값이 없을때 추출시키기
      if(html !== undefined){
          for(let el of this){
              el.innerHTML = html;
            }
            
            return this;
        }
        return this[0].innerHTML;  

    };


    //innerText
    elements.text = function(text) {
        //값이 없을때 추출시키기
         if(text !== undefined){
             for(let el of this){
                 el.innerText = text;
               }
               return this;
           }
           //text 매개변수가 없는 경우 result 를 넘겨준다
           let result = "";
           for(let el of this){
               result += el.innerText + "\n";
           }
           return result;
       };

    elements.val = function(text) {
     //값이 없을때 추출시키기
      if(text !== undefined){
          for(let el of this){
              el.value = text;
            }
            return this;
        }
        return this[0].value;
    };


    elements.on = function (evenetType, listener) {
        for(let el of this){
            el.addEventListener(evenetType, listener);
        }
        return this;
    };

    return elements;
}