package com.miniorm.prova.metadati;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import com.miniorm.prova.annotazioni.*;

/*
 * Classe che scansiona le annotazioni attraverso il metodo scan.
 */


public class AnnotationScanner {

	private final Class<?> classeDaScansionare;


	public AnnotationScanner(Class<?> scansionare) {
		this.classeDaScansionare = scansionare;
	}

	/**
	 * scanzione attraverso la riflessione (interroga la classe stessa)
	 * 1) si parte dalla tabella
	 * 2) si trova la key 
	 * 3) si cicla sulle colonne
	 * 4) se crea TableMetaData
	 * @return TableMetaData {@link MetaData}
	 */

	public TableMetaData scan() {
		Table table	= this.classeDaScansionare.getAnnotation(Table.class);
		if(table == null) {
			return null;
		}
		Field primaryKey = null;
		Field[] fields = this.getClasseDaScansionare().getDeclaredFields();
		List<ColumnMetaData> columns = new ArrayList<ColumnMetaData>();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			if (field.isAnnotationPresent(Key.class)) {
				primaryKey = field;
			}

			if (field.isAnnotationPresent(Column.class)) {
				columns.add(new ColumnMetaData(field.getName(), field));
			}
		}

		return new TableMetaData(table.name(), primaryKey, columns);
	}




	public Class<?> getClasseDaScansionare() {
		return classeDaScansionare;
	}


}
