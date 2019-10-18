package kr.co.mlec.util;

public class temp {

	public static void main(String[] args) {
		
		for (int i = 177; i < 257; i++) {
			for (int j = 10; j < 31; j++) {
				System.out.println("insert into tb_schedule values(TB_SCHEDULE_SEQ.nextval, " + i + ", '2019-11-" + j + "');");				
			}
		}
	}
}
