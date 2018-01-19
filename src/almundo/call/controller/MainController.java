package almundo.call.controller;

import almundo.call.model.CallModel;
import almundo.call.model.EmployeeModel;
import almundo.call.utilitie.generalUtilitie;
import almundo.call.utilitie.Constants;

/**
 * Permite la ejecucion de la aplicacion, carga los emleados
 * ejecuta las llamadas dependiendo de la configuracion del archivo properties
 * @author Andressadas
 *
 */
public class MainController {

	/**
	 * Atributos de la clase
	 */
	private int numberCalls = 0;
	private static EmployeeController employeeController = new EmployeeController();
	private CallModel callModel;
	private Dispatcher dispatcher;
	

	/**
	 * Costructor con atributos, donde iniciamos el objeto dispatcher,
	 * cargamos el numero de llamadas que se encuentra en el archivo properties
	 * @param employeeController
	 */
	public MainController(EmployeeController employeeController){
		numberCalls = Integer.parseInt(generalUtilitie.getProperty(Constants.NUMERO_LLAMADAS));
		dispatcher = new Dispatcher(employeeController, numberCalls);
	}
	
	/**
	 * Metodo que ejecuta la aplicacion, asigna los atributos de los empleados
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException  {
		//Agrega los operadores
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Andres Gonzalez", 84459440, true));
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Julio Gonzalez", 84459441, true));		
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Diego Gonzalez", 84459442, true));		
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Edward Gonzalez", 84459443, true));		
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Daniel Gonzalez", 84459444, true));
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Oscar Gonzalez", 84459445, true));	
		employeeController.addEmployeeList(new EmployeeModel(Constants.OPERADOR, "Carlos Gonzalez", 84459446, true));	
		employeeController.addEmployeeList(new EmployeeModel(Constants.SUPERVISOR, "Jaime Gonzalez", 84459447, true));	
        employeeController.addEmployeeList(new EmployeeModel(Constants.SUPERVISOR, "Danilo Gonzalez", 84459448, true));	
		employeeController.addEmployeeList(new EmployeeModel(Constants.DIRECTOR, "Damaris Gonzalez", 84459449, true));
		MainController main = new MainController(employeeController);		
		//Ejecuta metodo
		main.runCall();
	}
	
	/**
	 * Metodo que ejecuta las llamadas y le asigna los atributos de la misma,
	 * duerme el executor una vez terminado el ciclo
	 */
	private void runCall() throws InterruptedException {	
		//Ciclo de ejecuciones
		for(int i=0; i<numberCalls; i++){
			//Setea los datos a la llamada
			callModel = new CallModel(i, generalUtilitie.durationRandom());
			//Ejecuta la llamada
			dispatcher.dispatchCall(callModel);
		}
		//Apaga el executor
		dispatcher.shutdownExecutorService();	
	}

	
	
	
	
	
}
