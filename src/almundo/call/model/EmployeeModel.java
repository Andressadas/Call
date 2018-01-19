package almundo.call.model;

/**
 * Contiene los atributos de EmployeeModel, asi como los metodos para aceder a ellos, tambien hereda atributos de la clase PersonModel
 * @author Andressadas
 *
 */
public class EmployeeModel extends PersonModel{

	/**
	 * Atributos de la clase EmployeeModel
	 */
	private String typeEmployees;
	private boolean state;
	
	/**
	 * Constructor sin atributos
	 */
	public EmployeeModel(){
		
	}
	
	/**
	 * Constructor con atributos
	 * @param typeEmployees
	 * @param namePerson
	 * @param identificationNumber
	 * @param state
	 */
	public EmployeeModel(String typeEmployees, String namePerson, int identificationNumber, boolean state){
		this.typeEmployees = typeEmployees;
		this.state = state;
		setNamePerson(namePerson);
		setIdentificationNumber(identificationNumber);	
	}

	/**
	 * Metodo get, extrae el tipo de empleado de la EmployeeModel
	 * @return
	 */
	public String getTypeEmployees() {
		return typeEmployees;
	}

	/**
	 * Metodo set, setea el tipo de empleado de la EmployeeModel
	 * @param typeEmployees
	 */
	public void setTypeEmployees(String typeEmployees) {
		this.typeEmployees = typeEmployees;
	}

	/**
	 * Metodo get, extrae el estado de la EmployeeModel
	 * @return
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * Metodo set, setea el estado de la EmployeeModel
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
