package gamenew;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import gamenew.field;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class window extends JFrame
{
	
	
	
	
	private class myKey implements KeyListener
	{
		
		

		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			int key_ = arg0.getKeyCode();
			
			
			/**System.out.println(key_);*/
			
			/*if(key_ == 27) System.exit(0);
			else if(key_ == 37)        //влево
			{
				if(gameF.x-30>-48) gameF.x-=30;
				else gameF.x = 752;
			}
			else if(key_ == 39)        //вправо
			{
				if(gameF.x+30<752) gameF.x += 30;
				else gameF.x = -48;
			}*/
			
			switch (key_) {
			case 27: System.exit(0);break;

			case 37:
			gameF.moveHatLeft();
			System.out.println("Key '<-' was pressed");
				break;
				
			case 39:
			gameF.moveHatRight();
			System.out.println("Key '->' was pressed");
				break;
				
			case 82:
				
				System.out.println("Button 'r' was pressed");
				
                dispose();
                
    			System.out.println("The window was closed");
    			
    			//Localization strings
    			
    			String difask=null;
    			String lowcrash=null;
    			String highcrash=null;
    			
    			//reading from .lang files
    			
    			//difask

    			try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\difask.lang"))) 
    			{
    			    difask = reader.readLine();
    			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			//lowcrash

    			try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\lowcrash.lang"))) 
    			{
    			    lowcrash = reader.readLine();
    			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			//highcrash

    			try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\highcrash.lang"))) 
    			{
    			    highcrash = reader.readLine();
    			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				
				int dif = 0;
				
				System.out.println("The difficulty asking window appeared");
				String rez = JOptionPane.showInputDialog(null,
						difask, 1);
				System.out.println("The difficulty asking window disappeared");
				
				dif = rez.charAt(0)-'0';
				System.out.println("The game difficulty was set to " + dif);
				if((dif<1))
				{
					System.out.println("The game crashed because difficulty is lower than expected");
				   JOptionPane.showMessageDialog(null, lowcrash, rez, 0);
				}
				if((dif>7))
				{
					System.out.println("The game crashed because difficulty is higher than expected");
				   JOptionPane.showMessageDialog(null, highcrash, rez, 0);
				}
				
				if((dif>=1)&&(dif<=7))
				{
					System.out.println("The window was created");
					new window(dif);
				}
				break;
			
			default: JOptionPane.showMessageDialog(null, "The key doesn't work!");
				break;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {

			
		}
		
	}

    /*private*/ public field gameF;
	
	public window(int dif)
	{
		
	/*	int windwid;
		windwid = getWidth();*/

		
	addKeyListener(new myKey());
	setFocusable(true);
	
	setBounds(0,0,800,600);
	String title = null;
	try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\restart.lang"))) 
	{
	    title = reader.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	setTitle(title);
	setIconImage(Toolkit.getDefaultToolkit().getImage("img\\shapka.png"));
	
	gameF = new field(dif);
	Container cont = getContentPane();
	cont.add(gameF);
	String restart=null;
	try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\restart.lang"))) 
	{
	    restart = reader.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	  JButton btnrestart = new JButton(restart);
	  btnrestart.addActionListener(new ActionListener()
	  {  
			public void actionPerformed(ActionEvent arg0) 
			{
				
    			//Localization strings
    			
    			String difask=null;
    			String lowcrash=null;
    			String highcrash=null;
    			
    			//reading from .lang files
    			
    			//difask

    			try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\difask.lang"))) 
    			{
    			    difask = reader.readLine();
    			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			//lowcrash

    			try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\lowcrash.lang"))) 
    			{
    			    lowcrash = reader.readLine();
    			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			//highcrash

    			try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\highcrash.lang"))) 
    			{
    			    highcrash = reader.readLine();
    			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

					System.out.println("Button 'restart' was pressed");

                dispose();

        			System.out.println("The window was closed");
				
				
				int dif = 0;
				System.out.println("The difficulty asking window appeared");
				String rez = JOptionPane.showInputDialog(null,
						difask, 1);
				System.out.println("The difficulty asking window disappeared");
				
				dif = rez.charAt(0)-'0';
				System.out.println("The game difficulty was set to " + dif);
				if((dif<1))
				{
					System.out.println("The game crashed because difficulty is lower than expected");
					
				   JOptionPane.showMessageDialog(null, lowcrash, rez, 0);
				}
				if((dif>7))
				{

						System.out.println("The game crashed because difficilty is higher than expected");

				   JOptionPane.showMessageDialog(null, highcrash, rez, 0);
				}
				
				if((dif>=1)&&(dif<=7))
				{
					new window(dif);
					System.out.println("The window was created");
				}
			}                                                    
	  });
	  btnrestart.setBounds(0, 0, 89, 23);
	  gameF.add(btnrestart);

	
	
	setVisible(true);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
