import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Start
{
	public static boolean debug = false;
	private static String key = "";
	private static boolean used = false;
	public static boolean prompts = false;
	static Scanner in = new Scanner(System.in);
	public static IO out = new IO("soi");
	public static boolean localHost = false;
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		int action = 0;
		String firstInput = "";
		if (!debug)
		{
			firstInput = out.nextLine("Welcome! Would you like to generate a key or connect to the server? Please enter \"connect\" or \"generate\".");
		}
		else
		{
			firstInput = "generate";
		}
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
			out.println("I'm sorry. I didn't quite catch that.");
			firstInput = out.nextLine("Would you like to generate a key or connect to the server? Please enter \"connect\" or \"generate\".");
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
			out.println("Here's your key:");
			out.println(key);
			String textfile = "";
			if (prompts)
			{
				out.println("Please write this down on a piece of paper, and give that paper to another person you'd like to be able to chat with.");
				out.println("Do NOT give this key to them over ANY electronic means, or you may as well just be commnunicating in plain text.");
				out.println("In a minute, you will be prompted to enter your key. Please enter the key that you have just generated there.");
				if (!debug)
				{
					textfile = out.nextLine("If you'd like, I can have this placed into a text file for you to give to them. Would you like for me to do that?");
				}
				else
				{
					textfile = "yes";
				}
			}
			else
			{
				textfile = "yes";
			}
			if (textfile.equalsIgnoreCase("yes"))
			{
				@SuppressWarnings("resource")
				BufferedWriter bw = new BufferedWriter(new FileWriter("key.txt"));
				bw.write(key);
				bw.flush();
			}
		}
		if (action == 1)
		{
			String enteredKey = out.nextLine("Would you mind entering your key?");
			while (enteredKey.length() != 64)
			{
				enteredKey = out.nextLine("That key was invalid. Please enter it again.");
			}
			key = enteredKey;
			out.println("Thank you.");
		}
		out.println("I'm sending you off to connect to the server.");
		Client.run();
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
	
	public static void initKey()
	{
		AES.setKey(getKey());
	}
}
