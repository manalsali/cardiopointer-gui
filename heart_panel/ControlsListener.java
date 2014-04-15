package heart_panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ControlsListener implements ActionListener{

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Capture Heart")) {
			generateImage("Capture Heart");
		} else if (e.getActionCommand().equals("Capture X")) {
			generateImage("Capture X");
		} else if (e.getActionCommand().equals("Reset Heart")) {
			resetModel();
;		} else if(e.getActionCommand().equals("Capture Y")) {
			generateImage("Capture Y");
		}
	}
	
	
	public static void generateImage(String type) {
		JFrame tempPreview = new JFrame(type);
		
		
		tempPreview.setSize(300,300);
		tempPreview.setVisible(true);
		tempPreview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int option = JOptionPane.showConfirmDialog(null,
		        "Do you wish to save?", type + " ", JOptionPane.YES_NO_OPTION);

		if(option==JOptionPane.YES_OPTION) {
			/*
			 * implement a method to capture and save the cross section
			 */
			tempPreview.setVisible(false);
			tempPreview.dispose();
		} else {
			tempPreview.setVisible(false);
			tempPreview.dispose();
		}
		
	}
	
	public static void resetModel() {
		JOptionPane.showMessageDialog(null, "Model Reset Successful", "Heart Reset", JOptionPane.INFORMATION_MESSAGE);
		// IMPLEMENT RESETTING OF MODEL
	}
}
