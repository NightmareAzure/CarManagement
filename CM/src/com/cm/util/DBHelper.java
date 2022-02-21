package com.cm.util;

import java.sql.Connection;

import com.cm.core.CMError;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//实现数据库的封装
public class DBHelper {
	private static String user="sa";
	private static String password="123456";
	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=CM";
	private static Connection conn=null;
	private static PreparedStatement pstmt=null;
	private static ResultSet rss=null;
	private static Connection CreateConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
			conn= DriverManager.getConnection(url,user,password); 
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
		return conn;
	}
	public void executeUpdate(String sql,Object[] values ){
			try {
				CreateConnection();
				pstmt=conn.prepareStatement(sql);
				if(values!=null&&values.length>0){
					for(int i=0;i<values.length;i++){
						pstmt.setObject(i+1, values[i]);
					}
				}
				pstmt.executeUpdate();
			} catch (Exception e) {
				throw new CMError(e.getMessage(),e);
			}
	}
	
	public ResultSet executeQuery(String sql,Object[] values ){
		try {
			CreateConnection();
			pstmt=conn.prepareStatement(sql);
			if(values!=null&&values.length>0){
				for(int i=0;i<values.length;i++){
					pstmt.setObject(i+1, values[i]);
				}
			}
			rss=pstmt.executeQuery();
			return rss;
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
	}
	public void DBClose(){
		try {
			if(rss!=null)
				rss.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			throw new CMError(e.getMessage(),e);
		}
	}
}
