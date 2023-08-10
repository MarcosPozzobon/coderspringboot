package com.northwind.controllers;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {

	public synchronized static final Connection getConnection(){
	    try {
	    	
	        //Properties props = new Properties();
	    	Properties properties = new Properties();
	        FileInputStream in = new FileInputStream("D:\\DADOS DO USUARIO\\Desktop\\TUDO\\porcariada\\projetos\\cfgNorthWind\\config.properties");
	        properties.load(in);
	        in.close();
	        
	        String USER = properties.getProperty("user");
	        String PASS = properties.getProperty("password");
	        String URL = properties.getProperty("url");

	        Connection connection = DriverManager.getConnection(URL, USER, PASS);
	        
	        //System.out.println("Conectado!");

	        return connection;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
