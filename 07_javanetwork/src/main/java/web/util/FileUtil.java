package web.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class FileUtil {
	//바이트단위 처리(ex 이미지)
	public static byte[] readByteFile(String name) throws Exception {
		FileInputStream fis = new FileInputStream(name);
		byte[] buffer = new byte[fis.available()];
		//fis 읽은걸 buffer에 넣어라 전부 읽은 것
		fis.read(buffer);
		fis.close();
		return buffer;
		
	}
	
	
	
	
	//문자단위 처리
	public static String readFile(String name) throws Exception {
       //name에 해당하는 파일을 읽어서
		FileReader fr = new FileReader(name);
		BufferedReader br = new BufferedReader(fr);

		// string을 모아서 한번에 뿌리기 위해
		StringBuffer sb = new StringBuffer();
		while (true) {
			String line = br.readLine();
			if (line == null) break;
			sb.append(line);

		}
		br.close();
		fr.close();

		return sb.toString();
		

	}

}
