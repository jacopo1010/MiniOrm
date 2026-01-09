package com.miniorm.prova.database.operations;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class ElementaryQueryGeneratorImpl<T> implements  ElementaryQueryGenerator<T> {

	
	private final Class<T> domainClass;
	
	public ElementaryQueryGeneratorImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}
	
	@Override
	public T create(T t) {
	    
		
		return null;
	}

	@Override
	public T findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
