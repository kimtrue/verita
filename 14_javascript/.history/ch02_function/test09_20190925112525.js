/**
 * 함수내에서의 호이스팅
 *
 */

 function func(){
     var i = 100;
     if(i % 2 == 0) {
         var msg = "짝수";
     }
     console.log("k : ", k);
     for(var k = 0; k < 5 ; k++){
         console.log(`${i} : ${k} : ${msg}`);
     }
     console.log("k : ", k);

 }

 func(); 
 
/**
 * var i;
 * var msg; 
 * var k
 * 
 * i = 100;
 * 100은 짝수 
 * msg = 짝수
 * 값을 안줬으니까 k = undfined 
 * 
 * 
 * 
 */