package sec1220;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
    private DataSource dataFactory;
    private Connection conn;
    private PreparedStatement pstmt;
 
    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // DB 연동 위해 DB 쿼리문을 작성하여 실행하는 역할
    // 호출시 SQL 문을 이용해 회원 정보를 조회한 후 결과를 ArrayList로 반환 
    public List<MemberVO> listMembers() {
        List<MemberVO> membersList = new ArrayList();
        try {
            conn = dataFactory.getConnection();
            // SQL 문 작성 
            String query = "select * from  t_menber order by joinDate desc";
            System.out.println(query);
            pstmt = conn.prepareStatement(query);
            //System.out.println(conn);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");
                // 조회한 회원 정보를 레코드 별로 MemberVO 객체의 속성에 저장 
                MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
                membersList.add(memberVO);
                //System.out.println(name);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membersList;
    }
        public void addMember(MemberVO m) {
            try {
                conn = dataFactory.getConnection();
                String id = m.getId();
                String pwd = m.getPwd();
                String name = m.getName();
                String email = m.getEmail();
                String query = "INSERT INTO t_menber(id, pwd, name, email)" + " VALUES(?, ? ,? ,?)";
                System.out.println(query);
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, id);
                pstmt.setString(2, pwd);
                pstmt.setString(3, name);
                pstmt.setString(4, email);
                pstmt.executeUpdate();  //SQL문 실행
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
