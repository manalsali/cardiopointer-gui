package main_cardiopointer;

import heart_panel.HeartInterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import menu.MenuInterface;
import cross_section_panel.CrossSectionInterface;

public class Main extends JFrame {

	public Main() {

		super("Cardiopointer");
		this.setJMenuBar(MenuInterface.menuBar);
		new MenuInterface();

		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1,2));
		
		JPanel heartPanel = new JPanel(new GridLayout(1,1));
		heartPanel.add(new HeartInterface());
		JPanel crossSections = new JPanel(new GridLayout(1,1));
		crossSections.add(new CrossSectionInterface());
		cp.add(heartPanel);
		cp.add(crossSections);
		
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {


//		try {
//		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//		        if ("Nimbus".equals(info.getName())) {
//		            UIManager.setLookAndFeel(info.getClassName());
//		            break;
//		        }
//		    }
//		} catch (UnsupportedLookAndFeelException e) {
//		    // handle exception
//		} catch (ClassNotFoundException e) {
//		    // handle exception
//		} catch (InstantiationException e) {
//		    // handle exception
//		} catch (IllegalAccessException e) {
//		    // handle exception
//		}
			
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main();
				// TODO Auto-generated method stub
			}
		});
	}
}