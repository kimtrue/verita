package ch25_reflection;

import java.lang.reflect.Method;

public class Test03 {
	private static void exam01() throws Exception {
		/**
		 * 객체 생성하기
		 * 
		 */
		Class<?> clz = Dog.class;
		//Dog d = new Dog();   == clz.newInstance();
		/*
		 */
		Object obj = clz.newInstance();
		Dog d = (Dog)obj;
		d.setName("똘복");
		System.out.println(d.getName());
//		Object obj = clz.getDeclaredConstructor().newInstance();
		
	}
	private static void exam02() throws Exception {
		/**
		 * reflection을 통한 메서드 실행
		 * 
		 * Dog d = new Dog();
		 * d.setName("똘복");
		 * String name = d.getName();
		 * System.out.println(name);
		 */
		Class<?> clz = Dog.class;
		Object target = clz.newInstance();
		Method method = clz.getDeclaredMethod("setName", String.class);
		method.invoke(target, "똘복"); // = d.setName("똘복");
		
		method = clz.getDeclaredMethod("getName");
		String name = (String)method.invoke(target);
		System.out.println(name);

		
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
