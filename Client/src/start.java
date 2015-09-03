import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class start
{
	private static String key = "";
	private static boolean used = false;
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int action = 0;
		System.out.println("Welcome! Would you like to generate a key or connect to the server? Please enter \"connect\" or \"generate\".");
		String firstInput = in.nextLine();
		if (firstInput.equalsIgnoreCase("connect"))
		{
			action = 1;
		}
		else if (firstInput.equalsIgnoreCase("generate"))
		{
			action = 2;
		}
		while (action == 0)
		{
			System.out.println("I'm sorry. I didn't quite catch that.");
			System.out.println("Would you like to generate a key or connect to the server? Please enter \"connect\" or \"generate\".");
			firstInput = in.nextLine();
			
			if (firstInput.equalsIgnoreCase("connect"))
			{
				action = 1;
			}
			else if (firstInput.equalsIgnoreCase("generate"))
			{
				action = 2;
			}
		}
		if (action == 2)
		{
			key = GenerateKey.generateKey();
			System.out.println("Here's your key:");
			System.out.println(key);
			System.out.println("Please write this down on a piece of paper, and give that paper to another person you'd like to be able to chat with.");
			System.out.println("Do NOT give this key to them over ANY electronic means, or you may as well just be commnunicating in plain text.");
			System.out.println("In a minute, you will be prompted to enter your key. Please enter the key that you have just generated there.");
			System.out.println("If you'd like, I can have this placed into a text file for you to give to them. Would you like for me to do that?");
			String textfile = in.nextLine();
			if (textfile.equalsIgnoreCase("yes"))
			{
				@SuppressWarnings("resource")
				BufferedWriter bw = new BufferedWriter(new FileWriter("key.txt"));
				bw.write(key);
				bw.flush();
			}
		}
		System.out.println("All right. I'm sending you off to connect to the server.");
		client.run();
	}
	
	public static boolean checkKey()
	{
		if (key.equalsIgnoreCase(""))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static String getKey()
	{
		if (!used)
		{
			return key;
		}
		used = true;
		return "illegal";
	}
}
