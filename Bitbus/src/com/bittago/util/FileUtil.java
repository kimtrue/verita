package com.bittago.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileUtil {

	/**	Char
	 */
	public static String readFile(String name) throws IOException {
		
		FileReader fr = new FileReader(name);
		
		BufferedReader br = new BufferedReader(fr);
		
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			String line = br.readLine();
			if (line == null) break;
			
			sb.append(line);
		}
		br.close();
		fr.close();
		
		return sb.toString();
	}
	
	/** 바이트 단위
	 */
	
	public static byte[] readByteFile(String name) throws Exception {
		
		FileInputStream fis = new FileInputStream(name);
		
		byte[] buffer = new byte[fis.available()];
		
		fis.read(buffer);
		fis.close();
		
		return buffer;
	}
	
	public final static String BOARD_ABS_PATH = "C:/Development/ProjectUpload/webex";
	
	public final static int MAX_SIZE = 1024 * 1024 * 100;
	
	/**	경로를 확인 한 후 경로에 해당하는 디렉토리가 확인 후 없는 경우  디렉토리를 생성한다.	
	 * 
	 * 	@param name
	 * 	@return directory
	 */
	public static File directory (String boardName) {
		
		File directory = new File(BOARD_ABS_PATH + boardName + new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date()));
		
		if(directory.exists() == false) 
		{
			directory.mkdirs();
		}
		
		return directory; 
		
	}
	
	
	
}
