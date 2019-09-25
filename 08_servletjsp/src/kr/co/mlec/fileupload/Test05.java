package kr.co.mlec.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 */

@WebServlet("/fileupload/test05.do")
public class Test05 extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String path = "/board" + sdf.format(new Date());
		File f = new File("c:/java/upload" + path);
		if(f.exists() == false) f.mkdirs();
		/**apache commons를 사용한 여러 개의 파일을 받아 저장하기*/
		//메모리와 임시저장에 대한 옵션을 설정
		DiskFileItemFactory disk = new DiskFileItemFactory();
		//내가 확정하기 전 까지 메모리에 올라가만 있다 저장은 안된다.
		//저장되는 시점을 관리할 수 있다
		disk.setRepository(new File("c:/java/temp"));
		//file 의 메모리 정보 지정  1024 * 1024 1mb
		disk.setSizeThreshold(1024);
		
		//request  의 정보를 파싱 처리하는 클래스 (cos.jar에서 MulripartRequest의 역할)
		ServletFileUpload upload = new ServletFileUpload(disk);
		try {
			//이름을 주지 않으면 자기가 temp에 이름을 랜덤으로 임시저장시켜놓는다
			//파라미터의 정보를 같이 들어온다. 
			List<FileItem> list =  upload.parseRequest(req);
			for(FileItem item : list) {
				//input태그의 name="aaa" aaa의 이름을 반환
				System.out.println(item.getFieldName());
				//input속성에 입력한 값을 반환. field에 저장된 값을 준다. 파일일때는 내용이 값이다
				System.out.println(item.getString());
				//type이 file인지 아니면 일반 폼인지 확인하는 작업  true = form data
				if(item.isFormField()) { //파일의 타입이 파일이 아닌경우
					
				} else { //타입이 파일인 경우
					//데이터 베이스를 저장하기위한 원본파일명, 파일의 크기를 가져오는 작업을 할 것이다.
					String name = item.getName();
					
					System.out.println("파일명: " + name);
					
					//파일의 크기가 커서 long으로 받는다 
					long size = item.getSize();
					System.out.println("파일크기:" + size);
					
					//문서 타입
					String contentType = item.getContentType();
					System.out.println("파일타입: " + contentType);
					
					//실제 저장하는 파일의 이름 (직접- UUID 활용)
					String ext = "";
					int index = name.lastIndexOf(".");
					if(index != -1) ext = name.substring(index);
					File file = new File(f, UUID.randomUUID().toString() + ext);
					item.write(file); 
					if(contentType.startsWith("image/")) {
					/*썸네일 생성하기*/		
		                    	Thumbnails.of(file).
                                      size(300, 200).
                                      outputFormat("png").
                                      toFile(new File(file.getParent(), "thumb_"+file.getName()));
					}
					
				}
				
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	/*	
		//request로 부터 파일을 뽑아내서 저장
			while(fNames.hasMoreElements()) {
			String fName = fNames.nextElement();
			System.out.println("fName : " + fName);
			//파일을 여러 개 올릴 때 attach 라는 이름으로 얻어 올 수 있는 파일의 이름이 하나밖에 없어서 db에 저장이 하나밖에 안된다.
			// commons 를 사용하면 파일에 대한 정보를 반복돌면서 가져올 수 있다..
			System.out.println("오리지널 이름 : " + request.getOriginalFileName(fName));
			System.out.println("서버에 저장되는 이름 : " + request.getFilesystemName(fName));
		*/	
			
//		}
	
		
		
		
	}
	
	
	
	

}
