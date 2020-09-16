package gamenew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax. imageio.*;

public class field extends JPanel implements ComponentListener
{
	private Image fon, shapka, end_game;
	public int x = 400, y, dif;
	public gift[] gameGift;
	public Timer timerUpdate, timerDraw;
	int recordcount = 0;
	private int hatHeight, hatWidth, fieldHeight, fieldWidth;
	
  public field(int dif)
  {
	  addComponentListener(this);
	  
	  fieldWidth = 800;
	  fieldHeight = 600;
	  y = 465;
	  
	  //Redraws everything! (Hat,gifts,record, etc)
	  
	  timerDraw = new Timer(50, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		repaint();	
		}
	});
	  timerDraw.start();
	  timerUpdate = new Timer(2000, new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent arg0) {
		updateStart();	
		}
	});
	  timerUpdate.start();
	  this.dif = dif;
	  try
	  {
		  fon = ImageIO.read(new File("img/fon.png"));
	  }
	  catch(IOException exp){}
	  
	  try
	  {
		  shapka = ImageIO.read(new File("img\\shapka.png"));
		  hatHeight = shapka.getHeight(null);
		  hatWidth=shapka.getWidth(null);
	  }
	  catch(IOException exp){}
	  
		try
		{
			end_game = ImageIO.read(new File("img\\end_game.png"));
		}
		catch(IOException exp){}
		
		gameGift = new gift[7];
		
		for(int i=0; i<7; i++)
			
		{
			try
			{
				gameGift[i] = new gift(ImageIO.read(new File("img\\p"+i+".png")));
			}
			catch(IOException exp){}		
		}
  }
  
public void paintComponent(Graphics gr)
  {
	  
	  super.paintComponent(gr);
	  gr.drawImage(fon, 0, 0, fieldWidth, fieldHeight, null);
	  drawHat(gr);
	  
	  Drawrecord(gr);
	  
		for(int i=0; i<7; i++)
		{
			gameGift[i].fieldHeight = fieldHeight;
			gameGift[i].fieldWidth = fieldWidth;
			gameGift[i].hatHeight = hatHeight;
			gameGift[i].draw(gr);
			
			if(gameGift[i].act)
			{
				if((gameGift[i].y+gameGift[i].img.getHeight(null))>=Math.abs(fieldHeight-hatHeight-10))
				{
					if(Math.abs(gameGift[i].x-x)>75)
					{
						gr.drawImage(end_game, 300, 300, null);
						timerDraw.stop();
						timerUpdate.stop();
						break;
					}
					else gameGift[i].act = false;
					recordcount+=1;
				}
			}
			
		}
	  
  }
  public void updateStart()
  {
	  int count=0;
	  for (int i=0;i<7;i++)
	  {
		  if (gameGift[i].act==false)
		  {
			  if (count<dif)
			  {
				  gameGift[i].start();
				  break;
			  }
		  }
		  else count++;
	  }
  }
  private void Drawrecord(Graphics gr)
  {
	  gr.setColor(Color.RED);
	  Font font = new Font("Arial",Font.BOLD,15);
	  gr.setFont(font);
	  gr.drawString("Ñ÷¸ò: "+recordcount, 0, 15);
			  
  }
  
  public void moveHatLeft()
  {
	  if(x-30>-48) x-=30;
	  else x = fieldWidth-48;
  }
  public void moveHatRight()
  {
	  if (x+30<fieldWidth-48) x+=30;
	  else x = -48;
  }
  public void drawHat(Graphics gr)
  {
	  gr.drawImage(shapka, x, y, null);
  }
@Override
public void componentHidden(ComponentEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void componentMoved(ComponentEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void componentResized(ComponentEvent arg0) {
	// TODO Auto-generated method stub
	setSizeBackgr(getSize());
	setSizeHat (getSize());
	setSizeGift(getSize());
}
@Override
public void componentShown(ComponentEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void setSizeBackgr (Dimension d)
{
	fieldHeight = d.height;
	fieldWidth = d.width;
}
public void setSizeHat(Dimension d)
{
	y = d.height - hatHeight - 5;
	x = d.width/2;
	fieldHeight = d.height;
	fieldWidth = d.width;
}

public void setSizeGift (Dimension d)
{
	for(int i=0; i<7; i++)
	{
		if (gameGift[i].act)
		{
			if(gameGift[i].x+gameGift[i].img.getWidth(null)>d.width)
			{
				gameGift[i].x = d.width - gameGift[i].img.getWidth(null);
			}
		}
	}
}
}

