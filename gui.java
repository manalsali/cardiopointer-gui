import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class gui extends JFrame {

	JPanel adjustmentPanel;
	JPanel heartPanel;
	JPanel crossSectionPanel;
	JPanel rightSection;
	Container cp;
	JFileChooser jfc;

	public gui() {

		// title
		super("Cardiopointer");

		adjustmentPanel = new JPanel(new GridLayout(2, 1));
		heartPanel = new JPanel();
		crossSectionPanel = new JPanel();
		
		jfc = new JFileChooser();

		// a right panel to hold adjustment and
		rightSection = new JPanel(new GridLayout(2, 1));
		rightSection.add(adjustmentPanel);
		rightSection.add(crossSectionPanel);

		// container where everything is held
		cp = this.getContentPane();
		crossSectionPanel.setSize(400, 300);

		menu();
		initAdjustment();
		init2D();

		// adding the different panels to the container frame
		cp.add(heartPanel, BorderLayout.CENTER);
		cp.add(rightSection, BorderLayout.EAST);

		// basic controls, size etc
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void initAdjustment() {

		JPanel sliderStuff = new JPanel(new GridLayout(3, 2));
		JLabel brightness = new JLabel("Brightness");
		JLabel contrast = new JLabel("Contrast");
		JLabel zoom = new JLabel("Zoom");
		JSlider sliderBrightness = new JSlider(JSlider.HORIZONTAL);
		JSlider sliderContrast = new JSlider(JSlider.HORIZONTAL);
		JSlider sliderZoom = new JSlider(JSlider.HORIZONTAL);

		JPanel buttonsPanel = new JPanel(new FlowLayout());
		JButton captureModel = new JButton("Capture Model");
		captureModel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				captureModel();
			}
			
		});
		JButton captureCrossSection = new JButton("Capture Cross Section");
		captureCrossSection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				captureCrossSection();
			}
			
		});
		JButton resetModel = new JButton("Reset Model");
		resetModel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetModel();
			}
			
		});

		sliderStuff.add(brightness);
		sliderStuff.add(sliderBrightness);
		sliderStuff.add(contrast);
		sliderStuff.add(sliderContrast);
		sliderStuff.add(zoom);
		sliderStuff.add(sliderZoom);
		buttonsPanel.add(captureModel);
		buttonsPanel.add(captureCrossSection);
		buttonsPanel.add(resetModel);

		adjustmentPanel.add(sliderStuff);
		adjustmentPanel.add(buttonsPanel);

		pack();

	}

	public void init2D() {

		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel ecgInner = new JPanel();
		ecgInner.add(new JLabel("ECG PANEL. "));
		tabbedPane.addTab("ECG 2D", ecgInner);
		JPanel mriInner = new JPanel();
		mriInner.add(new JLabel("MRI INNER"));
		tabbedPane.addTab("MRI 2D", mriInner);
		JPanel mergedInner = new JPanel();
		mergedInner.add(new JLabel("merged inner"));
		tabbedPane.addTab("Merged 2D", mergedInner);
		// tabbedPane.setSelectedIndex(0);
		JPanel temp = new JPanel();
		tabbedPane.add(temp);

		crossSectionPanel.setLayout(new GridLayout(1, 1));
		crossSectionPanel.add(tabbedPane);
	}

	// initialise menu
	public void menu() {

		// creates menubar
		JMenuBar menuBar = new JMenuBar();
		// sets menu bar
		this.setJMenuBar(menuBar);

		// file menu
		JMenu menuFile = new JMenu("File");
		JMenu importDICOM = new JMenu("Import DICOM");
		JMenuItem browseECG = new JMenuItem("Import ECG");
		browseECG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openBrowser();
			}
		});

		JMenuItem browseMRI = new JMenuItem("Import MRI");
		browseMRI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openBrowser();
			}
		});
		menuFile.add(importDICOM);
		importDICOM.add(browseECG);
		importDICOM.add(browseMRI);
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}

		});
		menuFile.add(new JSeparator());
		menuFile.add(exit);

		// creating view menu
		JMenu menuView = new JMenu("View");
		JMenuItem resetModel = new JMenuItem("Reset Model");
		resetModel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetModel();
			}
			
		});
		JMenuItem clearModels = new JMenuItem("Clear Models");
		clearModels.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clearModel();
			}
			
		});
		JMenuItem zoomIn = new JMenuItem("Zoom In");
		JMenuItem zoomOut = new JMenuItem("Zoom Out");
		JMenu rotate = new JMenu("Rotate");
		JMenuItem rotate180 = new JMenuItem("180\u00B0");
		JMenuItem rotate90CW = new JMenuItem("90\u00B0 CW");
		JMenuItem rotate90AC = new JMenuItem("90\u00B0 ACW");
		JMenuItem customRotate = new JMenuItem("Custom Rotate");
		customRotate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				customRotate();
			}
			
		});

		menuView.add(resetModel);
		menuView.add(clearModels);
		menuView.add(new JSeparator());
		menuView.add(zoomIn);
		menuView.add(zoomOut);
		menuView.add(new JSeparator());
		menuView.add(rotate);
		rotate.add(rotate180);
		rotate.add(rotate90CW);
		rotate.add(rotate90AC);
		rotate.add(new JSeparator());
		rotate.add(customRotate);
	//	menuView.add(new JSeparator());


		// sub menu item

		// creating tools menu
		JMenu menuTools = new JMenu("Tools");
		JMenuItem enableDevice = new JMenuItem("Enable Leap Motion Device");
		enableDevice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				enableLeap();
			}
			
		});
		JMenuItem disableDevice = new JMenuItem("Disable Leap Motion Device");
		disableDevice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				disableLeap();
			}
			
		});
		// need to allow to be selectable?
		
		JMenuItem merge = new JMenuItem("Merge DICOM");
		JMenuItem captureModel = new JMenuItem("Capture Model");
		captureModel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				captureModel();
			}
			
		});
		JMenuItem captureCrossSection = new JMenuItem("Capture Cross Section");
		captureCrossSection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				captureCrossSection();
			}
		});
		menuTools.add(enableDevice);
		menuTools.add(disableDevice);
		menuTools.add(new JSeparator());
		menuTools.add(merge);
		menuTools.add(new JSeparator());
		menuTools.add(captureModel);
		menuTools.add(captureCrossSection);

		// creating help menu
		JMenu menuHelp = new JMenu("Help");
		JMenuItem documentation = new JMenuItem("Documentation");
		menuHelp.add(documentation);
		documentation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				initDocumentation();
			}
			
		});

		// just added menus to menubar
		menuBar.add(menuFile);
		menuBar.add(menuView);
		menuBar.add(menuTools);
		menuBar.add(menuHelp);
	}

	public void openBrowser() {
		
		jfc.setFileFilter(new FileNameExtensionFilter("DICOM Files", "dcm"));
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			//System.out.println(jfc.getSelectedFile().getName());
			//File dicom = jfc.getSelectedFile();
		} else {
			
		}

	}
	
	public void resetModel() {
		
		// reset model code here
		JOptionPane.showMessageDialog(gui.this, "Model Reset Successful", "Model Reset", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void clearModel() {
		
		// reset model code here
		JOptionPane.showMessageDialog(gui.this, "Model Cleared Successful", "Model Cleared", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void captureModel() {
		
		JFrame tempPreview = new JFrame();
		tempPreview.setSize(300,300);
		tempPreview.setVisible(true);
		tempPreview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int option = JOptionPane.showConfirmDialog(null,
		        "Do you wish to save?", "Model Captured", JOptionPane.YES_NO_OPTION);
		
		if(option==JOptionPane.YES_OPTION) {
			// save it
			tempPreview.setVisible(false);
		} else {
			// do nothing. 
			tempPreview.setVisible(false);
		}
		
	
	}
	
	
	
	public void captureCrossSection() {
		
		JFrame tempPreview = new JFrame();
		tempPreview.setSize(300,300);
		tempPreview.setVisible(true);
		tempPreview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int option = JOptionPane.showConfirmDialog(null,
		        "Do you wish to save?", "Cross-Section Captured", JOptionPane.YES_NO_OPTION);
		
		if(option==JOptionPane.YES_OPTION) {
			// save it
			tempPreview.setVisible(false);
			tempPreview.dispose();
		} else {
			tempPreview.setVisible(false);
			// do nothing. 
			tempPreview.dispose();
		}
		
	}
	
	public void customRotate() {
		final JFrame rotate = new JFrame();
		rotate.setLocationRelativeTo(null);
		rotate.setLayout(new GridLayout(3,2));
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
				// TODO Auto-generated method stub
				
				if(!angleField.getText().isEmpty()) {
					Integer x = Integer.parseInt(angleField.getText());
					String button = bg.getSelection().toString();
					rotate.setVisible(false);
					rotate.dispose();
					customRotateModel(x,button);
				} else {
					
					rotate.setVisible(false);
					rotate.dispose();
					
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DO SOMETHING 
				rotate.setVisible(false);
				rotate.dispose();
				
			}
			
		});
		
		rotate.pack();
		rotate.setVisible(true);
		rotate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void enableLeap() {
		JOptionPane.showMessageDialog(gui.this, "Leap Motion Device Enabled", "Enabled", JOptionPane.INFORMATION_MESSAGE);
		// insert code here to enable leap
	}
	
	public void disableLeap() {
		JOptionPane.showMessageDialog(gui.this, "Leap Motion Device Disabled", "Disabled", JOptionPane.INFORMATION_MESSAGE);
		// insert code here to disable leap
	}
	
	public void customRotateModel(int rotateVal, String direction) {
		// insert code here to rotate the heart 
	}
	
	public void initDocumentation() {
		
		JFrame docSplitPane = new JFrame();
		docSplitPane.setTitle("Documentation");
		JPanel menu = new JPanel();
		JPanel doc = new JPanel();
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menu, doc);
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
		String[] contentList = {"1.0 Introduction", 
				"2.0 Basic Guides",
				"3.0 User Interface",
				"4.0 Additional Hardware and Installation",
				"5.0 Frequently Asked Questions"
		};
		final String[] contentInfo = {"1.0 Introduction", 
				"2.0 Basic Guides",
				"3.0 User Interface",
				"4.0 Additional Hardware and Installation",
				"Frequently Asked Questions"
		};
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
		docSplitPane.setSize(500,300);
		docSplitPane.setVisible(true);
		docSplitPane.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		
	}
	
	public static void main(String[] args) {

		// in the case that user is using MAC OS, uses native menu features
		// System.setProperty("apple.laf.useScreenMenuBar", "true");

		// thread safe way to run it
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new gui();
			}
		});

	}

}
