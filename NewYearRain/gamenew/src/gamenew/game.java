package gamenew;

import javax.swing.*;

public class game 
{

	
	public static void main(String[] args) 
	{
		int dif=0;
				String rez = JOptionPane.showInputDialog(null,
						"������ ��������� ���� �� 1 �� 7", 1);
				
				dif = rez.charAt(0)-'0';
				
				if((dif>=1)&&(dif<=7))
				{
					new window(dif);
				}
		

	}

}
