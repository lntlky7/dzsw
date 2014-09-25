package com.dzsw.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JarLoader extends URLClassLoader {

	private String[] suffixs = { "jar" };
	private FilenameFilter filenameFilter = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			return equalSuffix(name);
		}
	};

	private static JarLoader instance;

	private JarLoader(URL[] urls) {
		super(urls, JarLoader.class.getClassLoader());
	}

	private static synchronized void syncInit(URL[] urls) {
		if (instance == null) {
			instance = new JarLoader(urls);
		}
	}

	private boolean equalSuffix(String fileName) {
		boolean result = false;
		String fileSuffix = FileUtils.getFileSuffix(fileName);
		for (String suffix : suffixs) {
			if (suffix.equals(fileSuffix)) {
				result = true;
			}
		}
		return result;
	}

	public static JarLoader getInstance(URL[] urls) {
		if (instance == null) {
			syncInit(urls);
		}
		return instance;
	}

	public void loadJar(URL url) {
		this.addURL(url);
	}

	public void loadJar(String jarPath) throws MalformedURLException {
		this.addURL(new File(jarPath).toURI().toURL());
	}

	public void loadJar(File file) throws MalformedURLException {
		this.addURL(file.toURI().toURL());
	}

	public void loadJarInPath(String pathname) throws MalformedURLException {
		File dir = new File(pathname);
		if (dir.isDirectory()) {
			File[] jarFiles = dir.listFiles(filenameFilter);
			for (File jarFile : jarFiles) {
				this.loadJar(jarFile);
			}
		}
	}

	public void loadJarInPathRecursion(File root) throws MalformedURLException {
		if (root.isDirectory()) {
			File[] files = root.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					this.loadJarInPathRecursion(file);
				} else {
					if (equalSuffix(file.getName())) {
						this.loadJar(file);
					}
				}
			}
		}
	}

	public String[] getSuffixs() {
		return suffixs;
	}

	public void setSuffixs(String[] suffixs) {
		this.suffixs = suffixs;
	}

	public FilenameFilter getFilenameFilter() {
		return filenameFilter;
	}

	public void setFilenameFilter(FilenameFilter filenameFilter) {
		this.filenameFilter = filenameFilter;
	}

}
