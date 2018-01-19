package almundo.call.utilitie;

/**
 * 
 * @author agonzalez
 *
 */
public class Logger {

	private  org.apache.log4j.Logger logger = null;
	private String className;
	   
	public Logger(String className){
		logger=org.apache.log4j.Logger.getLogger(className);
		this.className=className;
	}
	
	public void debug(String log){
		logger.debug("["+className+"] "+log);
	}	
	
	public void error(String log){
		logger.error("["+className+"] "+log);
	}
	
}
