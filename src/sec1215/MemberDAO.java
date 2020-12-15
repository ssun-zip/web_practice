package sec1215;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	   public MemberDAO() {
	      try{
	    	  // //1. JNDI 서버 객체 새성
	    	 Context ctx = new InitialContext();
	    	 //2. lookup()
	    	 // import javax.naming.InitialContext; 필요, JDNI에 접근하기 위해 기본 경로(java:/comp/env) 지정
	         Context envContext = (Context) ctx.lookup("java:/comp/env");
	         // 톰캣 context.xml에 설정한 name값인 jdbc/oracle을 이용해 미리 연결한 DataSource 받아오기
	         dataFactory = (DataSource) envContext.lookup("jdbc/oracle"); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public List listMembers(MemberVO memberVO) {
		   List membersList = new ArrayList();
		   String _name = memberVO.getName();
		   try {
			   con = dataFactory.getConnection();
			   String query = "select * from t_menber";
			   if((_name != null && _name.length() != 0)) {
				   query += " where name = ?";
				// prepareStatement() 메서드에 SQL문을 전달해 PrepareStatement 객체를 생성
				   pstmt = con.prepareStatement(query);
				   pstmt.setString(1,  _name);
			   } else {
				   pstmt = con.prepareStatement(query);
			   }
			   System.out.println("preparedStatement: " + query);
			  // 미리 설정한 SQL문을 executeQuery()로 실행
			   ResultSet rSet = pstmt.executeQuery();
			   while(rSet.next()) {
				   String id = rSet.getString("id");
				   String pwd = rSet.getString("pwd");
		           String name = rSet.getString("name");
		           String email = rSet.getString("email");
		           Date joinDate = rSet.getDate("joinDate");
		           MemberVO vo = new MemberVO(); 
		           vo.setId(id);
		           vo.setPwd(pwd);
		           vo.setName(name);
		           vo.setEmail(email);
		           vo.setJoinDate(joinDate);
		           membersList.add(vo); 
				   
			   }
			   rSet.close();
			   pstmt.close();
		   } catch (Exception e){
			   e.printStackTrace();
		   }
		   return membersList;
	   }
}
