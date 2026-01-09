package com.miniorm.prova.lettore;

import com.miniorm.prova.metadati.AnnotationScanner;
import java.lang.ClassLoader;
import java.net.URL;
import java.util.Enumeration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Loader semplificato: per ora scansiona solo classi nel package che termina con ".model".
 * TODO: rendere il package configurabile via settings/properties.
 */
public class PackageScanner implements ScansionaProgetto{

	@Override
	public void scansiona() {
		
	}

	

	

}
