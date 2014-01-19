package menu;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import adjustment_panel.AdjustmentMethods;

public class MenuMethods {

	static void importECG() {
		importBrowser();
	}

	static void importMRI() {
		importBrowser();
	}

	static void importCT() {
		importBrowser();
	}

	static void exit() {
		System.exit(0);
	}

	static void resetModel() {
		AdjustmentMethods.resetModel();
	}

	static void clearModels() {
		// implement how to clear model
		JOptionPane.showMessageDialog(null, "Model Cleared Successful", "Model Cleared", JOptionPane.INFORMATION_MESSAGE);
	}

	static void increaseBrightness() {

	}

	static void decreaseBrightness() {

	}

	static void increaseContrast() {

	}

	static void decreaseContrast() {

	}

	static void zoomIn() {

	}

	static void zoomOut() {

	}

	static void rotate90AC() {

	}

	static void rotate90ACW() {

	}

	static void rotate180() {

	}

	static void rotateCustom() {
		final JFrame rotate = new JFrame();
		rotate.setLocationRelativeTo(null);
		rotate.setLayout(new GridLayout(3, 2));
		rotate.add(new JLabel("Angle"));
		final JTextField angleField = new JTextField();
		rotate.add(angleField);
		final ButtonGroup bg = new ButtonGroup();
		JRadioButton cw = new JRadioButton("Clockwise");
		JRadioButton anticw = new JRadioButton("Anti-Clockwise");
		bg.add(cw);
		bg.add(anticw);
		cw.setSelected(true);
		rotate.add(cw);
		rotate.add(anticw);
		JButton cancel = new JButton("Cancel");
		JButton ok = new JButton("Rotate");
		rotate.add(cancel);
		rotate.add(ok);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!angleField.getText().isEmpty()) {
					Integer x = Integer.parseInt(angleField.getText());
					String button = bg.getSelection().toString();
					rotate.setVisible(false);
					rotate.dispose();
					customRotateModel(x, button);
				} else {
					// tell them empty
					rotate.setVisible(false);
					rotate.dispose();
				}
			}
		});

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rotate.setVisible(false);
				rotate.dispose();
			}
		});

		rotate.pack();
		rotate.setVisible(true);
		rotate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private static void customRotateModel(Integer rotateValue, String rotateDirection) {
		// IMPLEMENT CUSTOM ROTATION OF HEART MODEL

	}

	static void enableLeap() {
		// implement method to enable leap
		JOptionPane.showMessageDialog(null, "Leap Motion Device Enabled", "Enabled", JOptionPane.INFORMATION_MESSAGE);
	}

	static void disableLeap() {
		// implement method to disable leap
		JOptionPane.showMessageDialog(null, "Leap Motion Device Disabled", "Disabled", JOptionPane.INFORMATION_MESSAGE);
	}

	static void captureModel() {
		AdjustmentMethods.captureModel();
	}

	static void captureCrossSection() {
		AdjustmentMethods.captureCrossSection();
	}

	/*
	 * generates documentation
	 */
	static void documentation() {

		JFrame docSplitPane = new JFrame("Documentation");
		JPanel menu = new JPanel();
		JPanel doc = new JPanel();

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				menu, doc);
		splitPane.setDividerLocation(250);

		// setting background colours
		menu.setBackground(Color.WHITE);
		doc.setBackground(Color.WHITE);

		// documentation things
		// setting the text area panel
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		doc.add(textArea);

		// setting up the menu contents
		String[] contentList = { "1.0 Introduction", "2.0 Basic Guides",
				"3.0 User Interface",
				"4.0 Additional Hardware and Installation",
				"5.0 Frequently Asked Questions" };

		// can add full documentation
		final String[] contentInfo = { "1.0 Introduction", "2.0 Basic Guides",
				"3.0 User Interface",
				"4.0 Additional Hardware and Installation",
				"Frequently Asked Questions" };
		final JList menuList = new JList(contentList);
		menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// aading functionalities to jlist
		menuList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				textArea.setText(contentInfo[menuList.getSelectedIndex()]);
			}

		});

		menu.add(menuList);
		// basic things needed
		docSplitPane.add(splitPane);
		docSplitPane.setSize(500, 300);
		docSplitPane.setVisible(true);
		docSplitPane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	static void importBrowser() {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileNameExtensionFilter("DICOM Files", "dcm"));
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// File dicom = jfc.getSelectedFile();
		}
	}

}