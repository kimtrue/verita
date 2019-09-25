/**
 * 
 * json : 배열 ([]) , 객체({})
 * 
 * - 이름과 값의 쌍으로 되어 있디
 * 
 * - 이름은 반드시 "" 으로 묶여야한다
 * 
 * {
 *    name: "홍길동"     <- 에러    name -> "name"으로 묶어야 한다
 * 
 * }
 * 
 * 
 * {
 *    "name": "홍길동",
 *    "age" : 183  
 * 
 * }
 * 
 * 
 * 
 * -> java         
 * class Member {
 *   String name;
 *   int age;
 * 
 * }
 * Member m = new Member();
 * m.setName("홍길동");
 * m.setAge(183);
 * 
 * 
 * 
 * ->json
 * [
 *     "aaa",
 *     "bbb"
 * 
 * ]
 * 
 * -> String[], List<String>
 * 
 * ->json
 * {
 *    "name": "졸리",
 *    "hobbys":["쇼핑", "직방", "먹기"]
 * 
 * }
 * 
 * ->java
 * class Member {
 *  String name;
 *  List<String> hobbys;
 *  }
 *  Member m = new Member(); 
 *
 * -------------------------------------------------
 * ->json
 * {
 *    "name": "졸리",
 *    "hobbys":["쇼핑", "직방", "먹기"],
 *    "addrs": {"basic": "seoul", "detail": "gangnam"}
 *    
 * }
 * 
 * ->java
 * 
 * class Address {
 *   String basic;
 *   String detail;
 * }
 * 
 * 
 * class Member {
 *  String name;
 *  List<String> hobbys;
 *  Address addrs;
 *  }
 * -------------------------------------------------
 * ->json
 * {
 *    "name": "졸리",
 *    "hobbys":["쇼핑", "직방", "먹기"],
 *    "addrs": {"basic": "seoul", "detail": "gangnam"},
 *    "items": [
 *                {"name": "시계", "price": 10000000},
 *            	  {"name": "차", "price": 500000000}
 *             ]
 *    
 * }
 * 
 * ->java
 * 
 * class Item{
 * 	String name;
 *  int price;
 * }
 * 
 * class Address {
 *   String basic;
 *   String detail;
 * }

 * class Member {
 *  String name;
 *  List<String> hobbys;
 *  Address addrs;
 *  List<Item> items;
 *  }
 * -------------------------------------------------
 * 
 */
package net05.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test01 {
	//웹브라우저를 요청해서  VO혹은 list 로 받아온 뒤 json 문자열로 변환하는 과정 연습

		
		
	public static void main(String[] args) {
//		test01();
//		test2();
//		test3();
//		test4();
		test5();
		
		
	}

	

	private static void test01() {
		Member m = new Member();
		m.setName("예지");
		m.setAge(19);
		
		String json = "{\"name\": \""+m.getName()+"\", \"age\":"+ m.getAge()+"}";
		System.out.println(json);

		/*
		 * <member>
		 *     <name>예지</name>
		 *     <age>19</age>
		 * </member>    
		 * 
		 * 
		 */
	}
	
	private static void test2() {
		Member m = new Member();
		m.setName("예지");
		m.setAge(19);
		//gson을 써서 갖고와보자
		/*
		Gson gson = new Gson();
		String json = gson.toJson(m); 
		System.out.println(json);
		*/
		System.out.println(new Gson().toJson(m));
		
	}
	
	
	private static void test3() {
		Member m = new Member();
		m.setName("예지");
		m.setAge(19);
		List<String> list = new ArrayList<>();
		list.add("영화감상");
		list.add("음악감상");
		m.setHobbys(list);
		
		System.out.println(new Gson().toJson(m));
		
	}
	private static void test4() {
		Member m = new Member();
		
		m.setName("예지");
		m.setAge(19);
		List<String> list = new ArrayList<>();
		list.add("영화감상");
		list.add("음악감상");
		m.setHobbys(list);
		
		Address addr = new Address();
        addr.setPostNo("12345");
        addr.setDetail("서울시 강남구");
        addr.setBasic("111-111");
		m.setAddr(addr);
		
		System.out.println(new Gson().toJson(m));
		
	}
	
	
	private static void test5() {
		//json을 java로 바꾸기
		String json = "{'name': '연우', 'age' : 11}";
		Member m = new Gson().fromJson(json, Member.class);
		System.out.println(m.getName() + ": " + m.getAge());
		
		
		
	}

}
