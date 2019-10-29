package ch25_reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class Test02 {
	private static void exam01() throws Exception {
		/**
		 *  
		 * Class 객체가 갖고있는 메서드 확인
		 * 
		 * 1. 클래스.getDeclaredMethods()
		 * 	; 부모포함 모든 정보를 가져온다
		 *  
		 * 
		 */
		// dog 클래스를 꺼낸다
		Class<?> clz = Dog.class;
		System.out.println("Dog 클래스의 메서드 정보 출력");
		
		Method[] mArr = clz.getDeclaredMethods();
		for(Method m : mArr) {
			System.out.println("메서드이름: " + m.getName());
			Class<?> rClz = m.getReturnType(); //반환타입
			System.out.println("반환타입: " + rClz.getName());
			
			//파라미터에대한 정보
			Parameter[] pArr = m.getParameters();
			for (Parameter p : pArr) {
				Type t = p.getParameterizedType(); // 파라미터 타입
				System.out.println("파라미터 타입이름: " +t.getTypeName() + " 파라미터 이름: " + p.getName()); //파라미터 이름
			}
		}
		
		
	}
	private static void exam02() throws Exception {
		/**
		 *  
		 * Class 객체가 갖고있는 메서드 확인
		 * 
		 * 1. 클래스.getDeclaredMethods()
		 * 	; 부모포함 모든 정보를 가져온다
		 *  
		 * 
		 */
		// dog 클래스를 꺼낸다
		Class<?> clz = Dog.class;
		System.out.println("Dog 클래스의 메서드 정보 출력");
		
		
		
			//name : 메서드 이름, parameterTypes 
//			Method m = clz.getDeclaredMethod("setName", String.class);
			Method m = clz.getDeclaredMethod("getName");
			System.out.println("메서드이름: " + m.getName());
			Class<?> rClz = m.getReturnType(); //반환타입
			System.out.println("반환타입: " + rClz.getName());
			
			//파라미터에대한 정보
			Parameter[] pArr = m.getParameters();
			for (Parameter p : pArr) {
				Type t = p.getParameterizedType(); // 파라미터 타입
				System.out.println("파라미터 타입이름: " +t.getTypeName() + " 파라미터 이름: " + p.getName()); //파라미터 이름
		}
		
		
	}
	

	public static void main(String[] args) {
		try {
//			exam01();
			exam02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
