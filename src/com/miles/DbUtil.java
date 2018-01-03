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

	//���ݿ�����
	private static String Driver;
	//���ݿ��ַ
	private static String Url;
	//���ݿ������û���
	private static String User;
	//���ݿ���������
	private static String Password;
	
	//��ʼ����̬������ֻ��ִ��һ�Ρ�
	static {
		try {
			//��ȡ�����ļ�����
			Properties properties = new Properties();
			//��ȡ�ļ���
			Reader reader = new FileReader("src\\config");
			//�����ļ�
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
	 * �����ݿ�����
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
