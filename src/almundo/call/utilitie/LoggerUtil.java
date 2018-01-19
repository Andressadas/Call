package almundo.call.utilitie;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author agonzalez
 *
 */
public class LoggerUtil {

    private URL url;
	
    private Logger logger = null;
    
    private LoggerUtil(String loggerClass){
    	try {
			url = new File(Constants.RUTA_LOG).toURI().toURL();
			System.out.println("URL " + url);
		} catch (MalformedURLException e) {
			System.out.println(Constants.ERROR);
			e.printStackTrace();
		}
        logger = new Logger(loggerClass);
    }

    public static Logger getLogger(String loggerClass){
        return new LoggerUtil(loggerClass).geWidgetsLogger();
    }

    private Logger geWidgetsLogger(){
        return logger;
    }

}
