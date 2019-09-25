package net05.json;

import java.util.List;

public class Member {
	private List<String> hobbys;
	String name;
	int age;
	private Address addr;
   
	protected Address getAddr() {
		return addr;
	}
	protected void setAddr(Address addr) {
		this.addr = addr;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getAge() {
		return age;
	}
	protected void setAge(int age) {
		this.age = age;
	}
	protected List<String> getHobbys() {
		return hobbys;
	}
	protected void setHobbys(List<String> hobbys) {
		this.hobbys = hobbys;
	}
	

}
