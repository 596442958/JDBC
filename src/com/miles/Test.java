package com.miles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//数据库连接
		Connection conn=DbUtil.OpenConnection();
		
		String sql="select * from student";
		
		try {
			Statement statement = conn.createStatement();
			//结果
			ResultSet  resultSet=  statement.executeQuery(sql);
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				System.out.println("id:"+id+" 姓名:"+name+" 年龄:"+age);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.CloseConneciton(conn);
		}
		
	}

}
