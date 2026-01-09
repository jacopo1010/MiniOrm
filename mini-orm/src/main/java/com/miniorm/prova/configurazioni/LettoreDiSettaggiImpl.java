package com.miniorm.prova.configurazioni;

import java.io.InputStream;
import java.util.Properties;

/**
 * Classe che si occupa di individuare file in .properties nel progetto 
 * con le specifiche per la connessione con il database
 */


public class LettoreDiSettaggiImpl implements LettoreDiSettaggi {

	private final String resourceName = "application.properties";


	@Override
	public Properties carica() {
		Properties properties = new Properties();
		try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourceName)) {
			if (in == null) {
				throw new IllegalStateException("File config non trovato: " + resourceName);
			}
			properties.load(in);
			return properties;
		}catch(Exception e) {
			throw new RuntimeException("Errore lettura config: " + resourceName, e);
		}
	}



}
