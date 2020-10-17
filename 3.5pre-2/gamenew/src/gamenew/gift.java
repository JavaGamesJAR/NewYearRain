package gamenew;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class gift {

	public Image img; 
	
	public int x,y;
	
	public boolean act;
	
	
	Timer timerUpdate;
	public int fieldWidth, fieldHeight, hatHeight, hatHeight2;
	
	
	public gift(Image img)
	{
		timerUpdate = new Timer(25,new ActionListener() {
	public void actionPerformed(ActionEvent e)	{
		
		//act=window.act;
		down();
		//window.act = act;
		
	}
		});
		
		this.img = img;
		
		act = false;
	}	
		public void start()
		{
			timerUpdate.start();
			y = 0;
			x = (int)(Math.random()*(fieldWidth-img.getWidth(null)));
			act = true;
			act = window.act;
			System.out.println(window.act);
		}
		
		public void down()
		{
			if(act==true)
			{
				y++;
			}
			
			if (y+img.getHeight(null)>=(fieldHeight-hatHeight))
			{
				timerUpdate.stop();
				act = false;
			}
		}
		
		public void draw(Graphics gr)
		{
			if (act==true)
			{
				gr.drawImage(img, x, y, null);
			}
		}
	}
