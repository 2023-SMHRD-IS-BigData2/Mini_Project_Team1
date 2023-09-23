package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.DTO;

public class DAO {
	ArrayList<DTO> li = new ArrayList<>();
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	// Controller con = new Controller();

	private void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.DB연동
			String user = "campus_22IS_BIG2_mini_1";// db계정 유저 이름
			String password = "smhrd1";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			// jdbc:oracle:thin:@http://project-db-campus.smhrd.com/:1521:xe
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

	
	public int sum(ArrayList<String> li) {

		getConn();

		String sql = "select 점수 from SSAM_SCORE where 재료=?";
		int sum = 0;

		try {
			psmt = conn.prepareStatement(sql);

			for (int i = 0; i < li.size(); i++) {

				psmt.setString(1, li.get(i));
				rs = psmt.executeQuery();
				rs.next();
				sum += rs.getInt(1);
			}

		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			getClose();
		}
		return sum;

	}

	public int join(DTO dto) {

		getConn();
		String sql = "insert into 회원정보 values(?,?,?,0)";

		int row = 0;

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getNickname());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getId());

			row = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	public int getUser(String id) {
		int score = 0;
		getConn();
		String sql = "select 점수 from 회원정보 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			rs.next();
			score = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return score;

	}
	
	public void setUser(int n, String id) {
		getConn();
		String sql = "update 회원정보 set 점수 = ? where id = ?";
		int score = getUser(id);
		
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setLong(1, n);
				psmt.setString(2, id);
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
		}
		
		
		
	

	public boolean login(String id, String pw) {
		getConn();
		String sql = "select password from 회원정보 where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			rs.next();
			if (rs.getString(1).equals(pw)) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return false;
	}

	public int rankSingle(String id) {

		getConn();
		int rank=0;
		String sql = "select * from(SELECT id, 점수, rank() over(order by 점수 desc) as 랭킹 from 회원정보) WHERE id = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			rs.next();
			rank = rs.getInt(3);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return rank;

	}

	public String getNick(String id) {
		getConn();
		String sql = "select nickname from 회원정보 where id = ?";
		String nick="";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			rs.next();
			nick = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return nick;
	}
	
	public ArrayList<DTO> rankAll() {
		getConn();
		ArrayList<DTO> al = new ArrayList<>();
		String sql = "select * from 회원정보 order by 점수 desc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				al.add(new DTO(rs.getInt(4), rs.getString(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return al;

	}

	private void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null) 
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
