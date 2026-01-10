package com.miniorm.prova.database;

import java.util.Properties;

import com.miniorm.prova.classloader.PackageScanner;
import com.miniorm.prova.metadati.TableMetaData;

public class DatabaseManager {

	private final ConnectionToDb conn;
	private final PackageScanner scanner;

	public DatabaseManager() {
		this.conn = new ConnectionToDb();
		this.scanner = new PackageScanner();
	}

	public ConnectionToDb getConn() {
		return conn;
	}

	public PackageScanner getScanner() {
		return scanner;
	}
	
	
	public void initConnection() {
		Properties properties = this.scanner.getLettoreDiSettaggi().carica();
		String typeCreation = properties.getProperty("jacorm.ddl.creation-method");
		if(typeCreation == null || typeCreation.isEmpty()) {
			//fai qualcosa 
		}
		
		switch (typeCreation.toLowerCase()) {
		case "create":
              
			break;
		case"update":
			break;
		default:
			break;
		}

	}

	
	private boolean create(TableMetaData table) {
		
		return false;
	}
	


	
	private boolean update(TableMetaData table) {
		// TODO Auto-generated method stub
		return false;
	}

    //codex resume 019ba7c6-6d5c-7ec1-94df-7d8e5c4e5fcb
	
}
