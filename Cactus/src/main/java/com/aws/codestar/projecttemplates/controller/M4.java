package com.aws.codestar.projecttemplates.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class M4 {
	int dificultad;
	String respuesta1;
	String respuesta2;
	String respuesta3;
	String respuestaCorrecta;
	String pregunta;
	String tipo;
	String[] respuestas= {respuesta1,respuesta2,respuesta3};
	String base="name of connection";
	String usuario="user";
	String contrasena="password";
	public static Connection connection = null;
	
	public M4() {
		// TODO Auto-generated constructor stub
	}
	
    public Connection getCurrentConnection(){
        if(M4.connection != null)
        {
            return M4.connection;
        }
        else
        {
        	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	M4.connection=DriverManager.getConnection(base,usuario,contrasena);
        	return M4.connection;
        	} catch (Exception e) {
			e.printStackTrace();
			return null;
			
			
        	}
        	
       }
    }
    
	
	public void set(int qid,String table){
		try {
			
			// 1. Get a connection to database
			Connection myConn = getCurrentConnection();
			//2. Create a statement
			Statement myStmt= myConn.createStatement();
			//3. Execute SQL query
			ResultSet myRs =myStmt.executeQuery("SELECT * from "+ table+" WHERE Qid ="+qid);
			myRs.next();
			this.pregunta=myRs.getString("Pregunta");
			this.respuesta1=myRs.getString("Respuesta1");
			this.respuesta2=myRs.getString("Respuesta2");
			this.respuesta3=myRs.getString("Respuesta3");
			this.tipo=myRs.getString("TipoPregunta");
			this.respuestaCorrecta=myRs.getString("Respuesta"+myRs.getInt("RespuestaCorrecta"));


		} catch (Exception e) {
			e.printStackTrace();
			
			
		}

	}
	

	public void showQuestion() {
		System.out.println(pregunta);
		System.out.print(respuesta1+" " +respuesta2+ " " + respuesta3 );

	}

	
	public boolean checkAnswer(String answer) {
		
		if(answer.equals(respuestaCorrecta)) {
			return true;
		}
		return false;
	}

	
	public int denominador() {
		// TODO Auto-generated method stub
		return dificultad;
	}

	
	public int numerador(boolean correcto) {
		if (correcto) {
			return dificultad;
		}
		return 0;
	}
	
	
	public int numPreguntas(String table) {
	try {
		// 1. Get a connection to database
		final Connection myConn = DriverManager.getConnection(base,usuario,contrasena);
		//2. Create a statement
		final Statement myStmt= myConn.createStatement();
		//3. Execute SQL query
		ResultSet myRs =myStmt.executeQuery("SELECT COUNT(pregunta) FROM "+table);
		myRs.next();
		return myRs.getInt("COUNT(pregunta)");
	} catch (Exception e) {
		e.printStackTrace();
		
		
	}
		return 0;
	}

}

