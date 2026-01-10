package com.miniorm.prova.configurazioni;

public class LettoreSingleton {

	private static LettoreDiSettaggiImpl lettore;

	private LettoreSingleton() {}

	public static LettoreDiSettaggiImpl getLettoreDiSettaggiImpl() {
		if(lettore == null) {
			lettore = new LettoreDiSettaggiImpl();
		}
		return lettore;
	}
}
