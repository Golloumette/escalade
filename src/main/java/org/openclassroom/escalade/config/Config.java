package org.openclassroom.escalade.config;

import java.util.ResourceBundle;

public class Config {
	private String classname;
	private String port;
	private String serveur;
	private String bdd;
	private String user;
	private String password;
	
	public String getClassname() {
		return classname;
	}
	public String getPort() {
		return port;
	}
	public String getServeur() {
		return serveur;
	}
	public String getBdd() {
		return bdd;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	
	 public static Config getRessource() {
	       if (ressource ==null) {
	    	   ressource = new Config();
	       }
	        return ressource;
	    }


	    private static Config ressource;
	    
	    private Config() {
		readerproperty();
		
	}
	
	public void readerproperty() {
		ResourceBundle config = ResourceBundle.getBundle("escalade");
		
		
		classname = config.getString("Classname");
		port = config.getString("Port");
		serveur= config.getString("Serveur");
		bdd = config.getString("Bdd");
		user = config.getString("User");
		password = config.getString("Password");
	}
	

}
