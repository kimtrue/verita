package ch23_io.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Quiz10 {
    
    String fName;
    char comment;
    String  delm;
    HashMap<String, String> map;    

    public Quiz10(String fName) {
        
        this.fName    = fName;
        this.comment  = '#';    // 주석 구분자 # 기호.
        this.delm     = "=>";   // 서버 정보 구분자 = 기호.
        map = new HashMap<>();  // 정보를 파싱하여 key, value 쌍으로 저장하기 위한 공간
        
    }
    
    public String getValue(String name) {
        // 프로그램 구현 부분 --------------------------- 
        // 해쉬맵의 키에 해당하는 값을 리턴시키도록 구현.
    	return map.get(name);

        // ---------------------------------------------------------
    }    

    public void parse() throws IOException {
        
        // 프로그램 구현 부분 --------------------------------------
        
        // 1. 파일로부터 내용을 읽어내어  파싱 하는 부분이다.
        // 2. 읽은 첫 글자가 ‘#’ 인 경우는 주석이므로 다음라인을 읽고,
        // 3. 주석이 아닌 경우는 서버 정보이므로.. 서버정보 구분자인 delm (“=>”)을
        //    이용하여 key, value 를 추출하여 해쉬 맵에 저장하는 기능을 완성하라. 
        //---------------------------------------------------------
    	FileReader fr = new FileReader("data/myserver.txt");
    	BufferedReader br = new BufferedReader(fr);
    	while(true) {
    		String st = br.readLine();
    		if(st == null) break;
    		if(st.contains(String.valueOf(this.comment))) continue;
    		String[] arr = st.split(this.delm);
    		map.put(arr[0], arr[1]);
    		

    		
    	}
    	
    	
    	
    	
    	
    }
    
    public static void main(String args[]) { // 변경 하지 마세요.
        
        Quiz10 cr =
            new Quiz10("data/myserver.txt");
        
        try {
            cr.parse();
            System.out.println(cr.getValue("port"));
            System.out.println(cr.getValue("server"));
            System.out.println(cr.getValue("admin"));
        } catch (Exception e) { }
        
    }    
}
