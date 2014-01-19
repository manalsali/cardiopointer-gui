package cross_section_panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrossSectionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("generate2D")) {
			CrossSectionHelperMethods.generate2D();
		}
	}
}
