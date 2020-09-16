package gamenew;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import gamenew.game;
import gamenew.field;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class window extends JFrame 
{
	
	
	private class myKey implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			int key_ = arg0.getKeyCode();
			
			
			System.out.println(key_);
			
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
				break;
				
			case 39:
			gameF.moveHatRight();
				break;
				
			case 82:
				
                dispose();
				
				
				int dif = 0;
				String rez = JOptionPane.showInputDialog(null,
						"ведите сложность игры от 1 до 7", 1);
				
				dif = rez.charAt(0)-'0';
				if((dif<1))
				{
				   JOptionPane.showMessageDialog(null, "Игра вылетела потому что введённая сложность ниже 1!", rez, 0);
				}
				if((dif>7))
				{
				   JOptionPane.showMessageDialog(null, "Игра вылетела потому что введённая сложность выше 7!", rez, 0);
				}
				
				if((dif>=1)&&(dif<=7))
				{
					new window(dif);
				}
				break;
			
			default: JOptionPane.showMessageDialog(null, "Клавиша не работает");
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
		
		int windwid;
		windwid = getWidth();

		
	addKeyListener(new myKey());
	setFocusable(true);
	
	setBounds(0,0,800,600);
	setTitle("Новогодний дождь");
	setIconImage(Toolkit.getDefaultToolkit().getImage("img\\shapka.png"));
	
	gameF = new field(dif);
	Container cont = getContentPane();
	cont.add(gameF);
	  JButton btnrestart = new JButton("Начать заново");
	  btnrestart.addActionListener(new ActionListener()
	  {  
			public void actionPerformed(ActionEvent arg0) 
			{
                dispose();
				
				
				int dif = 0;
				String rez = JOptionPane.showInputDialog(null,
						"ведите сложность игры от 1 до 7", 1);
				
				dif = rez.charAt(0)-'0';
				if((dif<1))
				{
				   JOptionPane.showMessageDialog(null, "Игра вылетела потому что введённая сложность ниже 1!", rez, 0);
				}
				if((dif>7))
				{
				   JOptionPane.showMessageDialog(null, "Игра вылетела потому что введённая сложность выше 7", rez, 0);
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
