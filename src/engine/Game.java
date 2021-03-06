package engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import engine.Game;
import engine.Handler;
import engine.ID;
import engine.KeyInput;
import engine.P1;
import engine.Window;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 3227335926099444894L;
	public static final int WIDTH = 1920, HEIGHT = 1080;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Asteroids", this);
		
		P1 p1 = new P1(20, HEIGHT/2 - 25, ID.P1);
		P2 p2 = new P2(WIDTH-50, HEIGHT/2 - 25, ID.P2);
		handler.addObject(p1);
		handler.addObject(p2);
		handler.addObject(new Ball(WIDTH/2 + 5, HEIGHT/2 + 5, ID.Ball, 6.0, 5.0, p1, p2));
	}
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountTicks = 60.0;
		double ns = 1000000000 / amountTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta --;
			}
			if(running){
				render();
			}
			frames ++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames ++;
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	public static void main(String[] args){
		new Game();
	}
}
