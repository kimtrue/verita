

function calClosure(num1, num2){
        return function(comm){
            switch(comm){
                case "+" : return num1 + num2;
                case "-" : return num1 - num2;
                case "*" : return num1 * num2;
                case "/" : return num1 / num2;
            }
        } 
}

let cal = calClosure(10, 2);
console.log(cal("+")); //12
console.log(cal("-")); //8
console.log(cal("*")); //20
console.log(cal("/")); //6

//hint 매개변수 2개 선언. calclosure는 return을 해줘야 하고
// 리턴한 애가 function을  