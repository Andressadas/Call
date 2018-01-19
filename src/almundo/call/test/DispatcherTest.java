package almundo.call.test;

import org.junit.Test;

import almundo.call.controller.Dispatcher;
import almundo.call.controller.EmployeeController;
import almundo.call.model.CallModel;
import almundo.call.model.EmployeeModel;
import almundo.call.utilitie.Constants;
import almundo.call.utilitie.generalUtilitie;

/**
 * Pruebas unitarias a la clase Dispatcher
 * contiene tres pruebas con diferentes numeros de llamadas 10, 11, 12
 * @author agonzalez
 *
 */
public class DispatcherTest {
	
	private EmployeeController employeeController = new EmployeeController();
	private CallModel callModel; 
	
	/**
	 * Constructor sin atributos
	 */
	public DispatcherTest(){
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
	}

	/**
	 * Caso de prueba 1, se envian 10 llamadas
	 * @throws InterruptedException
	 */
	@Test
	public void testDiesLlamadas() throws InterruptedException{
		//Ejecuta las llamadas
		runCall(10);	
	}
	
	/**
	 * Caso de prueba 1, se envian 11 llamadas
	 * @throws InterruptedException
	 */
	@Test
	public void testOnceLlamadas() throws InterruptedException{
		//Ejecuta las llamadas
		runCall(11);	
	}
	
	/**
	 * Caso de prueba 1, se envian 12 llamadas
	 * @throws InterruptedException
	 */
	@Test
	public void testDoceLlamadas() throws InterruptedException{
		//Ejecuta las llamadas
		runCall(12);	
	}
	
	/**
	 * metodo que ejecuta las llamadas de los casos de prueba
	 * @param numberCalls
	 * @throws InterruptedException
	 */
	private void runCall(int numberCalls) throws InterruptedException {	
		Dispatcher dispatcher = new Dispatcher(employeeController, numberCalls);
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
