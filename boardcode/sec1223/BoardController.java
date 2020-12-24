package sec1223;

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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


/* 12/24 TASK : 
 * 답글 도 새글이므로 답글 기능도 새글쓰기 기능과 비슷합니다.
 * 다른 점은 답글창 요청 /replyForm.do 시 미리 부모글 번호를 parentNO
 * 속성으로 세션에 저장해놓고, 답글을 작성한 후
 * 등로을 요청 /addreply.do 하면 세션에서 parentNO를 가져와 테이블에 추가한다는 점입니다.  
 */

@WebServlet("/board/*")
public class BoardController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "/Users/sunnypark/Desktop/android/board";
	ArticleVO articleVO; 
	BoardService boardService;
	public void init() throws ServletException {
		boardService = new BoardService(); // 객체 초기화 
		articleVO = new ArticleVO();
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
	       String nextPage = "";
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        // replyForm.do & addReply.do 
	        HttpSession session; // 답글에 대한 부모글 번호를 지정하기 위해 세션을 사용합니다. 
	        String action = request.getPathInfo(); 
	        System.out.println("action : " + action);
	        try {
	        	List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
	        	if(action == null) {
	        		articlesList = boardService.listArticles();
	        		request.setAttribute("articlesList", articlesList);
	        		nextPage ="/1223/listArticles.jsp";
	        	} else if (action.equals("/listArticles.do")){
	        		articlesList = boardService.listArticles();
	        		request.setAttribute("articlesList", articlesList);
	        		nextPage = "/1223/listArticles.jsp";
	        	}else if (action.equals("/articleForm.do")) {
	        		nextPage = "/1223/articleForm.jsp";
	        	} else if (action.equals("/addArticle.do")) {
	        		int articleNO = 0;
	        		Map<String, String> articleMap = upload(request, response);
	        		String title = articleMap.get("title");
	        		String content = articleMap.get("content");
	        		String imageFileName = articleMap.get("imageFileName");

	        		articleVO.setParentNO(0);
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
	                    srcFile.delete();
	        		}
	        		// 새글 등록 메세지를 나타낸 후 자바 스크립트 location 객체를 이용 hreft 속성을 이용해 글 목록을 요청 
	        		PrintWriter pw = response.getWriter();
	        		pw.print("<script>" + "alert('새글을 추가했습니다.');" + "location.href = '" + request.getContextPath() 
	        				+ "/board/listArticles.do';" + "</script>");
	        		//nextPage = "/board/listArticles.do";
	        		return;
	        				
	        	} else if (action.equals("/viewArticle.do")) {
	        		// 글 상세창을 요구할 경우 articleNO 를 받아온다 
	        		String articleNO = request.getParameter("articleNO");
	        		// articleNO 에 대한 글 정보 조회하고 article 속성으로바인딩 
	        		articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
	        		request.setAttribute("article", articleVO);
	        		nextPage = "/1223/viewArticle.jsp";
	        	} else if (action.equals("/modArticle.do")) {
	        		Map<String, String> articleMap = upload(request, response);
					int articleNO = Integer.parseInt(articleMap.get("articleNO"));
					articleVO.setArticleNO(articleNO);
					String title = articleMap.get("title");
					String content = articleMap.get("content");
					String imageFileName = articleMap.get("imageFileName");
					articleVO.setParentNO(0);
					articleVO.setId("hong");
					articleVO.setTitle(title);
					articleVO.setContent(content);
					articleVO.setImageFileName(imageFileName);
					boardService.modArticle(articleVO);
					if (imageFileName != null && imageFileName.length() != 0) {
						String originalFileName = articleMap.get("originalFileName");
						File srcFile = new File(ARTICLE_IMAGE_REPO + "/" + "temp" + "/" + imageFileName);
	        			//CURR_IMAGE_REPO_PATH의 경로 하위에 글 번호로 폴더를 생성합니다.
	        			File destDir = new File(ARTICLE_IMAGE_REPO + "/" + articleNO);
						destDir.mkdirs();
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
						File oldFile = new File(ARTICLE_IMAGE_REPO + "/" + articleNO + "/" + originalFileName);
						oldFile.delete();
					} 
					PrintWriter pw = response.getWriter();
					pw.print("<script>" + "  alert('글을 수정했습니다.');" + " location.href='" + request.getContextPath()
							+ "/board/viewArticle.do?articleNO=" + articleNO + "';" + "</script>");
					return;
	        	} else if (action.equals("/removeArticle.do")) {
					int articleNO = Integer.parseInt(request.getParameter("articleNO"));
					List<Integer> articleNOList = boardService.removeArticle(articleNO);
					for (int _articleNO : articleNOList) {
						File imgDir = new File(ARTICLE_IMAGE_REPO + "/" + _articleNO);
						if (imgDir.exists()) {
							FileUtils.deleteDirectory(imgDir);
						}
					}

					PrintWriter pw = response.getWriter();
					pw.print("<script>" + "  alert('글을 삭제했습니다.');" + " location.href='" + request.getContextPath()
							+ "/board/listArticles.do';" + "</script>");
					return;
				} else if (action.equals("/replyForm.do")) {
					int parentNO = Integer.parseInt(request.getParameter("parentNO"));
					session = request.getSession();
					session.setAttribute("parentNO", parentNO);
					nextPage = "/1223/replyForm.jsp";
				
				} else if (action.equals("/addReply.do")){
					session = request.getSession();
					int parentNO = (Integer)session.getAttribute("parentNO");
					session.removeAttribute("parentNO");
					Map<String, String> articleMap = upload(request, response);
					String title = articleMap.get("title");
					String content = articleMap.get("content");
					String imageFileName = articleMap.get("imageFileName");
					articleVO.setParentNO(parentNO);
					articleVO.setId("hong");
					articleVO.setTitle(title);
					articleVO.setContent(content);
					articleVO.setImageFileName(imageFileName); 
					int articleNO = boardService.addReply(articleVO);
					if (imageFileName != null && imageFileName.length() != 0) {
						File srcFile = new File(ARTICLE_IMAGE_REPO + "/" + "temp" + "/" + imageFileName);
	        			File destDir = new File(ARTICLE_IMAGE_REPO + "/" + articleNO);
						destDir.mkdirs();
						FileUtils.moveFileToDirectory(srcFile, destDir, true);
					} 
					PrintWriter pw = response.getWriter();
					pw.print("<script>" + "  alert('답글을 추했습니다.');" + " location.href='" + request.getContextPath()
							+ "/board/viewArticle.do?articleNO=" + articleNO + "';" + "</script>");
					return;
				
				}else if (action.equals("/*")){
					nextPage = "/board/listArticles.do";
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
			List items = upload.parseRequest(request);
			for(int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem)items.get(i);
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