/*
 *목표 : 
 *
 * -이클립스 UI 구성을 이해하고 실행하는 방법을 이해
 * -자바를 실행하기 위해서는 클래스와 메인 메서드가 필요함
 * -메인 메서드는 자바 실행 시 최초에 불려지는 메서드임을 이해
 * 
 * 참고
 * [] : 대괄호
 * {} : 중괄호
 * () : 소괄호
 * ;  : 세미콜론
 * :  : 콜론
 * "  : 더블쿼티션, 쌍따옴표
 * '  : 싱글쿼티션, 홑따옴표
 * 
 * class와 메서드는 중괄호로 묶여 있어야한다 {}
 * 
 * -작성된 클래스를 실행하는 방법
 * 1.마우스 오른쪽 Run-> 
 * 2.f11 번 
 * 3.ctrl+f11(만약, f11이 실행되지 않는 경우)
 * 4.상단 메뉴에서 초록 재생버튼 아이콘 클릭
 * 
 * 
 * 
 * 패키지를 만드는 이유??
 * - 소스 구분하기 위해서
 * - 다른 사람이 만든 것과 중복되지 않도록 how 도메인 명을 둔다..  
 * ex) naver에서 만든 것
 * com.naver.projectname.modulename.  ....
 */


//패키지로 선언하면 이름에 해당하는 디렉토리가 생성됩니다.
package ch01_basic;

//위에 선언된 패키지 이름 하위에 Test01.java 가 생성된다.

public class Test01 {
	
	 //메인메소드 : 프로그램 실행할 때 가장 먼저 호출되는 메서드이다.
	public static void main(String [] args) {
		//화면에 내용을 출력하는 명령어
		//실행 명령어의 끝에는 세미콜론을 적는다.
		System.out.println("우리는 자바를 배우고 있습니다");
		
		
		
	}
	
	

}
