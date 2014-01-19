package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Import ECG":
			MenuMethods.importECG();
			break;
		case "Import MRI":
			MenuMethods.importMRI();
			break;
		case "Import CT":
			MenuMethods.importCT();
			break;
		case "Exit":
			MenuMethods.exit();
			break;
		case "Reset Model":
			MenuMethods.resetModel();
			break;
		case "Clear Models":
			MenuMethods.clearModels();
			break;
		case "Increase Brightness":
			MenuMethods.increaseBrightness();
			break;
		case "Decrease Brightness":
			MenuMethods.decreaseBrightness();
			break;
		case "Zoom In":
			MenuMethods.zoomIn();
			break;
		case "Zoom Out":
			MenuMethods.zoomOut();
			break;
		case "90\u00B0 AC":
			MenuMethods.rotate90AC();
			break;
		case "90\u00B0 ACW":
			MenuMethods.rotate90ACW();
			break;
		case "180\u00B0":
			MenuMethods.rotate180();
			break;
		case "Custom":
			MenuMethods.rotateCustom();
			break;
		case "Enable Leap Motion Device":
			MenuMethods.enableLeap();
			break;
		case "Disable Leap Motion Device":
			MenuMethods.disableLeap();
			break;
		case "Capture Model":
			MenuMethods.captureModel();
			break;
		case "Capture Cross Section":
			MenuMethods.captureCrossSection();
			break;
		case "Documentation":
			MenuMethods.documentation();
			break;

		}

	}

}
