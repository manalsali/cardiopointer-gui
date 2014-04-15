package menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class MenuInterface {

	public static JMenuBar menuBar = new JMenuBar();

	// names of menus, menuitems etc
	static String[] menuNames = { "File", "Edit", "Tools", "Help" };
	String[] fileNames = { "Import DICOM", "s", "Exit" };
	//String[] importNames = { "Import ECG", "Import MRI", "Import CT" };
	String[] editNames = { "Reset Model", "Clear Models", "s",
			"Increase Brightness", "Decrease Brightness", "s", "Increase Contrast", "Decrease Contrast", "s", "Zoom In",
			"Zoom Out", "s", "Rotate" };
	String[] rotateNames = { "90\u00B0 AC", "90\u00B0 ACW", "180\u00B0", "s",
			"Custom" };
	String[] toolsNames = { "Enable Leap Motion Device",
			"Disable Leap Motion Device", "s", "Capture Heart",
			"Capture Y", "Capture X" };
	String[] helpNames = { "Documentation" };

	JMenu menus[];
	JMenuItem fileItems[];
	JMenuItem importItems[];
	JMenuItem editItems[];
	JMenuItem[] rotateItems;
	JMenuItem[] toolsItems;
	JMenuItem[] helpItems;

	ActionListener listener = new MenuListener();

	public MenuInterface() {

		menus = new JMenu[menuNames.length];
		fileItems = new JMenuItem[fileNames.length];
		//importItems = new JMenuItem[importNames.length];
		editItems = new JMenuItem[editNames.length];
		rotateItems = new JMenuItem[rotateNames.length];
		toolsItems = new JMenuItem[toolsNames.length];
		helpItems = new JMenuItem[helpNames.length];

		// initialise menu
		for (int i = 0; i < menuNames.length; i++) {
			menus[i] = new JMenu(menuNames[i]);
			menuBar.add(menus[i]);
		}

		addMenuContents(0, fileNames, fileItems);
		//addSubMenu(fileItems[0], importItems, importNames);
		addMenuContents(1, editNames, editItems);
		addSubMenu(editItems[12], rotateItems, rotateNames);
		addMenuContents(2, toolsNames, toolsItems);
		addMenuContents(3, helpNames, helpItems);

	}

	public void addMenuContents(int menuNumber, String[] itemNames,
			JMenuItem[] menuItem) {

		for (int i = 0; i < itemNames.length; i++) {
			if (itemNames[i].equals("s")) {
				menus[menuNumber].add(new JSeparator());
			} else if (itemNames[i].equals("Rotate")) {
				menuItem[i] = new JMenu(itemNames[i]);
				menus[menuNumber].add(menuItem[i]);
				menuItem[i].setActionCommand(itemNames[i]);
				menuItem[i].addActionListener(listener);
			} 
//			else if (itemNames[i].equals("Import DICOM")) {
////				menuItem[i] = new JMenu(itemNames[i]);
////				menus[menuNumber].add(menuItem[i]);
////				menuItem[i].setActionCommand(itemNames[i]);
////				menuItem[i].addActionListener(listener);
//			}

			else {
				menuItem[i] = new JMenuItem(itemNames[i]);
				menus[menuNumber].add(menuItem[i]);
				menuItem[i].setActionCommand(itemNames[i]);
				menuItem[i].addActionListener(listener);
			}
		}
	}

	public void addSubMenu(JMenuItem menu, JMenuItem[] menuItems,
			String[] itemNames) {

		for (int i = 0; i < itemNames.length; i++) {
			if (itemNames[i].equals("s")) {
				menu.add(new JSeparator());
			} else {
				menuItems[i] = new JMenuItem(itemNames[i]);
				menuItems[i].setActionCommand(itemNames[i]);
				menuItems[i].addActionListener(listener);
				menu.add(menuItems[i]);
			}
		}
	}
}
