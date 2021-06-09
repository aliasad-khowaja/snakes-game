package com.game;

import javax.swing.*;

class Collapse extends Thread {
	JLabel snake[];
	
	Collapse(JLabel snake[]) {
		this.snake = snake;
	}
	
	public void run() {
		boolean collapse=false;
		
		while(!collapse)
		{
			int x = snake[0].getX();
			int y = snake[0].getY();
			
			for(int k = 2; k<= Main.body ; k++)
			{
				if(snake[k].getX() == x && snake[k].getY() == y)
				{
					Main.showScore();
					Main.resetSnake();
					collapse = true;
					break;
				}
			}
			
			try{
				Thread.sleep(20);
			}catch(InterruptedException ex){}
			
		}
	}
}
