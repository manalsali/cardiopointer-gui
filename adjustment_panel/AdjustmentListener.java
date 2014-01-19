package adjustment_panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdjustmentListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Capture Model")) {
			AdjustmentMethods.captureModel();
		} else if (e.getActionCommand().equals("Capture Cross Section")) {
			AdjustmentMethods.captureCrossSection();
		} else if (e.getActionCommand().equals("Reset Model")) {
			AdjustmentMethods.resetModel();
		}
	}
}
