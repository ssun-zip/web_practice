package sec1222.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "/Users/sunnypark/Desktop/android/board";
	ArticleVO articleVO; 
	BoardService boardService;
	public void init() throws ServletException {
		boardService = new BoardService(); // 객체 초기화 
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	       String nextPage = null;
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        String action = request.getPathInfo(); 
	        System.out.println("action : " + action);
	        try {
	        	/*
	        	 *board/listArticle.do 시 화면 글 목록 출력
	        	 	getPathInfo() 이용해 action 값을 받아오고 null or /listArticle.do
	        		경우 BoardServic의 listArticles()에서 호출에 전체 글 조회 
	        		그후 조회한 articleList 속성으로 바인딩하여 글 목록창에 포워딩 
	        	 */
	        	List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
	        	if(action == null) {
	        		articlesList = boardService.listArticles();
	        		request.setAttribute("articlesList", articlesList);
	        		nextPage ="/1222/board/listArticles.jsp";
	        	} else if (action.equals("/listArticles.do")){
	        		articlesList = boardService.listArticles();
	        		//전체 글 조회
	        		request.setAttribute("articlesList", articlesList);
	        		nextPage = "/1222/board/listArticles.jsp";
	        	}else if (action.equals("/articleForm.do")) {
	        		nextPage = "/1222/board/articleForm.jsp";
	        	} else if (action.equals("/addArticle.do")) {
	        		int articleNO = 0;
	        		Map<String, String> articleMap = upload(request, response);
	        		String title = articleMap.get("title");
	        		String content = articleMap.get("content");
	        		String imageFileName = articleMap.get("imageFileName");

	        		articleVO.setParentNO(1);
	        		articleVO.setId("hong");
	        		articleVO.setTitle(title);
	        		articleVO.setContent(content);
	        		articleVO.setImageFileName(imageFileName);
	                // 테이블에 새 글을 추가한 후 새 글에 대한 글 번호를 가져옵니다.
	                articleNO= boardService.addArticle(articleVO);
	        		
	                // 파일을 첨부한 경우에만 수행합니다.
	        		if(imageFileName != null && imageFileName.length() != 0) {
	        			File srcFile = new File(ARTICLE_IMAGE_REPO + "/" + "temp" + "/" + imageFileName);
	        			//CURR_IMAGE_REPO_PATH의 경로 하위에 글 번호로 폴더를 생성합니다.
	        			File destDir = new File(ARTICLE_IMAGE_REPO + "/" + articleNO);
	        			destDir.mkdirs();
	        			//temp 폴더의 파일을 글 번호를 이름으로 하는 폴더로 이동시킨다. 
	                    FileUtils.moveFileToDirectory(srcFile, destDir, true);
	        		}
	        		// 새글 등록 메세지를 나타낸 후 자바 스크립트 location 객체를 이용 hreft 속성을 이용해 글 목록을 요청 
	        		PrintWriter pw = response.getWriter();
	        		pw.print("<script>" + "alert('새글을 추가했습니다.');" + "location.href = '" + request.getContextPath() 
	        				+ "/board/listArticles.do';" + "</script>");
	        		return;
	        				
	        	}
	        	
	        	RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
	        	dispatch.forward(request, response);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }   
	}
	
	private Map<String, String> upload (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List itemsList = upload.parseRequest(request);
			for(int i = 0; i < itemsList.size(); i++) {
				FileItem fileItem = (FileItem)itemsList.get(i);
						if(fileItem.isFormField()) {
							System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
							articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
							
						} else {
							System.out.println("파라미터명: " + fileItem.getFieldName());
							System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
							if(fileItem.getSize() > 0) {
								int idx = fileItem.getName().lastIndexOf("\\");
								if(idx == -1 ) {
									idx = fileItem.getName().lastIndexOf("/");
								}
								String fileName = fileItem.getName().substring(idx+1);
								System.out.println(fileItem.getFieldName());
								articleMap.put(fileItem.getFieldName(), fileName);
								//익스플로어에서 업로드 파일의 경로 제거 후 map 파일명 저장 
								File uploadFile = new File(currentDirPath + "/temp/" + fileName);
								fileItem.write(uploadFile);
							} 
						}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleMap;
	}
}