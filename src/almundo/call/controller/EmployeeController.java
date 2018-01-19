package almundo.call.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import almundo.call.model.EmployeeModel;

/**
 * Controla todo lo que tiene que ver con los empleados, agregar a la lista, buscar, cambiar estado
 * @author agonzalez
 * 
 */
public class EmployeeController {

	/**
	 * LinkedHashMap donde se agregan los empleados, y se utiliza el numero de identificacion como key.
	 */
	private LinkedHashMap<Integer, EmployeeModel> employeeList;

	/**
	 * Constructor sin atributos
	 */
	public EmployeeController() {
		employeeList = new LinkedHashMap<Integer, EmployeeModel>();
	}

	/**
	 * Busca los empleados disponible, y cambia el estado de los mismos a false una ves encontrados.
	 * @return
	 */
	public EmployeeModel consultEmpladoAvailable() {
		EmployeeModel employeeModel = null;
		//Recorre el Hasmap
		for (Map.Entry<Integer, EmployeeModel> entry : employeeList.entrySet()) {
            //Valida si el emplado esta ocupado
			if(entry.getValue().isState()){
				employeeModel = entry.getValue();
				//Cambia el estado
				employeeModel.setState(false);
				//Modifica el dato en el Hasmap
				employeeList.put(employeeModel.getIdentificationNumber(), employeeModel);
				//Retorna el empleado
				return employeeModel;
			}
		}
		//Retorna null
		return employeeModel;
	}

	/**
	 * Metodo que permite agregar los empleados al LinkedHashMap
	 * @param typeEmployee
	 * @param employeListOrder
	 */
	public void addEmployeeList(EmployeeModel employeeModel) {
		employeeList.put(employeeModel.getIdentificationNumber(), employeeModel);
	}

}
