package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class P2 extends GameObject{
	public P2(int x, int y, ID id) {
		super(x, y, id);
	}
	public void tick() {
		if(y > Game.HEIGHT-80){
			y = Game.HEIGHT-80;
		}
		if(y < 0){
			y = 0;
		}
		x += velX;
		y += velY;
		velX += aX;
		velY += aY;
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(x, y, 10, 50);
	}
}
