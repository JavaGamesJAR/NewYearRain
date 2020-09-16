package gamenew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame 
{

	
   private field gameF;
   
	private class myKey implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			int key_ = arg0.getKeyCode();
			
			
			//System.out.println(key_);
			
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
	
	public window(int dif)
	{
	addKeyListener(new myKey());
	setFocusable(true);
	
	setBounds(0,0,800,600);
	setTitle("Новогодний дождь");
	
	gameF = new field(dif);
	Container cont = getContentPane();
	cont.add(gameF);
	
	setVisible(true);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
