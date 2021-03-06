import java.util.Scanner;

public class ConsoleInput implements Runnable
{
	public static boolean run = false;
	
	@Override
	public void run()
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Running Console");
		while (!Server.stop)
		{
			String consInput = console.next();
			consInput.toLowerCase();
			if (consInput.equals("stop"))
			{
				Server.stop = true;
				break;
			}
			else if (consInput.startsWith("setPort="))
			{
				Server.port = Integer.parseInt(consInput.substring(9));
			}
			else if (consInput.equals("start") || consInput.equals("run"))
			{
				run = true;
			}
			else
			{
				System.out.println("Unrecognized Command");
			}
		}
		console.close();
	}
	
}
