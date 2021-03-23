package com.priyasoft.jdbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp07 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st = null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st = con.createStatement();
			rs=st.executeQuery("select * from emp1");
			System.out.println("Eno\tEname\tEsal\tEaddr");
			System.out.println("----------------------------");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getFloat(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
			}
		}catch(Exception e )
		{
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
