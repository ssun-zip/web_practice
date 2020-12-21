package sec1220;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


//@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// Ajax 로 전달된 json 문자열을 getParameter 이용해 가져옴. 
		String jsonInfo = request.getParameter("jsonInfo");
		try {
			// JSOn 데이터처리하기 위해 Jsonparser 객체를 생성 
			JSONParser jsonParser = new JSONParser();
			//JsonParser 클래스의 parse() 메서드를 이용해 JsonObject 가져오고 json 데이터의 
			// name 속성으로 get() 에 전달하여 value 출력 
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
			System.out.println("회원정보");
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("age"));
			System.out.println(jsonObject.get("gender"));
			System.out.println(jsonObject.get("nickname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

