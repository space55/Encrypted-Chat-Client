import java.util.Scanner;

public class client
{
	private static String key = "";
	
	public static String username = "";
	public static String ip = "localhost";
	
	public static void run() throws Exception
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		if (start.checkKey())
		{
			System.out.println("I noticed that you had a key stored. Would you like for me to retrieve it?");
			String shouldRetrieveKey = in.nextLine();
			if (shouldRetrieveKey.equalsIgnoreCase("yes"))
			{
				key = start.getKey();
				if (key.equals("illegal"))
				{
					System.out.println("You do not have access permissions to the stored key.");
					key = "";
					System.out.println("Please enter the key the other person has given to you or you have generated");
					String inputKey = in.nextLine();
					while (inputKey.length() != 64)
					{
						System.out.println("Your key is invalid. Please enter it again");
						inputKey = in.nextLine();
					}
					key = inputKey;
				}
			}
			else
			{
				System.out.println("Okay. Then please enter the key the other person has given you.");
				String inputKey = in.nextLine();
				while (inputKey.length() != 64)
				{
					System.out.println("Your key is invalid. Please enter it again");
					inputKey = in.nextLine();
				}
				key = inputKey;
			}
			System.out.println("All right. I've retrieved the following key:");
			System.out.println(key);
			System.out.println("Does that look correct?");
			String correctKey = in.nextLine();
			if (!correctKey.equalsIgnoreCase("yes"))
			{
				System.out.println("Okay then. Please enter the key you generated or were given.");
				String inputKey = in.nextLine();
				while (inputKey.length() != 64)
				{
					System.out.println("Your key is invalid. Please enter it again");
					inputKey = in.nextLine();
				}
				key = inputKey;
			}
			System.out.println("I'm connecting you to the server now.");
			System.out.println("Please enter a username.");
			username = in.nextLine();
			ChatClient.init();
			while (true)
			{
				String plaintext = in.nextLine();
				String output = AES.encrypt(plaintext, key);
			}
		}
	}
	
	public static String getKey()
	{
		return key;
	}
}
