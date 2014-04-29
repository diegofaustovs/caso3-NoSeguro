package loadGenerators;

import uniandes.gload.core.LoadGenerator;
import uniandes.gload.core.Task;
import utils.ClientServerTask;

public class Generator_L400_D20
{
	/////////////////////////////////////////////////////////////////////////////////////
	
	//Atributos
	
	private LoadGenerator generator;
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	//Constructor
	
	public Generator_L400_D20 ()
	{
		Task work = createTask();
		int numberOfTasks = 400;
		int gapBetweenTasks = 20;
		generator = new LoadGenerator("Caso 3", numberOfTasks, work, gapBetweenTasks);
		generator.generate();
		System.exit(0);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////

	private Task createTask()
	{
		return new ClientServerTask();
	}
	public static void main(String[] args)
	{
		new Generator_L400_D20();
	}

}
