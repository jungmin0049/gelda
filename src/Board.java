import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, KeyListener {

	private Timer timer;
	private Spaceship ship;
	private final int DELAY = 10;
	private int ny, ux, mx;

	public Board() {
		addKeyListener(this);
		setFocusable(true);
		setBackground(Color.BLACK);
		
		ship = new Spaceship(500, 500);
		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if(ship.visible) {
			g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
		}
		
		if( ship.getMissile() != null ) {
			for(Missile m : ship.getMissile() ) {
				g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
		}
		if( ship.getUMissile() != null ) {
			for(Missile m : ship.getUMissile() ) {
				g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
		}
		if( ship.getUfo() != null ) {
			for(ufo u : ship.getUfo() ) {
				g2d.drawImage(u.getImage(), u.getX(), u.getY(), this);
			}
		}
		else
			System.out.println("없음.");
		
		Toolkit.getDefaultToolkit().sync();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ship.move();
		if( ship.getMissile() != null ) {
			for(int i=0; i<ship.getMissile().size();i++) {
				ship.getMissile().get(i).move();
			}
		}
		if( ship.getUMissile() != null ) {
			for(int i=0; i<ship.getUMissile().size();i++) {
				ship.getUMissile().get(i).move();
			}
		}
		if( ship.getUfo() != null ) {
			for(int i=0; i<ship.getUfo().size();i++) {
				ship.getUfo().get(i).move();
			}
			//지금의 y위치를 저장 
			if (ship.getUfo().size() != 0) {
				ny=ship.getUfo().get(0).getY();
				if( ship.getMissile() != null ) {
					for(int i=0; i<ship.getMissile().size();i++) {
						if(ship.getMissile().get(i).getY()>ny && ship.getMissile().get(i).getY()<(ny+80)) {
							for(int j=0; j<ship.getUfo().size();j++) {
								ux=ship.getUfo().get(j).getX();
								mx=ship.getMissile().get(i).getX();
								if(mx>ux && mx<(ux+100)) {
									ship.getUfo().get(j).visible= false;
									ship.getUfo().remove(j);
								}
									
							}
						}
					}
				}
			}
			
		}
		
		
		if( ship.getUMissile() != null ) {
			for(Missile m : ship.getUMissile() ) {
				if(ship.getX()<m.getX()&&ship.getX()>(m.getX()+40)) {
					if(ship.getY()>(m.getY()-30)&&ship.getY()>(m.getY()+40)) {
						ship.visible=false;
					}
				}
			}
		}
		

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ship.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		ship.keyPressed(e);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}