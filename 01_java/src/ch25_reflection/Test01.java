package ch25_reflection;

public class Test01 {
	private static void exam01() throws Exception {
		//reflection 초기에는 속도가 좋지않았다.
		//reflection을 만들면 예외가 발생한다
		/**
		 * 리플렉션을 사용하려면 클래스를 얻어야한다
		 * 
		 * Class 객체 얻는 방법
		 * 1. 클래스 이름.class 
		 *   ; 클래스 정보에 접근
		 *   Class<?> clz = Dog.class;
		 * 
		 * 2. Class.forName("패키지포함 클래스명");
		 *   ; Class<?> clz2 = Class.forName("ch25_reflection")
		 *    클래스에대한 정보를 동적으로 받아온다
		 *    
		 * 3. 객체.getClass()
		 *   객체가 만들어진 상태라면 객체를 통해 클래스 정보에 접근할 수 있다   
		 */
		
		
		//1
		Class<?> clz = Dog.class;
		
		//2
		Class<?> clz2 = Class.forName("ch25_reflection.Dog");
		
		//3 강아지 객체가 있다
		Dog d = new Dog();
		Class<?> clz3 = d.getClass();
		
		System.out.println(clz == clz2); //true
		System.out.println(clz2 == clz3); //true
		
		System.out.println(clz.getSimpleName()); //Dog
		System.out.println(clz.getName()); //ch25_reflection.Dog
		
		
	}
	public static void main(String[] args) {
		try {
			
			exam01();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

}
