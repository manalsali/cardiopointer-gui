package main_cardiopointer;

import heart_panel.HeartInterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import menu.MenuInterface;
import adjustment_panel.AdjustmentInterface;
import cross_section_panel.CrossSectionAdjustment;
import cross_section_panel.CrossSectionInterface;

public class Main extends JFrame {

	public Main() {

		super("Cardiopointer");
		this.setJMenuBar(MenuInterface.menuBar);
		new MenuInterface();

		Container cp = this.getContentPane();
//
//		cp.setLayout(new GridLayout(2,1));
//		
//		
//		// top panel with heart interface
//		JPanel topPanel = new JPanel(new BorderLayout());
//		
//		topPanel.add(new HeartInterface(), BorderLayout.CENTER);
//		topPanel.add(new AdjustmentInterface(), BorderLayout.EAST);
//		
//		JPanel bottomPanel = new JPanel(new GridLayout(1,1));
//		
//		bottomPanel.add(new CrossSectionHost());
		
		
		cp.setLayout(new BorderLayout());
		
		JPanel rightHandPanel = new JPanel(new BorderLayout());
		// add adjustment panel
		rightHandPanel.add(new AdjustmentInterface(), BorderLayout.NORTH);
		new AdjustmentInterface();
		// add cross section interface
		JPanel adjPanel = new JPanel(new BorderLayout());
		adjPanel.add(new CrossSectionAdjustment(), BorderLayout.NORTH);
		adjPanel.add(new CrossSectionInterface(), BorderLayout.CENTER);
		// add cross section panel
		rightHandPanel.add(adjPanel, BorderLayout.CENTER);

		cp.add(new HeartInterface(), BorderLayout.CENTER);
		cp.add(rightHandPanel, BorderLayout.EAST);
//
		
	//	add(topPanel);
	//	add(bottomPanel);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main();
				// TODO Auto-generated method stub
			}
		});
	}
}