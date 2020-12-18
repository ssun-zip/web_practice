package sec1218;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/upload.do")
public class FileUpload extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		//파일을 정리할 저장경로 
		File currenDirPath = new File ("/Users/sunnypark/Desktop/android/hhh");
		// 저장 위치와 업로드 가능한 최대파일 설정 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		/*
		 * DiskFileItemFactory 클래스가 제공하는 메소드
		 * setRepository() 파일을 저장할 디렉터리 설정
		 * setSizeThreadhold() 최대 업로드 가능한 파일 크기를 설정 
		 */
		// 파일 업로드팡에서 업로드된 파일과 매개변수에대한 정보를 가져와 파일에 업로드 하고 매개변수 값 출력 
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			//request객체에서 매개변수를 List로 가져옵니다. 
			List items = upload.parseRequest(request);
			for(int i = 0; i < items.size(); i++) {
				// 파일 업로드창에서 업로드된 항목을 하나씩 가져옵니다. 
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				} else {
					System.out.println("파라미터명: " + fileItem.getFieldName());
					System.out.println("파일명: " + fileItem.getName());
					System.out.println("파일크기: " + fileItem.getSize() + "bytes");
					// 업로드할 파일 이름을 가져옵니다. 
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx +1);
						// 업드할 파일이름으로 저장소 파일을 업로드 합니다. 
						File uploadFile = new File(currenDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}
				} // 파일 업로드 기능 수행 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
/*
ServletFileUpload 클래스가 제공하는 메서드
parseRequest() 전송된 매개변수를 List 객체로 얻습니다.
getItemIterator() 전송된 매개변수를 Iterator 타입으로 얻습니다.
 */
