package heart_panel;

/*
 * will contain information regarding the 3d heart model
 */

import java.awt.BorderLayout;
import java.awt.Canvas;

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
			setLayout(new BorderLayout());
			this.add(canvas, BorderLayout.CENTER);
			// adding the controls to the layout
			this.add(new Controls(), BorderLayout.SOUTH);
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