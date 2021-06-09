package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame implements KeyListener {
	
	private static Container c;
	static JLabel back = new JLabel(new ImageIcon("./resources/images/background.jpg"));
	private static JLabel snake[] = new JLabel[1000];
	static int body=2;
	static int score=0;
	private static int count=0;
	static JLabel scoreLabel = new JLabel("Score : "+score);
	
	static JLabel bonus = new JLabel(new ImageIcon("./resources/images/bonus.png"));
	static JLabel progress = new JLabel();
	
	private static SnakeMoves movement;
	private static Insect insect;
	private Collapse collapse;
	
	static JLabel yourScore = new JLabel("Your Score : "+score);
	
	Main() {
		setTitle("Snakes");
		setResizable(false);
		setBounds(100,50,800,630);
		c = getContentPane();
		c.setLayout(null);
		
		back.setBounds(0,0,800,600);
		c.add(back);
		
		bonus.setBounds(-20,-20,15,15);
		back.add(bonus);
		back.add(progress);
		
		scoreLabel.setBounds(10,4,200,10);
		scoreLabel.setFont(new Font("arial",Font.BOLD,10));
		scoreLabel.setForeground(Color.white);
		back.add(scoreLabel);
		
		yourScore.setBounds(300,100,400,50);
		yourScore.setFont(new Font("arial",Font.BOLD,30));
		yourScore.setForeground(Color.red);
		back.add(yourScore);
		yourScore.setVisible(false);
		setSnake();
		
		movement = new SnakeMoves(snake);
		movement.start();

		insect = new Insect(snake[0]);
		back.add(insect);
		insect.t.setDaemon(true);
		insect.t.start();
		
		collapse = new Collapse(snake);
		collapse.setDaemon(true);
		collapse.start();
		
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			movement.moveRight();
		
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			movement.moveLeft();
		
		else if(e.getKeyCode() == KeyEvent.VK_UP)
			movement.moveUp();
		
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			movement.moveDown();
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	private static void setSnake() {
		int x = 250;
		int y = 300;
		int counter=0;
		
		for(int k=0 ; k<=body ; k++)
		{
			snake[k] = new JLabel(new ImageIcon("./resources/images/snake.png"));
			snake[k].setBounds(x+counter,y,8,8);
			back.add(snake[k]);
			counter-=8;
		}
	}
	
	static void increaseBody() {
		snake[body+1] = new JLabel(new ImageIcon("./resources/images/snake.png"));
		snake[body+1].setBounds(snake[body].getX()-8,snake[body].getY(),8,8);
		back.add(snake[body+1]);
		body++;
	}
	
	static void increaseScore() {
		score++;
		count++;
		scoreLabel.setText("Score : "+score);
		
		if(count%5==0)
			new CountDown(bonus,progress).start();
	}
	
	static void resetSnake() {
		
		body=2;
		score=0;
		count=0;
		scoreLabel.setText("Score : "+score);
		
		movement.suspend();
		insect.t.suspend();
	}
	
	static void showScore() {
		yourScore.setText("Your Score : "+score);
		yourScore.setVisible(true);
	}
	
	public static void main(String arg[]) {
		new Main().setVisible(true);
	}
}
