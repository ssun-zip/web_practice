package sec1222.board;

import java.util.List;


public class BoardService {
	BoardDAO boardDAO;
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public int addArticle(ArticleVO article) {
		System.out.println("here");
		return boardDAO.insertNewArticle(article);
	}

}
// BoardDAO 클래스의 메서드 이름은 보통 각 메서드들이 실행하는 SQL 문에 의해 결정
// 예를 들면 selectAllArticles() method 는 전체 글 정보를 조회하는 SQL 문을 살행하므로
// 이름에 selecAll 이 들어갑니다 