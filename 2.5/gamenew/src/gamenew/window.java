package gamenew;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import gamenew.game;
import gamenew.field;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
			else if(key_ == 37)        //�����
			{
				if(gameF.x-30>-48) gameF.x-=30;
				else gameF.x = 752;
			}
			else if(key_ == 39)        //������
			{
				if(gameF.x+30<752) gameF.x += 30;
				else gameF.x = -48;
			}*/
			
			switch (key_) {
			case 27: System.exit(0);break;

			case 37:
			gameF.moveHatLeft();
				break;
				
			case 39:
			gameF.moveHatRight();
				break;
				
			case 82:
				
                dispose();
				
				
				int dif = 0;
				String rez = JOptionPane.showInputDialog(null,
						"������ ��������� ���� �� 1 �� 7", 1);
				
				dif = rez.charAt(0)-'0';
				if((dif<1))
				{
				   JOptionPane.showMessageDialog(null, "���� �������� ������ ��� �������� ��������� ���� 1!", rez, 0);
				}
				if((dif>7))
				{
				   JOptionPane.showMessageDialog(null, "���� �������� ������ ��� �������� ��������� ���� 7!", rez, 0);
				}
				
				if((dif>=1)&&(dif<=7))
				{
					new window(dif);
				}
				break;
			
			default: JOptionPane.showMessageDialog(null, "������� �� ��������");
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
	setTitle("���������� �����");
	setIconImage(Toolkit.getDefaultToolkit().getImage("img\\shapka.png"));
	
	gameF = new field(dif);
	Container cont = getContentPane();
	cont.add(gameF);
	  JButton btnrestart = new JButton("������ ������");
	  btnrestart.addActionListener(new ActionListener()
	  {  
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					FileWriter logger = new FileWriter("latest_log.log");
					File log = new File("latest_log.log");
		            logger.write("Button 'restart' was pressed" + "\n");
		            logger.close();
				}
				catch (IOException exp) {}
                dispose();
        		try
        		{
        			FileWriter logger = new FileWriter("latest_log.log");
        			File log = new File("latest_log.log");
                    logger.write("The window was closed" + "\n");
                    logger.close();
        		}
        		catch (IOException exp) {}
				
				
				int dif = 0;
				try
				{
					FileWriter logger = new FileWriter("latest_log.log");
					File log = new File("latest_log.log");
		            logger.write("The difficulty asking window appeared" + "\n");
		            logger.close();
				}
				catch (IOException exp) {}
				String rez = JOptionPane.showInputDialog(null,
						"������ ��������� ���� �� 1 �� 7", 1);
				
				dif = rez.charAt(0)-'0';
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
				   JOptionPane.showMessageDialog(null, "���� �������� ������ ��� �������� ��������� ���� 1!", rez, 0);
				}
				if((dif>7))
				{
					try
					{
						FileWriter logger = new FileWriter("latest_log.log");
						File log = new File("latest_log.log");
			            logger.write("The game crashed because difficulty is higher than expected" + "\n");
			            logger.close();
					}
					catch (IOException exp) {}
				   JOptionPane.showMessageDialog(null, "���� �������� ������ ��� �������� ��������� ���� 7", rez, 0);
				}
				
				if((dif>=1)&&(dif<=7))
				{
					new window(dif);
				}
			}                                                    
	  });
	  btnrestart.setBounds(0, 0, 89, 23);
	  gameF.add(btnrestart);

	
	
	setVisible(true);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
