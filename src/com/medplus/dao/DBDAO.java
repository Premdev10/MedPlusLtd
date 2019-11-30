package com.medplus.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBDAO {
	private static Connection dbCon;
	private static String dbURL;
	private static String dbDriver;
	private static String userName;
	private static String passWord;
	
	

	
	
	
	
	public static void dbInit(){
		dbDriver="oracle.jdbc.driver.OracleDriver";
		dbURL="jdbc:oracle:thin:@localhost:1521:xe";
		userName="premdev";
		passWord="premdev";
		
		
	}
	
	
	
	//---------End database initialization---------//
	
	//---- start database connection----------//
	
	/**
	 * @author: NIDHIN
	 * @date: 30/10/2019]
	 * @version: 1.0
	 * @param:nothing
	 * @return:connection
	 * $throws: exception in case of missing drivers
	 */
	
	
	public static void dbConnection() throws ClassNotFoundException{
		dbInit();
		try{
		Class.forName(dbDriver);
		Connection con=DriverManager.getConnection(dbURL,userName,passWord);
		setDbCon(con);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	//--------end database connection----//
	
	//--- start get db connection-----//
	/**
	 * @author NIDHIN
	 * @date:30/10/2019
	 * @return:Connection
	 * @param:nothing
	 */
	
	public static Connection getDbCon(){
		return dbCon;
	}
	
	//------end get db connection---//
	
	//----start set dbconnection---//
	/*
	 * @author NIDHIN
	 * @date:30/10/2019
	 * @version:1.0
	 * @return:nothing
	 * @param:Connection
	 */
	
	
	public static void setDbCon(Connection con){
		dbCon=con;
	}
	
	//-------End set db connection-----//
	
	//----start db connection close-----//
	
	/*
	 * @author NIDHIN
	 * @date:30/10/2019
	 * @version:1.0
	 * @return:nothing
	 * @param:Connection
	 */

	public static void close(){
		try{
		dbCon.close();
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	//-------End db close  ------//
		
		
	}	
	
	
	
	
	
	
	
	
	





}



