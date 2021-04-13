import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile extends Sprite {

	private final int MISSILE_SPEED = 2;
	int dx = 1, dy = 1;
	boolean w;

	public Missile(int x, int y, boolean s) {
		super(x, y);
		w=s;
		loadImage("C:\\Users\\손정민\\Desktop\\학교\\3-1\\JAVA\\2주차\\src\\missile.png"); 
	}

	public void move() {
		if(w) {
			y -= MISSILE_SPEED;
			if (y < 0) {
				visible = false;
			}
		}
		else {
			y += MISSILE_SPEED;
			if (y > 850) {
				visible = false;
			}
		}
		
	}
}