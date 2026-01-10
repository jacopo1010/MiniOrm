package com.miniorm.prova.classloader;

import com.miniorm.prova.configurazioni.LettoreDiSettaggi;
import com.miniorm.prova.configurazioni.LettoreSingleton;
import com.miniorm.prova.metadati.AnnotationScanner;
import com.miniorm.prova.metadati.TableMetaData;

import java.io.IOException;
import java.lang.ClassLoader;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.net.URISyntaxException;

/**
 * Loader semplificato: per ora scansiona solo classi nel package che termina con ".model".
 * TODO: rendere il package configurabile via settings/properties.
 */
public class PackageScanner implements ScansionaProgetto{

	private LettoreDiSettaggi lettore;

	public PackageScanner() {
		this.lettore = LettoreSingleton.getLettoreDiSettaggiImpl();
	}

	@Override
	public List<TableMetaData> scansiona() {
		Properties proprieta = this.lettore.carica();
		String packageName = proprieta.getProperty("jacorm.package.model");
		if(packageName == null || packageName.isEmpty()) {
			throw new IllegalStateException("Manca jacorm.package.model in application.properties");
		}
		String packagePath = packageName.replace('.' ,'/');
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		List<TableMetaData> scansionati = new ArrayList<TableMetaData>();
		try {
			Enumeration<URL> resources = cl.getResources(packagePath);
			while (resources.hasMoreElements()) {
				URL url = resources.nextElement();
				String protocol = url.getProtocol();

				if ("file".equals(protocol)) {
					Path root = Paths.get(url.toURI());
					try (java.util.stream.Stream<Path> stream = Files.walk(root)) {
						stream.filter(Files::isRegularFile)
						  .filter(p -> p.toString().endsWith(".class"))
						  .forEach(p -> {
								  String pathStr = p.toString();
								  int idx = pathStr.indexOf(packagePath);
								  if (idx < 0) {
									  return;
								  }
								  String className = pathStr
										  .substring(idx)
										  .replace('\\', '.')
										  .replace('/', '.')
										  .replace(".class", "");
							if (!className.contains("$")) {
								try {
									Class<?> clazz = Class.forName(className, false, cl);
									TableMetaData meta = new AnnotationScanner(clazz).scan();
									if (meta != null) {
										scansionati.add(meta);
									}
								} catch (ClassNotFoundException e) {
									// Ignora classi non caricabili
								}
							}
						});
					}
				} else if ("jar".equals(protocol)) {
					JarURLConnection conn = (JarURLConnection) url.openConnection();
					try (JarFile jar = conn.getJarFile()) {
						Enumeration<JarEntry> entries = jar.entries();
						while (entries.hasMoreElements()) {
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							if (name.startsWith(packagePath) && name.endsWith(".class") && !name.contains("$")) {
								String className = name.replace('/', '.').replace(".class", "");
								try {
									Class<?> clazz = Class.forName(className, false, cl);
									TableMetaData meta = new AnnotationScanner(clazz).scan();
									if (meta != null) {
										scansionati.add(meta);
									}
								} catch (ClassNotFoundException e) {
									// Ignora classi non caricabili
								}
							}
						}
					}
				}
			}
		}catch(IOException | URISyntaxException e) {
			throw new RuntimeException("Errore durante la scansione del package: " + packageName, e);
		}
		return scansionati;
	}





}
