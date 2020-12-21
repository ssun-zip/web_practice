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
 * Servlet implementation class JsonServlet2
 * 회원 정보를 json 배열에 저장하여 jsp 페이지로 전송하고 json 배열에 대한 정보를 저장하는 과정 
 */
 //@WebServlet("/json2") 
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totalObject = new JSONObject();
		// memberArray 객체를 생성하여 회원 정보를 저장하느 JSON 객체를 차례대로 저장 
		JSONArray membersArray = new JSONArray();
		// 회원 정보 한명의 정보가 들어갈 JSON객체 생성 
		JSONObject memberInfo = new JSONObject();

		//회원 정보를 쌍으로 저장 
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날쎈도리");
        // 회원정보를 membersArray 에 저장 
		membersArray.add(memberInfo);
		// 다른 회원 정보를 name/ valye 로 memberInfo에 저장 
		memberInfo = new JSONObject();
		memberInfo.put("name", "박선아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "썬써서니");
		membersArray.add(memberInfo);

		// totalObject name에는 자바스크립트 접근 사용 이름 , value- membersArray 저장 
		totalObject.put("members", membersArray);
		//JSON 문자열로 변환 
		String jsonInfo = totalObject.toJSONString();
		System.out.print(jsonInfo);
		//JSOn 데이터를 브라우저로 전송 
		writer.print(jsonInfo);
	}

}
