package com.isunmoon.oa.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env extends Properties {
	public static Env env;
	public static Env getInstance() {
		makeInstance();
		return env;
	}
	
	private static synchronized void makeInstance() {
		if(env == null) {
			env = new Env();
		}
	}
	
	private Env() {
		InputStream is = getClass().getResourceAsStream("/env.properties");
		try {
			super.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
