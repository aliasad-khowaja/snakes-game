package com.game;

import javax.swing.*;
import java.awt.*;

class CountDown extends Thread {
	
	private JLabel bonus;
	private JLabel progress;
	
	CountDown(JLabel bonus,JLabel progress) {
		this.bonus = bonus;
		this.progress = progress;
	}
	
	public void run() {
		
		double x = Math.random()*600 + 50;
		double y = Math.random()*500 + 50;
		
		bonus.setLocation((int)x,(int)y);
		bonus.setVisible(true);
		
		startProgress();
		
		bonus.setLocation(-20,-20);
		bonus.setVisible(false);
	}
	
	private void startProgress() {
		int count=3;
		
		progress.setBounds(700,3,100,10);
		progress.setFont(new Font("arial",Font.BOLD,10));
		progress.setForeground(Color.white);
		progress.setVisible(true);

		while(count>=1) {
			progress.setText(count+"...");
			count--;
			
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
			
		}
		
		progress.setVisible(false);
	}
}
