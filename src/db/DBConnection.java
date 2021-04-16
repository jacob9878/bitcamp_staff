package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class DBConnection {
	private Connection conn;
	
	
	public DBConnection() {
		String user ="hr";
		String password ="hr";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			System.out.println("Driver Loading Success");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다");
		}	
	}
	

	public void selectUser() throws Exception {
		String sql = " SELECT * FROM STAFF ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("id\t이름\t전번");
			while(rs.next()) {
				System.out.print(rs.getString("id") +"\t");				
				System.out.print(rs.getString("name") + "\t");
				System.out.println(rs.getString("phonenumber") + "\t");
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void insertUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("id :" );
		String id = sc.next();
		System.out.println("name : ");
		String name = sc.next();
		System.out.println("전화번호 : ");
		String phonenumber = sc.next();
		
		String sql = "INSERT INTO STAFF( ID, NAME , PHONENUMBER)" 
					+ " VALUES(?,?,?)" ;
		
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, phonenumber);
			ps.executeQuery();
		}catch (SQLException e ) {
			e.printStackTrace();
		}
	}
	public void  updateUser() {
		String sql ="UPDATE STAFF SET NAME=?, PHONENUMBER=? WHERE ID=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("id :" );
		String id = sc.next();
		System.out.println("name : ");
		String name = sc.next();
		System.out.println("전화번호 : ");
		String phonenumber = sc.next();
		
		PreparedStatement ps = null;
		int num = 0;
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(3, id);
			ps.setString(1, name);
			ps.setString(2, phonenumber);
			ps.executeQuery();
		} catch (SQLException e) {
			num = -1;
			e.printStackTrace();
		}
		
	}
	public void deleteUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("id : ");
		String id = sc.next();
		
		String sql = "DELETE FROM STAFF WHERE ID = '" + id + "'";
		PreparedStatement ps =null;
		int num = 0;
		try {
			ps = conn.prepareStatement(sql);
			num = ps.executeUpdate();
		}catch (SQLException e) {
			num = -1;
			e.printStackTrace();
		}
	
	}
	
}
