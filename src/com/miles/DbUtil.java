package com.miles;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DbUtil {

	//数据库驱动
	private static String Driver;
	//数据库地址
	private static String Url;
	//数据库连接用户名
	private static String User;
	//数据库连接密码
	private static String Password;
	
	//初始化静态变量，只会执行一次。
	static {
		try {
			//读取配置文件对象
			Properties properties = new Properties();
			//读取文件流
			Reader reader = new FileReader("src\\config");
			//加载文件
			properties.load(reader);
			Driver = properties.getProperty("Driver");
			Url = properties.getProperty("Url");
			User = properties.getProperty("User");
			Password = properties.getProperty("Password");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 打开数据库连接
	 */
	public static Connection OpenConnection() {
			       try {
					Class.forName(Driver);
					return DriverManager.getConnection(Url, User, Password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return null;
	}
	public static void CloseConneciton(Connection conn) {
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
