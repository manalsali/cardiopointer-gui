package cross_section_panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CrossSectionInterface extends JPanel {

	String[] tabbedNames = { "Merged 2D", "ECG 2D", "MRI 2D" };
	JTabbedPane tabbedPane;
	JPanel panelTabs[];

	public CrossSectionInterface() {

		setLayout(new GridLayout(2,1,5,5));
		add(new y_plane());
		add(new z_plane());
		
		/**tabbedPane = new JTabbedPane();
		panelTabs = new JPanel[tabbedNames.length];

		for (int i = 0; i < panelTabs.length; i++) {
			panelTabs[i] = new JPanel();
			panelTabs[i].add(new JLabel(tabbedNames[i]));
			tabbedPane.addTab(tabbedNames[i], panelTabs[i]);
		}

		setLayout(new GridLayout(1, 1));
		add(tabbedPane); **/
	}
}