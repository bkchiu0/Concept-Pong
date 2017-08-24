package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import engine.GameObject;
import engine.Handler;
import engine.ID;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(GameObject temp : handler.object){
			if(temp.getID() == ID.P1){
				if(key == KeyEvent.VK_W){
					temp.setVelY(-5.0);
				}
				if(key == KeyEvent.VK_S){
					temp.setVelY(5.0);
				}
			}
			/*
			if(temp.getID() == ID.P2){
				if(key == KeyEvent.VK_UP){
					temp.setVelY(-5.0);
				}
				if(key == KeyEvent.VK_DOWN){
					temp.setVelY(5.0);
				}
			}
			*/
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(GameObject temp : handler.object){
			if(temp.getID() == ID.P1){
				if(key == KeyEvent.VK_W){
					temp.setVelY(0.0);
				}
				if(key == KeyEvent.VK_S){
					temp.setVelY(0.0);
				}
			}
			/*
			if(temp.getID() == ID.P2){
				if(key == KeyEvent.VK_UP){
					temp.setVelY(0.0);
				}
				if(key == KeyEvent.VK_DOWN){
					temp.setVelY(0.0);
				}
			}
			*/
		}
	}
}
