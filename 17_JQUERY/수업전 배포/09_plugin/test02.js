/*
input 창의 숫자에 3자리마다 , 찍어주기
jquery가 선택한 객체에 추가하기: $.fn.이름
*/
$.fn.comma = function () {
    // console.dir(this);
    //3자리를 입력할때마다 이벤트 걸어주기
    this.keyup(function () {
        //이벤트 함수 내에서는 this 는 걸어준 애
        // console.log(this.value);
        //g 전체
        this.value = this.value.replace(/,/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    });
};

