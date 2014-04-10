package heart_panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import adjustment_panel.AdjustmentMethods;

public class ControlsListener implements ActionListener{

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("Capture Model")) {
			AdjustmentMethods.captureModel();
		} else if (e.getActionCommand().equals("Capture X")) {
			AdjustmentMethods.captureCrossSection();
		} else if (e.getActionCommand().equals("Reset Model")) {
			AdjustmentMethods.resetModel();
		} else if(e.getActionCommand().equals("Capture Y")) {
			AdjustmentMethods.captureCrossSection();
		}
	}
	
	
	
	
}
