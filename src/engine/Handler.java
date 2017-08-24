package engine;

import java.awt.Graphics;
import java.util.ArrayList;
import engine.GameObject;

public class Handler {
	ArrayList<GameObject> object = new ArrayList<GameObject>();
	public void tick(){
		for(GameObject tempobj : object){
			tempobj.tick();
		}
	}
	public void render(Graphics g){
		for(GameObject tempobj : object){
			tempobj.render(g);
		}
	}
	public void addObject(GameObject object){
		this.object.add(object);
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
