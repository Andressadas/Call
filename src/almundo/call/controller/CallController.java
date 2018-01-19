package almundo.call.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import almundo.call.model.CallModel;
import almundo.call.model.EmployeeModel;
import almundo.call.utilitie.LoggerUtil;
import almundo.call.utilitie.Logger;

/**
 * Controla todo lo referente a la llamada, desde la ejecucion de los hilos, la escritura de los log.
 * implementa Callable
 * @author Andressadas
 *
 */
public class CallController implements Callable<CallController> {

	/**
	 * Atributos de la clase
	 */
	private CallModel callModel;
	private EmployeeController employeeController;
	private EmployeeModel employeeModel;
	
	/**
	 * Atributo que permite escribir en el log
	 */
	private static Logger logger = LoggerUtil.getLogger(CallController.class.getName());
	
	/**
	 * Constructor sin atributos
	 */
	public CallController(){
		
	}
	
	/**
	 * Constructor con atributos, con el cual iniciamos los objetos
	 * @param callModel
	 */
    public CallController(CallModel callModel, EmployeeController employeeController, EmployeeModel employeeModel){
		this.callModel = callModel;
		this.employeeController = employeeController;
		this.employeeModel = employeeModel;
	}
    
	/**
	 * Hilos de las llamadas, escribe en el log el inicio de la llamada,
	 * duerme el hilo el tiempo que se le asigno de forma aleatoria,
	 * cambia el estado del empleado una vez que termina
	 * @return 
	 */
	public CallController call() {	
		try {
			//Escribe en el log
			logger.debug("¡Inicio!. Llamada codigo: " + callModel.getIdCall() + " Duracion: " + callModel.getDuration() + " Atendida por: " + employeeModel.getNamePerson());
			//Duerme el hilo
			TimeUnit.MILLISECONDS.sleep(callModel.getDuration());
			//Cambia el estado al empleado
			employeeModel.setState(true);
			//Agrega el empleado a la lista
			employeeController.addEmployeeList(employeeModel);
			//Escribe en el log
			logger.debug("¡Termino!. Llamada codigo: " + callModel.getIdCall() + " Duracion: " + callModel.getDuration() + " Atendida por: " + employeeModel.getNamePerson());
		} catch (InterruptedException e) {
			//Escribe en el log
			logger.error("Error: " + e.getMessage());
		}
		return this;
	}

	/**
	 * Metodo que escribe cuando hay llamadas en espera
	 */
	public void writeCallWait() {
		// Escribe en el log
		logger.debug("¡Llamadas en espera!");
	}
	
}
