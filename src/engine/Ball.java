package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends GameObject{
	P1 p1;
	P2 p2;
	public Ball(int x, int y, ID id, double velX, double velY, P1 p1, P2 p2){
		super(x, y, id);
		this.velX = velX;
		this.velY = velY;
		this.p1 = p1;
		this.p2 = p2;
	}
	public void tick() {
		Rectangle ballBounds = new Rectangle(x, y, 10, 10);
		Rectangle P1Bounds = new Rectangle(p1.getX(), p1.getY(), 10, 50);
		Rectangle P2Bounds = new Rectangle(p2.getX(), p2.getY(), 10, 50);
		if(x > Game.WIDTH-20 || x < 0){
			velX *= -1;
		}
		if(y > Game.HEIGHT-40 || y < 0){
			velY *= -1;
		}
		if(ballBounds.intersects(P1Bounds) || ballBounds.intersects(P2Bounds)){
			velX *= -1;
		}
		p2.setY(y);
		x += velX;
		y += velY;
		velX += aX;
		velY += aY;
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(x, y, 10, 10);
	}
}
