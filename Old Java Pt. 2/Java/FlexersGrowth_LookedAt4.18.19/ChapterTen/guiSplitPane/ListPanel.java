package guiSplitPane;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ListPanel extends JPanel {
	
	
	/**
	 * Two fields
	 */
	private JLabel label;
	private JList list;
	
	//constructor takes in JLabel object
	public ListPanel(JLabel imageLabel) {
		
		//this label = imageLabel or the picture that is given
		label = imageLabel;
		
		//an array of strings, file names
		String[] pictures = {"Naruto.jpg",
							 "UIGoku.jpg",
							 "BorutoHD.jpg"};
		
		//list = new JList, a type of component
		list = new JList(pictures);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				/**
				 * If nothing is chosen, show null (nothing)
				 */
				if(list.isSelectionEmpty()) {
					label.setIcon(null);
				}
				else {
					String fileName = (String)list.getSelectedValue();
					ImageIcon image = new ImageIcon(fileName);
					label.setIcon(image);
				}
			}
			
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		add(list);
		
		
		
	}

}
