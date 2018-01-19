package almundo.call.utilitie;

import java.util.Properties;
import java.util.Random;

/**
 * Contiene todas las utilidades de la aplicacion, desde el calculo del numero aleatrio
 * hasta la busqueda de los datos del archivo properties
 * @author agonzalez
 *
 */
public class generalUtilitie {
	
	/**
	 * Atributo donde se carga el properties
	 */
	private static Properties systemParameters;
	
	/**
	 * Metodo que calcula la duracion de la llamada
	 * @param max
	 * @param min
	 * @return
	 */
	public static int durationRandom(){
		Random r = new Random();
		return (r.nextInt(Constants.MAX - Constants.MIN) + Constants.MIN) * 1000;
	}
	
	/**
	 * Metodo que permite buscar los datos en el archivo Properties
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {	
		if(systemParameters==null){
			systemParameters=new Properties();
			try {
				systemParameters.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.RUTA_PROPERTIES));
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		return systemParameters.getProperty(key);
	}

}
