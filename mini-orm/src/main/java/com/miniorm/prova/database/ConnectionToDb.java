package com.miniorm.prova.database;

import com.miniorm.prova.configurazioni.LettoreDiSettaggi;
import com.miniorm.prova.configurazioni.LettoreDiSettaggiImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionToDb {

	private LettoreDiSettaggi lettore;
	
	public ConnectionToDb() {
		this.lettore = new LettoreDiSettaggiImpl();
	}

	
	public Connection initConnection() throws SQLException {
		Properties proprieta = this.lettore.carica();
		String url = proprieta.getProperty("jacorm.db.url");
		String username = proprieta.getProperty("jacorm.db.username");
		String psw = proprieta.getProperty("jacorm.db.password");
		if (url == null || url.isEmpty()) {
			throw new IllegalStateException("Manca jacorm.db.url in application.properties");
		}
		if (username == null || username.isEmpty()) {
			throw new IllegalStateException("Manca jacorm.db.username in application.properties");
		}
		if (psw == null || psw.isEmpty()) {
			throw new IllegalStateException("Manca jacorm.db.password in application.properties");
		}
		return DriverManager.getConnection(url, username, psw);
	}
	
	
	
}
