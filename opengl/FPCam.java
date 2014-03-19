package opengl;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class FPCam {

	private Vector3f eye, rotation;

	private float fov, aspect, near, far;

	public FPCam(float fov, float aspect, float near, float far) {
		eye = new Vector3f(0, 0, 0);
		rotation = new Vector3f(0, 0, 0);
		this.fov = fov;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
		initProjection();
	}

	private void initProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, aspect, near, far);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
	}

	public void useView() {
		GL11.glRotatef(rotation.x, 1, 0, 0);
		GL11.glRotatef(rotation.y, 0, 1, 0);
		GL11.glRotatef(rotation.z, 0, 0, 1);
		GL11.glTranslatef(eye.x, eye.y, eye.z);
	}

	public void move(float amt, float dir) {
		eye.z += amt * Math.sin(Math.toRadians(rotation.y + 90 * dir));
		eye.x += amt * Math.cos(Math.toRadians(rotation.y + 90 * dir));
	}

	public void rotateY(float amt) {
		rotation.y += amt;
	}

	public void rotateX(float amt) {
		rotation.x += amt;
	}

}