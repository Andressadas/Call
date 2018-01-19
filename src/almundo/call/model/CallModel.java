package almundo.call.model;

/**
 * Contiene los atributos de CallModel, asi como los metodos para acceder a ella
 * @author agonzalez
 *
 */
public class CallModel {

	/**
	 * Atributos de la clase CallModel
	 */
	private int idCall;
	private int duration;
	
	/**
	 * Constructor con atributos
	 * @param idCall
	 * @param state
	 */
	public CallModel(int idCall, int duration){
		this.idCall = idCall;
		this.duration = duration;
	}

	/**
	 * Metodo get, extrae el idCall de la CallModel
	 * @return
	 */
	public int getIdCall() {
		return idCall;
	}

	/**
	 * Metodo set, setea el idCall de la CallModel
	 * @param idCall
	 */
	public void setIdCall(int idCall) {
		this.idCall = idCall;
	}

	/**
	 * Metodo get, extrae la duracion de la CallModel
	 * @return
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Metodo set, setea la duracion de la CallModel
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
		
}
