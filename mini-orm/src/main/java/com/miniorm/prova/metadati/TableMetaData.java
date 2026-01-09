package com.miniorm.prova.metadati;

import java.lang.reflect.Field;
import java.util.List;


public class TableMetaData {

	private String tableName;
	private Field idField;
	private List<ColumnMetaData> columns;
	
	public TableMetaData(String tableName, Field id, List<ColumnMetaData> columns) {
		this.columns = columns;
		this.tableName = tableName;
		this.idField = id;
	}

	public String getTableName() {
		return tableName;
	}

	public Field getIdField() {
		return idField;
	}

	public List<ColumnMetaData> getColumns() {
		return columns;
	}
	
	
	
}
