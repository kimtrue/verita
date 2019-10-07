package basic;

public class Test07 {
	public static void main(String[] args) {
		String msg = "";
		int cnt = 1;
		for(int i = 1; i < 7; i++) {			
				System.out.println(); // div ul
				for (int j = 1; j <= 4; j++) {
					
					if (j == 2 && i != 6) {
						System.out.print(" ");
					} else {
						
						System.out.print(cnt++);
					}
				}
//			 </ul>
//				</div>
			
		}
	}
}
		
		
		

