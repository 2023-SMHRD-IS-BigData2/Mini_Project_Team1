package Mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MiniDAO {
	// 데이터베이스 접근
	ArrayList<MiniDTO> li = new ArrayList<>();
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.DB연동
			String user = "campus_22IS_BIG2_mini_1";// db계정 유저 이름
			String password = "smhrd1";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			//jdbc:oracle:thin:@http://project-db-campus.smhrd.com/:1521:xe
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	   public int join(MiniDTO mdto) {

		      getConn();
		      String sql = "insert into 회원정보 values(?,?,?)";

		      int row = 0;

		      try {
		         psmt = conn.prepareStatement(sql);

		         psmt.setString(1, mdto.getNickname());
		         psmt.setString(2, mdto.getPw());
		         psmt.setString(3, mdto.getId());

		         row = psmt.executeUpdate();

		      } catch (SQLException e) {

		         e.printStackTrace();
		      } finally {
		         getClose();
		      }
		      return row;
		   }
	   
		public boolean login(String id, String pw) {
			getConn();
			String sql = "select password from 회원정보 where id=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				
				rs.next();
				if(rs.getString(1).equals(pw)) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				getClose();
			}
			return false;
		}

	// 전체 순위 출력
	public ArrayList<MiniDTO> rankAll() {
		getConn();
		String sql = "select * from 점수 order by";
		try {
			psmt = conn.prepareStatement(sql);
			while (rs.next()) {
				int score = rs.getInt(1);
				String id = rs.getString(2);
				li.add(new MiniDTO(score, id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return li;

	}

	private void getClose() {

		try {
			if(rs!=null)
				rs.close();
			if(psmt!=null) {
				psmt.close();
			}
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}