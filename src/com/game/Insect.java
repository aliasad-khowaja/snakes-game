package com.game;

import javax.swing.*;

class Insect extends JLabel implements Runnable {
	private JLabel insect = new JLabel(new ImageIcon("./resources/images/insect.png"));
	Thread t;
	private JLabel snakeFront;
	
	Insect(JLabel snakeFront) {
		this.snakeFront = snakeFront;
		
		setNewLocation();
		setSize(8,8);
		
		insect.setBounds(0,0,8,8);
		add(insect);
		
		t = new Thread(this,"Insect Thread");
	}
	
	public void run() {
		while(true) {
			
			if(snakeFront.getX() >= getX() && snakeFront.getX() <= getX()+8 && snakeFront.getY() >= getY() && snakeFront.getY() <= getY()+8) {
				setNewLocation();
				Main.increaseBody();
				Main.increaseScore();
			}
			
			else if(snakeFront.getX()+8 >= getX() && snakeFront.getX()+8 <= getX()+8 && snakeFront.getY()+8 >= getY() && snakeFront.getY()+8 <= getY()+8) {
				setNewLocation();
				Main.increaseBody();
				Main.increaseScore();
			}
			
			if(snakeFront.getX() >= Main.bonus.getX() && snakeFront.getX() <= Main.bonus.getX()+15 && snakeFront.getY() >= Main.bonus.getY() && snakeFront.getY() <= Main.bonus.getY()+15) {
				Main.score+=3;
				Main.scoreLabel.setText("Score : "+ Main.score);
				
				Main.bonus.setLocation(-20,-20);
				Main.progress.setVisible(false);
			}
			
			else if(snakeFront.getX()+8 >= Main.bonus.getX() && snakeFront.getX()+8 <= Main.bonus.getX()+15 && snakeFront.getY()+8 >= Main.bonus.getY() && snakeFront.getY()+8 <= Main.bonus.getY()+15) {
				Main.score+=3;
				Main.scoreLabel.setText("Score : "+ Main.score);
				
				Main.bonus.setLocation(-20,-20);
				Main.progress.setVisible(false);

			}
			
			try{
				Thread.sleep(20);
			}catch(InterruptedException ex){ex.getMessage();}
		}
	}
	
	private void setNewLocation() {
		double x = Math.random()*600 + 50;
		double y = Math.random()*500 + 50;
		
		setLocation((int)x,(int)y);
	}
}
