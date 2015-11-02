import javax.swing.JOptionPane;

public class IO
{
	String type = "";
	
	public IO(String messageType)
	{
		if (messageType.equals("soi") || messageType.equals("jop"))
		{
			type = messageType;
		}
	}
	
	public void print(String out)
	{
		if (type.equals("soi"))
		{
			System.out.print(out);
		}
		else if (type.equals("jop"))
		{
			JOptionPane.showMessageDialog(null, out);
		}
	}
	
	public void println(String out)
	{
		if (type.equals("soi"))
		{
			System.out.println(out);
		}
		else if (type.equals("jop"))
		{
			JOptionPane.showMessageDialog(null, out);
		}
	}
	
	public String nextLine()
	{
		if (type.equals("soi"))
		{
			return Start.in.nextLine();
		}
		return null;
	}
	
	public int nextInt()
	{
		if (type.equals("soi"))
		{
			return Start.in.nextInt();
		}
		return 0;
	}
	
	public double nextDouble()
	{
		if (type.equals("soi"))
		{
			return Start.in.nextDouble();
		}
		return 0;
	}
	
	public String nextLine(String message)
	{
		if (type.equals("soi"))
		{
			System.out.println(message);
			return Start.in.nextLine();
		}
		else if (type.equals("jop"))
		{
			return JOptionPane.showInputDialog(message);
		}
		return null;
	}
	
	public int nextInt(String message)
	{
		if (type.equals("soi"))
		{
			System.out.println(message);
			return Start.in.nextInt();
		}
		else if (type.equals("jop"))
		{
			return Integer.parseInt(JOptionPane.showInputDialog(message));
		}
		return 0;
	}
	
	public double nextDouble(String message)
	{
		if (type.equals("soi"))
		{
			System.out.println(message);
			return Start.in.nextDouble();
		}
		else if (type.equals("jop"))
		{
			return Double.parseDouble(JOptionPane.showInputDialog(message));
		}
		return 0;
	}
	
	public String getInput(String message)
	{
		if (type.equals("jop"))
		{
			return JOptionPane.showInputDialog(message);
		}
		return null;
	}
	
	public String forceInput(String message)
	{
		return JOptionPane.showInputDialog(message);
	}
}
