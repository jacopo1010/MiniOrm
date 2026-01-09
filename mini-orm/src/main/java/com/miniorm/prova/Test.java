package com.miniorm.prova;

import java.sql.Connection;

import com.miniorm.prova.database.ConnectionToDb;
import com.miniorm.prova.metadati.AnnotationScanner;
import com.miniorm.prova.metadati.ColumnMetaData;
import com.miniorm.prova.metadati.TableMetaData;
import com.miniorm.prova.model.Utente;

public class Test {

	public static void main(String[] args) {
		  AnnotationScanner scanner = new AnnotationScanner(Utente.class);
          TableMetaData meta = scanner.scan();

          System.out.println("Tabella: " + meta.getTableName());
          System.out.println("ID field: " + meta.getIdField().getName());
          for (ColumnMetaData c : meta.getColumns()) {
              System.out.println("Colonna: " + c.getColumnName());
          }
	}

}
