package gamenew;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.*;

import javax. imageio.*;

public class field extends JPanel implements ComponentListener
{
	private Image fon, shapka, end_game, shapka2;
	public int x = 400, y, dif, x2 = 450, y2;
	public gift[] gameGift;
	public Timer timerUpdate, timerDraw;
	int recordcount = 0;
	private int hatHeight, hatWidth, fieldHeight, fieldWidth, hatWidth2, hatHeight2;

	
  public field(int dif)
  {
	  
	  addComponentListener(this);
	  
	  fieldWidth = 800;
	  fieldHeight = 600;
	  y = 465;
	  
	  //Redraws everything! (Hat,gifts,record, etc)
	  
	  timerDraw = new Timer(17, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		repaint();	
		}
	});
	  timerDraw.start();
	  timerUpdate = new Timer(2500, new ActionListener() {
			
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
		  shapka = ImageIO.read(new File("img\\shapka.png")); //Шапка 1
		  hatHeight = shapka.getHeight(null);
		  hatWidth=shapka.getWidth(null);
	  }
	  catch(IOException exp){}
	  
	  try
	  {
		  shapka2 = ImageIO.read(new File("img\\shapka2.png")); //Шапка 2
		  hatHeight2 = shapka2.getHeight(null);
		  hatWidth2=shapka2.getWidth(null);
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
	  drawHat2(gr);
	  
	  Drawrecord(gr);
	  
		for(int i=0; i<7; i++)
		{
			gameGift[i].fieldHeight = fieldHeight;
			gameGift[i].fieldWidth = fieldWidth;
			gameGift[i].hatHeight = hatHeight;
			gameGift[i].hatHeight2 = hatHeight2;
			gameGift[i].draw(gr);
			

			
			if(gameGift[i].act)
			{
				if((gameGift[i].y+gameGift[i].img.getHeight(null))>=Math.abs(fieldHeight-hatHeight-10) || (gameGift[i].y+gameGift[i].img.getHeight(null))>=Math.abs(fieldHeight-hatHeight2-10))
				{
					if(Math.abs(gameGift[i].x-x)>75)
					{
						gr.drawImage(end_game, fieldWidth/2-120, fieldHeight/2-19, null);
						timerDraw.stop();
						timerUpdate.stop();
						break;
					}
					else 
					{
						gameGift[i].act = false;
					    window.play = false;
						
					}
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
	  String points = null;
	  
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("localization\\points.lang"))) 
		{
		    points = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  gr.setColor(Color.RED);
	  Font font = new Font("Arial",Font.BOLD,15);
	  gr.setFont(font);
	  gr.drawString(points+": "+recordcount, 0, 15);
			  
  }
  
  public void moveHatLeft()
  {
	  if(x-30>-48) x-=10;
	  else x = fieldWidth-48;
  }
  public void moveHatRight()
  {
	  if (x+30<fieldWidth-48) x+=10;
	  else x = -48;
  }
  public void drawHat(Graphics gr)
  {
	  gr.drawImage(shapka, x, y, null);
  }
  
  
  public void moveHatLeft2()
  {
	  if(x2-30>-48) x2-=10;
	  else x2 = fieldWidth-48;
  }
  public void moveHatRight2()
  {
	  if (x2+30<fieldWidth-48) x2+=10;
	  else x2 = -48;
  }
  public void drawHat2(Graphics gr)
  {
	  gr.drawImage(shapka2, x2, y2, null);
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

public void setSizeHat2(Dimension d)
{
	y = d.height - hatHeight2 - 5;
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
	;

/*
JButton multi = new JButton("MultiPlayer");
multi.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("Vasya");
		
	}
});
multi.setBounds(100, 100, 121, 23);
window.gameF.add(multi);*/

}
}

