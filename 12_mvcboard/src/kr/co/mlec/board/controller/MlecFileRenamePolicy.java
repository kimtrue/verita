package kr.co.mlec.board.controller;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy{

	@Override //파일의 이름을 정해서  return으로 넘겨라
	//multipartRequest가 부른다
	public File rename(File f) {
		//파일의 이름 얻기
		String name = f.getName();
		//이름이 ..으로 줄 수 도있으니까 마지막.은 확장자 앞의 .일 것이다. 이것을 찾기위해 lastIndexOf
		int index = name.lastIndexOf(".");
		//변경시켜줄 이름을 초기화
		String extName = "";
		//index == -1 이면 .이 없다는 의미.
		//if 확장자 명이 있다면
		if(index != -1) extName = name.substring(index);		
		//c:/java/upload/board/2019/09/18/11/은 같고 a.txt 만 바꾸고싶다
//		return new File("저장 경로", "바꿔줄 것");
		return new File(f.getParent(), UUID.randomUUID().toString() + extName);
	
	}

}
