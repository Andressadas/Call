package almundo.call.model;

/**
 * Contiene los atributos de PersonModel, asi como los metodos para acceder a ella
 * @author Andressadas
 *
 */
public class PersonModel {
	
	/**
	 * Atributo de la clase PersonModel
	 */
	private String namePerson;
	private int identificationNumber;
	
	/**
	 * Metodo get, extrae el nombre de la PersonModel
	 * @return
	 */
	public String getNamePerson() {
		return namePerson;
	}
	
	/**
	 * Metodo set, setea el nombre de la PersonModel
	 * @param namePerson
	 */
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}
	
	/**
	 * Metodo get, extrae la identficacion de la PersonModel
	 * @return
	 */
	public int getIdentificationNumber() {
		return identificationNumber;
	}
	
	/**
	 * Metodo set, setea la identificacion de la PersonModel
	 * @param identificationNumber
	 */
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	
}
