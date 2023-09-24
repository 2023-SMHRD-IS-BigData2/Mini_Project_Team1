package Controll;

import java.sql.*;
import java.util.ArrayList;

import Model.DTO;


public class DAO {
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
			// jdbc:oracle:thin:@http://project-db-campus.smhrd.com/:1521:xe
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int join(String id, String pw, String name) {
		getConn();
		String sql = "insert into 회원정보 values(?,?,?,0)";
		int row=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, pw);
			psmt.setString(3, id);
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return row;
		
	}


	public boolean log(String id, String pw) {
		getConn();
		String sql = "select password from 회원정보 where id = ?";
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
	
	public String singleRank(String id) {
		getConn();
		String rank = "";
		String sql = "select * from(SELECT id, 점수, rank() over(order by 점수 desc) as 랭킹 from 회원정보) WHERE id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			rs.next();
			rank = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rank;
	}
	
	public int getNum(String id) {
		getConn();
		int num=0;
		String sql = "select 점수 from 회원정보 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return num;
		
	}
	
	public void setNum(int num, String id) {
		getConn();
		String sql = "update 회원정보 set 점수 = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			psmt.setString(2, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
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
	
	public ArrayList<DTO> rankAll(){
		getConn();
		ArrayList<DTO> al = new ArrayList<>();
		String sql = "select * from 회원정보 order by 점수 desc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				al.add(new DTO(rs.getString(1), rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
