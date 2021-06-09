package com.game;

import javax.swing.*;

class SnakeMoves extends Thread
{
	static JLabel snake[];
	static int k=8 , l=0;
	
	SnakeMoves(JLabel snake[])
	{
		this.snake = snake;
	}
	
	public void run()
	{
		while(true)
		{
			
			check();
			
			int previousX = snake[0].getX();
			int previousY = snake[0].getY();
			
			snake[0].setLocation(previousX+k,previousY+l);		
			
			
			for(int k = 1; k<= Main.body ; k++)
			{
				int x = snake[k].getX();
				int y = snake[k].getY();
				
				
				snake[k].setLocation(previousX,previousY);
				
				previousX = x;
				previousY = y;
			}
			
			try{
				Thread.sleep(40);
			}catch(InterruptedException ex){ex.getMessage();}
			
		}
	}
	
	synchronized void moveRight()
	{
		
		
		if(k!=-8)
		{
			k=8;
			l=0;
		}
		try{
			Thread.sleep(40);
		}catch(InterruptedException ex){}
	}
	
	synchronized void moveLeft()
	{
		
		if(k!=8)
		{
			k=-8;
			l=0;
		}
		try{
			Thread.sleep(40);
		}catch(InterruptedException ex){}
	}
	
	synchronized void moveUp()
	{
		
		if(l!=8)
		{
			k=0;
			l=-8;
		}
		try{
			Thread.sleep(40);
		}catch(InterruptedException ex){}
	}
	
	synchronized void moveDown()
	{
		
		if(l!=-8)
		{
			k=0;
			l=8;
		}
		try{
			Thread.sleep(40);
		}catch(InterruptedException ex){}
	}
	
	private void check()
	{
		if(snake[0].getX() > 750)
			snake[0].setLocation(40,snake[0].getY());
		
		else if(snake[0].getX() < 40)
			snake[0].setLocation(750,snake[0].getY());
		
		else if(snake[0].getY() < 45)
			snake[0].setLocation(snake[0].getX(),550);
		
		else if(snake[0].getY() > 550)
			snake[0].setLocation(snake[0].getX(),45);
	}
}
