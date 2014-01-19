package cross_section_panel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class CrossSectionAdjustment extends JPanel{

	String[] radioButtonNames = {"Axial", "Coronal"};
	JRadioButton[] radioButtons;
	ButtonGroup buttonGroup;
	JButton generate2D;
	JSlider xySlider;
	
	
	
	public CrossSectionAdjustment() {
		
		ActionListener listener = new CrossSectionListener();
		
		setLayout(new FlowLayout());
		
		radioButtons = new JRadioButton[radioButtonNames.length];
		buttonGroup = new ButtonGroup();
		generate2D = new JButton("Generate");
		generate2D.setActionCommand("generate2D");
		generate2D.addActionListener(listener);
		xySlider = new JSlider();
		
		add(new JLabel("Cross-Section: "));
		for(int i = 0; i < radioButtons.length; i++) {
			radioButtons[i] = new JRadioButton(radioButtonNames[i]);
			buttonGroup.add(radioButtons[i]);
			add(radioButtons[i]);
		}
		
		radioButtons[0].setSelected(true);
		add(new JLabel("x/y"));
		add(xySlider);
		add(generate2D);
		
	}

}
