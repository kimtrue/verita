package kr.co.mlec.repository.vo;

/**
 * insert into tb_member ( id, pass, name) VALUES ('kim', '1111', '김수한무');
 */

public class Member {
	private String id;
	private String pass;
	private String name;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
