package animation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ReboundPanel extends JPanel{
	
	private final int WIDTH = 500, HEIGHT = 300;
	private final int DELAY = 20, IMAGE_SIZE = 0;
	
	private ImageIcon image;
	private Timer timer;
	/**
	 * Timer class
	 *  - Part of the swing package
	 *  - No visual representation, but can be thought of as a component
	 *  - Has many methods than can help aid with "animation"
	 *  - ActionListener moves images, by repainting over and over again
	 *  
	 */
	
	private int x, y, moveX, moveY;
	
	public ReboundPanel() {
		
		timer = new Timer(DELAY, new ReboundListener());
		image = new ImageIcon("microsoftLogo.png");
		
		x = y = 0;
		moveX = moveY = 3;
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		timer.start();
		
	}
	
	public void paintComponent(Graphics p) {
		super.paintComponent(p);
		image.paintIcon(this, p, x, y);
	}
	

	private class ReboundListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			x += moveX;
			y += moveY;
			
			if(x <= 0 || x >= WIDTH-IMAGE_SIZE) {
				moveX = moveX * -1;
			}
			
			if(y <= 0 || y >= HEIGHT-IMAGE_SIZE) {
				moveY = moveY * -1;
			}
			
			repaint();
			
		}
		
	}
	
}
