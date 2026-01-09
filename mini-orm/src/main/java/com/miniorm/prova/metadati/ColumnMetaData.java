package com.miniorm.prova.metadati;

import java.lang.reflect.Field;

public class ColumnMetaData {

	private String columnName;
	private Field field;
	
	public ColumnMetaData(String columnName, Field field) {
		this.columnName = columnName;
		this.field = field;
	}

	public String getColumnName() {
		return columnName;
	}

	public Field getField() {
		return field;
	}
	
	
}
