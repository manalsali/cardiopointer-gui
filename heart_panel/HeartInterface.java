package heart_panel;

/*
 * will contain information regarding the 3d heart model
 */

import java.awt.Canvas;
import java.awt.GridLayout;

import javax.swing.JPanel;

import opengl.PrototypeGLContext;

public class HeartInterface extends JPanel {

	public static Canvas canvas;

	public HeartInterface() {
		Thread t = new Thread() {
			public void run() {
				startDisplay();
			}
		};

		t.start();
	}

	public void startDisplay() {

		try {
			canvas = new Canvas() {

				public final void addNotify() {
					super.addNotify();
					new PrototypeGLContext();
				}

				public final void removeNotify() {
					super.removeNotify();
				}
			};

			canvas.setSize(800, 600);
			this.setLayout(new GridLayout(1, 1));
			this.add(canvas);
			canvas.setFocusable(true);
			canvas.requestFocus();
			canvas.setIgnoreRepaint(true);
			this.setVisible(true);
			
		} catch (Exception e) {
			System.err.println(e);
			throw new RuntimeException("unable to create display");
		}

	}
}