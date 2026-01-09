package com.miniorm.prova.model;

import com.miniorm.prova.annotazioni.Column;
import com.miniorm.prova.annotazioni.Key;
import com.miniorm.prova.annotazioni.Table;

@Table(name = "Utenti")
public class Utente {

	@Key
	private Long id;
	@Column
	private String username;
	
}
