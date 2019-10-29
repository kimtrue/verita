package ch25_reflection;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/ch25_reflection/test04.properties"));
			/*
			String value = prop.getProperty("/board/list.do");
			String valuenull = prop.getProperty("/board/aaaaaaa");
			System.out.println(value);
			//key가 없는 경우 null이 반환된다
			System.out.println(valuenull);
			*/
			
			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.print("호출할 URI입력(종료: quit) : ");
				String uri = sc.nextLine();
				if("quit".equals(uri)) break;
				String value = prop.getProperty(uri);
				if (value == null) {
					System.out.println("존재하지 않는 URI입니다");
					continue;
				}
				System.out.println(value);
				String[] arr = value.split(":");
				Class<?> clz = Class.forName(arr[0]);
				Object target = clz.newInstance();
				Method method = clz.getDeclaredMethod(arr[1]);
				method.invoke(target);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
