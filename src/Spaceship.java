import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Spaceship extends Sprite {
    private int dx;
    private int dy;
    private ArrayList<ufo> ufoList;
    private ArrayList<Missile> m;
    private ArrayList<Missile> Um;
    private int i = 0;

    public Spaceship(int x, int y) {
    	super(x, y);
        loadImage("C:\\Users\\손정민\\Desktop\\학교\\3-1\\JAVA\\2주차\\src\\ship.png"); 
        getImageDimensions();
        m= new ArrayList<Missile>();
        Um= new ArrayList<Missile>();
        
        ufoList= new ArrayList<ufo>();
		for(int i = 0;i<5;i++) {
			System.out.println("ufoList 가  추가됨 ");
			ufoList.add(new ufo(200*i));
		}
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public ArrayList<Missile> getMissile() {
        return m;
    }
    
    public ArrayList<Missile> getUMissile() {
        return Um;
    }
    
    public ArrayList<ufo> getUfo() {
        return ufoList;
    }

    public void fire() {
        m.add(new Missile(x, y,true));
    }
    
    public void U_fire(int i) {
        Um.add(new Missile(ufoList.get(i).getX(),ufoList.get(i).getY(),false));
        i+=1;
        if(i>5) {i-=5;}
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
        	fire();U_fire(i);
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
