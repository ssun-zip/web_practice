package sec1218;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet{
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
		response.setContentType("text/html; charset=utf-8");
		// file 을 받아오고 싶은 위치 
		String file_repo = "/Users/sunnypark/Desktop/android/hhh";
		// 받아올 파일의 이름을 string형태로 변
		String fileName = (String)request.getParameter("fileName");
		System.out.println("fileName = " + fileName);
		OutputStream out = response.getOutputStream();
		String downFile = file_repo + "/" + fileName;
		File f = new File(downFile);
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		FileInputStream in = new FileInputStream(f);
		// 배열로 버퍼를만든후 while 반복문을 이용해 파일에서 데이터를 한번에 8KB 씩 읽어옵니다. 
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			// 브라우저로 출력 
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

}
