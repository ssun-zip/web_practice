package sec1218;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO_1 {
	
	private Connection con;
	private PreparedStatement pstmt; // 실무에선 PreparedStatement를 더 많이씀.
	private DataSource dataFactory;
	
	public MemberDAO_1()
	{
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public boolean overlappedID(String id)
	{
		boolean result = false;
		try
		{
			con  = dataFactory.getConnection();
            // 오라클의 decode 함수를 이용해 id가 존재하면 true, 존재하지 않으면 false를 문자열로 조회.
			String query = "select decode(count(*),1,'true','false') as result from t_menber";
			query += " where id=?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
            // 문자열을 boolean 자료형으로 변환.
			result = Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}