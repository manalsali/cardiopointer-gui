package adjustment_panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class AdjustmentInterface extends JPanel {
	
	JSlider[] sliders;
	JButton[] buttons;
	JLabel[] labels;
	
	String[] buttonNames = {"Capture Model", "Capture Cross Section", "Reset Model"};
	String[] sliderLables = {"Brightness", "Contrast", "Zoom"};

	
	public AdjustmentInterface() {
		
		ActionListener listener = new AdjustmentListener();
		
		JPanel sliderPanel  = new JPanel(new GridLayout(3,2));
		JPanel buttonPanel  = new JPanel(new GridLayout(1,3));
			
		sliders = new JSlider[sliderLables.length];
		buttons = new JButton[buttonNames.length];
		labels = new JLabel[sliderLables.length];
		
		this.setLayout(new BorderLayout());
		
		for(int i = 0; i < 3; i++) {
			
			labels[i] = new JLabel(sliderLables[i]);
			sliders[i] = new JSlider();
			// need to add interactivity in the future
			
			sliderPanel.add(labels[i]);
			sliderPanel.add(sliders[i]);

		}
		
		for(int i = 0; i < buttons.length; i++) {
			
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].setActionCommand(buttonNames[i]);
			buttons[i].addActionListener(listener);
			buttonPanel.add(buttons[i]);
		}
		
		this.add(sliderPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
	
				
	}

}
