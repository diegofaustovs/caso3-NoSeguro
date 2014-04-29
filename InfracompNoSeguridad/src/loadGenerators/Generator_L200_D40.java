package loadGenerators;

import uniandes.gload.core.LoadGenerator;
import uniandes.gload.core.Task;
import utils.ClientServerTask;

public class Generator_L200_D40
{
	/////////////////////////////////////////////////////////////////////////////////////
	
	//Atributos
	
	private LoadGenerator generator;
	/////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	
	//Constructor
	
	public Generator_L200_D40 ()
	{
		Task work = createTask();
		int numberOfTasks = 200;
		int gapBetweenTasks = 40;
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
		new Generator_L200_D40();
	}

}
