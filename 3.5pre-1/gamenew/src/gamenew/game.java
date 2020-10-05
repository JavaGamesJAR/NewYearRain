package gamenew;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class game 
{

	


	public static void main(String[] args) throws IOException
	{

		int dif=0;
		
		File log = new File("starting.log");
		FileWriter logger = new FileWriter(log);
		
		logger.write("The game was launched"+"\n");
		
		//Localization strings
		
		String difask=null;
		String lowcrash=null;
		String highcrash=null;
		
		logger.write("Localization strings created"+"\n");
		

		
		//reading from .lang files
		
		//difask

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\difask.lang"))) 
		{
		    difask = reader.readLine();
		}
		
		//lowcrash

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\lowcrash.lang"))) 
		{
		    lowcrash = reader.readLine();
		}
		
		//highcrash

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\highcrash.lang"))) 
		{
		    highcrash = reader.readLine();
		}
		
		logger.write("The localization files were read"+"\n");
		
			System.out.println("The game was launched");


		        System.out.println("The difficulty asking window appeared");
		        logger.write("The difficulty asking window appeared"+"\n");
				String rez = JOptionPane.showInputDialog(null,
						difask, 1);
		
					System.out.println("The difficulty asking window disappeared");
					logger.write("The difficulty asking window disappeared"+"\n");

				
				dif = rez.charAt(0)-'0';
				System.out.println("The game difficulty was set to " + dif);
				logger.write("The game difficulty was set to "+dif+"\n");

				
				if((dif<1))
				{
					System.out.println("The game crashed because difficulty is lower than expected");
				   JOptionPane.showMessageDialog(null, lowcrash, rez, 0);
				   logger.write("The game crashed because difficulty is lower than expected"+"\n");
					logger.close();
				}
				if((dif>7))
				{
					System.out.println("The game crashed because difficulty is higher than expected");
				   JOptionPane.showMessageDialog(null, highcrash, rez, 0);
				   logger.write("The game crashed because difficulty is higher than expected"+"\n");
					logger.close();
				}
				
				if((dif>=1)&&(dif<=7))
				{
					new window(dif);
					System.out.println("The window was created");
					logger.write("The window was created"+"\n");
					logger.close();
				}
		

	}


}
