package gamenew;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class game 
{

	


	public static void main(String[] args) 
	{

		int dif=0;
		try
		{
			FileWriter logger = new FileWriter("latest_log.log");
			File log = new File("latest_log.log");
            logger.write("The game was launched" + "\n");
            logger.close();
		}
		catch (IOException exp) {}


				String rez = JOptionPane.showInputDialog(null,
						"ведите сложность игры от 1 до 7", 1);
				try
				{
					FileWriter logger = new FileWriter("latest_log.log");
					File log = new File("latest_log.log");
		            logger.write("The difficulty asking window appeared" + "\n");
		            logger.close();
				}
				catch (IOException exp) {}
				
				dif = rez.charAt(0)-'0';
				try
				{
					FileWriter logger = new FileWriter("latest_log.log");
					File log = new File("latest_log.log");
		            logger.write("The game difficulty set to" + dif + "\n");
		            logger.close();
				}
				catch (IOException exp) {}
				
				if((dif<1))
				{
					try
					{
						FileWriter logger = new FileWriter("latest_log.log");
						File log = new File("latest_log.log");
			            logger.write("The game crashed because difficulty is lower than expected" + "\n");
			            logger.close();
					}
					catch (IOException exp) {}
				   JOptionPane.showMessageDialog(null, "Игра вылетела потому что введённая сложность ниже 1!", rez, 0);
				}
				if((dif>7))
				{
					try
					{
						FileWriter logger = new FileWriter("latest_log.log");
						File log = new File("latest_log.log");
			            logger.write("The game crashed because difficulty was higher than expected" + "\n");
			            logger.close();
					}
					catch (IOException exp) {}
				   JOptionPane.showMessageDialog(null, "Игра вылетела потому что введённая сложность выше 7!", rez, 0);
				}
				
				if((dif>=1)&&(dif<=7))
				{
					try
					{
						FileWriter logger = new FileWriter("latest_log.log");
						File log = new File("latest_log.log");
			            logger.write("The window was created" + "\n");
			            logger.close();
					}
					catch (IOException exp) {}
					new window(dif);
				}
		

	}


}
