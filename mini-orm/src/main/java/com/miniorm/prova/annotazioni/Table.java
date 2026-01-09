package com.miniorm.prova.annotazioni;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/***
 *  in Java il carattere @ attaccato alla parola interface crea una annotazione (tipo speciale)
 *  mente tramite la libreria java.lang.annotation importiamo meta-annotazioni ovvero
 *  annotazioni che descrivo l'annotazione appena creata @inteface Table
 *  @Retention(RetentionPolicy.RUNTIME)
 *  → dice che l’annotazione resta disponibile a runtime, così puoi leggerla via reflection.
 *  @Target(ElementType.TYPE)
 *   → dice dove puoi usare l’annotazione (TYPE = classi).
 *
 *  
 * Perché serve RetentionPolicy.RUNTIME
 * Perché il nostro ORM deve poter leggere le annotazioni durante l’esecuzione:
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    
   public String name(); 
	
}
