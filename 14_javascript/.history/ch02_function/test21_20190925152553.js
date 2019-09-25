/**
 * 특정한 시간 뒤에 함수 실행
 * 
 * id = setTimeout(함수, 밀리세컨드)  자동호출된다. 호출되는 시간을 설정해줘야한다. m
 *  
 * 마우스를 올렸을 때 행위를 멈추게 하기
 * id값을 지운다
 * clearTimeout(id) 
 * 
 */
+
 function func(){
  let d = new Date(); //현재의 시간
  let time = d.toLocaleTimeString(); // 시간정보 ?
  console.log(time); 

  //1초마다 찍어주고 싶다
  let id = setTimeout(func(), 1000);
  clearTimeout(id);
};
func();