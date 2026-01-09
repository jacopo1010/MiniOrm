package com.miniorm.prova.database.operations;

import java.util.List;

public interface ElementaryQueryGenerator<T> {

	  public T create(T t);
	
	  public T findById();
	  
	  public List<T> findAll(Object id);
	  
	  public boolean delete(T t);
	  
	  public int count();
	  
	  public void deleteAll();
}
