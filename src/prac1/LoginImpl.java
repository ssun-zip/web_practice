package prac1;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//세션 바인딩 이벤트를 처리하는 이벤트 핸들러가 구현.
//세션 바인딩 시 valueBound()가호출되어 static인 total_user값 증가 
//세션 소멸시 접속자수를 감소 
public class LoginImpl implements HttpSessionListener{
   String user_id;
   String user_pw;
   static int total_user = 0;
   
   public LoginImpl() {
      
   }
   
   public LoginImpl(String user_id, String user_pw) {
      this.user_id = user_id;
      this.user_pw = user_pw;
   }


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	    System.out.println("사용자 접속");
	    ++total_user;	
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		   System.out.println("사용자 접속 해제 ");
		    --total_user;	
		}
	
}
   
