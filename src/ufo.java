import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ufo extends Sprite {

	private int mx=2, my=0;
	private boolean up = true, speed = true;
	int dx, dy=3;

	public ufo(int x) {
		super(x, 100);
		loadImage("C:\\Users\\������\\Desktop\\�б�\\3-1\\JAVA\\2����\\src\\ufo.png"); 
	}

	
	
	public void move() {
		
		x += mx;
		y += my;
		if (speed) {
			my+=1;
			if(my>10) {speed=false;}
		}
		else{
			my-=1;
			if(my<-10) {speed=true;}
		}
		if (x < 0 || x>890) {
			mx=-mx;
		}
	}
}