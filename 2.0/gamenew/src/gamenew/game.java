package gamenew;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class game 
{

	


	public static void main(String[] args) 
	{

		int dif=0;
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
		

	}


}
