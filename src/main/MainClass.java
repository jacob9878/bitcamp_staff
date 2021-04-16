package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import db.DBConnection;

public class MainClass {
	
	public static void main(String[] args) throws Exception{
	
		DBConnection db = new DBConnection();
		db.selectUser();
		
		
		  int num; while(true) { 
		  System.out.println("1. 사원 전체 출력 ");
		  System.out.println("2. 사원 추가 "); 
		  System.out.println("3. 사원 수정 ");
		  System.out.println("4. 사원 삭제 ");
		  System.out.println(">>");
		  
		  num = new Scanner(System.in).nextInt(); 
		  switch (num) { 
		  case 1: db.selectUser();
		  break; 
		  case 2: db.insertUser();
		  break;
		  case 3: db.updateUser();
		  break;
		  case 4: db.deleteUser();
		  default:
		  }
	  }
		
	}

}
