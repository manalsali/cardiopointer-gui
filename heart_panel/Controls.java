package heart_panel;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Controls extends JPanel {

	String[] controls = {"Capture Model", "Capture X", "Capture Y", "Reset Heart"};
	JButton[] buttons;
	
	public Controls() {
		ControlsListener listener = new ControlsListener();
		buttons = new JButton[controls.length];
		setLayout(new FlowLayout());
		
		BufferedImage zoomInIm, zoomOutIm;
		ImageIcon zoomInIcon = null;
		ImageIcon zoomOutIcon = null;
		try {
			zoomInIm = ImageIO.read(new File("src/images/zoomin.png"));
			zoomOutIm = ImageIO.read(new File("src/images/zoomout.png"));
			zoomInIcon = new ImageIcon(zoomInIm);
			zoomOutIcon = new ImageIcon(zoomOutIm);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton zoomIn = new JButton(zoomInIcon);
		JButton zoomOut = new JButton(zoomOutIcon);
		
		add(zoomIn);
		add(zoomOut);
		
		for(int i = 0; i < controls.length; i++) {
			buttons[i] = new JButton(controls[i]);
			buttons[i].setActionCommand(controls[i]);
			buttons[i].addActionListener(listener);
			add(buttons[i]);
		}
		
	
		
		
	}

}
