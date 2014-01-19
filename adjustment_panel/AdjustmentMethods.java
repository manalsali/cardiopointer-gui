package adjustment_panel;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdjustmentMethods {

	public static void captureModel() {
		generateImage("Heart Model");
	}
	
	public static void captureCrossSection() {
		generateImage("Cross Section");
	}
	
	public static void resetModel() {
		JOptionPane.showMessageDialog(null, "Model Reset Successful", "Model Reset", JOptionPane.INFORMATION_MESSAGE);
		// IMPLEMENT RESETTING OF MODEL
	}
	
	public static void getHeartModelCapture() {
		//GET HEART MODEL, WILL NEED TO RETURN SOMETHING 
	}
	
	public static void getCrossSectionCapture() {
		// GET MODEL, WILL NEED TO RETURN SOMETHING
	}
	
	public static void generateImage(String type) {
		JFrame tempPreview = new JFrame(type);
		// CAPTURE HEART MODEL HERE
		tempPreview.setSize(300,300);
		tempPreview.setVisible(true);
		tempPreview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int option = JOptionPane.showConfirmDialog(null,
		        "Do you wish to save?", type + " Captured", JOptionPane.YES_NO_OPTION);
		
		if(option==JOptionPane.YES_OPTION) {
			// save it, IMPLEMENT
			tempPreview.setVisible(false);
			tempPreview.dispose();
		} else {
			tempPreview.setVisible(false);
			tempPreview.dispose();
		}
		
	}
}
