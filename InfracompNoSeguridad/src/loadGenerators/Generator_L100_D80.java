package loadGenerators;

import uniandes.gload.core.LoadGenerator;
import uniandes.gload.core.Task;
import utils.ClientServerTask;

public class Generator_L100_D80
{
	/////////////////////////////////////////////////////////////////////////////////////
	
	//Atributos
	
	private LoadGenerator generator;
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	//Constructor
	
	public Generator_L100_D80 ()
	{
		Task work = createTask();
		int numberOfTasks = 100;
		int gapBetweenTasks = 80;
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
		new Generator_L100_D80();
	}

}
