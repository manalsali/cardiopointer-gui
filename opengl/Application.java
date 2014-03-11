package opengl;

import heart_panel.HeartInterface;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/**
 * 
 * Generic LWJGL Application SuperCLass. contains the boiler plate code for the
 * window. currently, window size is fixed and cannot be resized, but for the
 * purposes of demonstrating the leap motion functionality, it is satisfactory.
 * 
 */
public class Application {
	Thread t;

	public Application() {

		t = new Thread() {
			public void run() {
				try {
					// Display.setDisplayMode(new DisplayMode(700, 500));
					Display.setParent(HeartInterface.canvas);
					Display.setVSyncEnabled(true);
					Display.create();

					begin();

				} catch (LWJGLException e) {
					e.printStackTrace();
					System.exit(-1); // this application is hardware
										// accelerated.
				}

			}
		};

		t.start();
	}

	private void begin() {
		
		Initialise();
		while (!Display.isCloseRequested()) {
			update();
			render();

			Display.update();
			Display.sync(60); // 60 frames per second ( matching monitor refresh
								// rate)
		}
		destroy();
	}

	public void Initialise() {

	}

	public void update() {

	}

	public void render() {

	}

	public void destroy() {
		Display.destroy();
		System.exit(0);
	}
}