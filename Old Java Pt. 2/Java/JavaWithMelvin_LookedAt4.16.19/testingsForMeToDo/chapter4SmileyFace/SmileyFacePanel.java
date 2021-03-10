package chapter4SmileyFace;
import java.awt.*;
import javax.swing.JPanel;

/*
 * Importing needed packages for JPanel
 */

public class SmileyFacePanel extends JPanel {
	
	private final int baseX = 120, baseY = 60;
	
	public SmileyFacePanel() {
		
		setBackground(Color.red);
		setPreferredSize(new Dimension(320, 200));
		setFont(new Font("Times New Roman", Font.ITALIC,16));
	
		
	}
	
	public void paintComponent(Graphics face) {
		/*
		 * I first thought that naming this does not matter,
		 * but in fact it does.
		 * 
		 * It is one of the paint components of JFrame,
		 * it seems here that the paint component is being overridden and drawing on the panel,
		 * 
		 */
		
		super.paintComponent(face);
		
		face.setColor(Color.yellow);
		//face.fillOval(x, y, width, height);
		face.fillOval(baseX, baseY, 80, 80);		//head
		face.fillRect(baseX-5, baseY+20, 90, 30);	//ears
		
		/*
		 * Looks like the images drawn will be on top, so
		 * Head, ears, eyes, pupils, eyebrows, nose, mouth
		 * in that specific order!
		 * 
		 * Will not code all the way through
		 */
		
	}

}
