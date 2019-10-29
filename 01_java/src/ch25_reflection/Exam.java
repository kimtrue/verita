package ch25_reflection;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Exam {
	public static void main(String[] args) {
		// exam.properties의 내용을 읽어서 Board클래스에 설정
		// 설정 후,
		/*
		 * 번호 :11 
		 * 글쓴이 : 호빵맨 
		 * 제목 : .. 
		 * 내용: ... 
		 * 조회수: ....
		 * 
		 * Board에서 set 메서드를 다 꺼낸다
		 * 
		 */

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/ch25_reflection/exam.properties"));

			// Exam 클래스 얻어오기
			Class<?> clz = Board.class;
			Object target = clz.newInstance(); // Board b = new Board()
			Method[] mArr = clz.getDeclaredMethods();
			for(Method m : mArr) {
				String mName = m.getName();
				if(!mName.startsWith("set")) continue;
				
				mName = mName.substring("set".length());
				//No
				mName = Character.toLowerCase(mName.charAt(0)) + mName.substring(1); // 첫글자 소문자로 바꾸기
				
				
				String pValue = prop.getProperty(mName);
				if(pValue == null) continue;
				
				switch (m.getParameterTypes()[0].getName()) {
				case "int":
					m.invoke(target, Integer.parseInt(pValue));
					break;

				default:
					m.invoke(target, pValue);
				}
				
			}
			
			Board board = (Board)target;
			System.out.println("번호 : " + board.getNo());
			System.out.println("글쓴이 : " + board.getWriter());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getContent());
			
//			 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
