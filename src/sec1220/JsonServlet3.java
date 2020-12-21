package sec1220;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet3
 * bookInfo 의 JSONObject 생성 후, 도서 정보를 name-value 쌍으로 저장
 * 회원 배열을 저장하고 있는 totalObject 의 name 에 배열 이름에 해당하는 book, value- bookArray를 최종 저장 
 */
//@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		// 배열을 최종적으로 저장할 JSONObject 객체 생성 
		JSONObject totaObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		//한 회원에 대한 정보 입력 
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날쌘돌이");
        // 한 회원 정보가 담긴 Array 를 membersArry 에 저장 
		membersArray.add(memberInfo);

		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo);
		// 회원 정보를 저장한 배열을 자바스크립트에 members에 value membersArray 에 보낸다 
		totaObject.put("members", membersArray);

		// 책들에 대한 정보가 담긴 array 
		JSONArray bookArray = new JSONArray();
		// book 을 위한 bookArray 생성  - 한책에 대한 정보 
		JSONObject bookInfo = new JSONObject();
		bookInfo.put("title", "Html");
		bookInfo.put("writer", "아무개");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "image/image1.png");
		// 한책에 대한 정보를 bookArray에 넣기 
		bookArray.add(bookInfo);

		bookInfo = new JSONObject();
		bookInfo.put("title", "파이썬");
		bookInfo.put("writer", "박샘이");
		bookInfo.put("price", "12000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "image/image2.jpg");
		bookArray.add(bookInfo);
		//도서 정보를 저장한 배열을 name: books - value : bookArray
		totaObject.put("books", bookArray);

		String jsonInfo = totaObject.toJSONString();
		System.out.print(jsonInfo);
		writer.print(jsonInfo);
	}

}

