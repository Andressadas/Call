package almundo.call.controller;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import almundo.call.model.CallModel;
import almundo.call.model.EmployeeModel;

/**
 * Se encarga de manejar las asignaciones de las llamadas.
 * asi como el manejo de las llamadas en cola
 * @author Andressadas
 *
 */
public class Dispatcher {

	/**
	 * Atributos de la clase Dispatcher
	 */
	private EmployeeController employeeController;
	private CallController callController;
	private ExecutorService executorService;
	private ExecutorCompletionService<CallController> completionService;
	
	/**
	 * Constructor con atributos, por medio del cual iniciamos los objetos
	 * @param employeeController
	 */
	public Dispatcher(EmployeeController employeeController, int numberCalls){
		this.employeeController = employeeController;
		callController = new CallController();
		//Inicia el pool setenadole el numero de llamadas
		executorService = Executors.newFixedThreadPool(numberCalls);
		//Inicia completionService seteandole el pool
		completionService = new ExecutorCompletionService<>(executorService);
	}
	
	/**
	 * Maneja la asignacion de las llamadas, asi como las llamadas en espera
	 * @param callModel
	 */
	public void dispatchCall(CallModel callModel) throws InterruptedException {
		//Consulta los empleados en estado true, si retorna null es por que no hay disponibles
		EmployeeModel employeeModel = employeeController.consultEmpladoAvailable();
		//Si employeeModel es nulo es por que no hay empleados disponibles y pasa la llamada a espera
		if(employeeModel != null){
			//Ejecuta el hilo
			completionService.submit(new CallController(callModel, employeeController, employeeModel));
		}else{
			//Agrega la llamada a la lista de espera
			callController.writeCallWait();	
			//Ejeuta la lista de llamadas en espera
			while(callModel != null){
				//Paraliza el proceso hasta que uno de los que este en ejecucion termine
				completionService.take();
			    //Ejecuta la llamada
				dispatchCall(callModel);
				//Seteamos null con el fin de terminar el while
				callModel = null;
			}
		}
	}

    /**
     * Apaga el executor
     */
	public void shutdownExecutorService() {
		this.executorService.shutdown();
	}
	
	
	
}
