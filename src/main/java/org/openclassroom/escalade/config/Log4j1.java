package org.openclassroom.escalade.config;

import org.apache.log4j.Logger;

public class Log4j1 {
	private static Logger logger = Logger.getLogger(Log4j1.class);

	public static void main(String[] args) {
		logger.debug("msg de debogage");
	    logger.info("msg d'information");
	    logger.warn("msg d'avertissement");
	    logger.error("msg d'erreur");
	    logger.fatal("msg d'erreur fatale");
		

	}

}
