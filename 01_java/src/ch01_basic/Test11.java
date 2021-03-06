/**
 * 목표
 * 
 * 자바프로그램 구성요소 이해하기
 * : 클래스, 메서드, 멤버변수
 *  메서드는 클래스 밖으로 나갈 수 없다. 무조건 클래스 안쪽에 있어야한다
 * 자바 프로그램은 클래스로 시작한다. 클래스 밖에서 메서드나 변수에 대한 선언은 불가능
 *
 *     메서드(X)
 *      변수(X)
 * class 이름{
 * 
 *   메서드(O)
 *      변수(O)
 * }
 * 
 * 메서드와 변수의 구분
 *  메서드 () 소괄호가 나오면. {} 자체 블럭을 갖는다
 *  변수 : 값이 변경이 될 수 있다
 *  상수 : 값이 항상 고정되어있다. 값이 변경될 수 없다. (final)
 *  
 *  공통점 : 이름이 있다.
 *  
 *  
 *  네이밍 룰(식별자)
 *  캐멀 표기법(Camel Case)
 *  클래스 : 첫 글자를 대문자로, 단어가 여러 개가 나오면 각 단어의 첫 글자를 대문자로
 *      ex)HelloWorld
 *  메서드 : 클래스와 동일한데 단, 첫 글자를 소문자로 시작한다
 *      ex)speedUp() 
 *  변수 :  메서드와 동일
 *      ex)evalScore     
 *  상수 : 다 대문자로 작성.가독성이 떨어진다
 *      ex)MAX_VALUE 단어와 단어 사이에 "_" 언더바를 줘서 읽기 편하게한다 
 * 
 */
package ch01_basic;

public class Test11 {
	public static void main(String [] args) {
//		int i = 100;
//		final double PI = 3.14;
	}

}
