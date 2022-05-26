package com.opus.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	{
		// properties class object

		File src = new File("./configuration/config.properties");
		// src is refering config file variable src.
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);// Load every text values
		} catch (Exception e) {

			System.out.println("Exception is " + e.getMessage());
		}
	}

	// To read each and every value from this variable create different method
	// (config.properties)
	public String getApplication() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getIePath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	// To read each and every value from this variable create different method
	public String getOpusApplication() {
		String url = pro.getProperty("OPUSUrl");
		return url;
	}

	public String getAdminUsername() {
		String adminUsername = pro.getProperty("adminUsername");
		return adminUsername;
	}

	public String getAdminPassword() {
		String adminPassword = pro.getProperty("adminPassword");
		return adminPassword;
	}
	
	public String getVendorUsername() {
		String vendorUsername = pro.getProperty("vendorUsername");
		return vendorUsername;
	}

	public String getVendorPassword() {
		String vendorPassword = pro.getProperty("vendorPassword");
		return vendorPassword;
	}
}
