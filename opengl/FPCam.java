package opengl;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class FPCam {

	private Vector3f eye,rotation = null; 

	private float yaw, pitch, roll;

	public FPCam(float x, float y, float z) {
		yaw = 0;
		pitch = 0;
		roll = 0;
		
		eye = new Vector3f(x, y, z);
		rotation = new Vector3f(0, 0, 0);
		
		initProjection();
	}

	private void initProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(70,
				(float) Display.getWidth() / (float) Display.getHeight(), 0.3f,
				1000);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
	}

	// moves the graphic in, out, left, right
	public void move(float amt, int dir) {
		eye.z += amt * Math.sin(Math.toRadians(rotation.y + 90 * dir));
		eye.x += amt * Math.cos(Math.toRadians(rotation.y + 90 * dir));
	}

	public void lookThrough() {
	
		GL11.glRotatef(getPitch(), 1, 0, 0);
		GL11.glRotatef(getYaw(), 0, 1, 0);
		GL11.glRotatef(getRoll(), 0, 0, 1);
		GL11.glTranslatef(eye.x, eye.y, eye.z);
	}
	
	public float getYaw() {
		return yaw;
	}
	
	public float getRoll() {
		return roll;
	}
	
	public float getPitch() {
		return pitch;
	}
	

	

	/**	public void setModelViewMatrix() {
		FloatBuffer m = BufferUtils.createFloatBuffer(16);
		Vector3f eVec = new Vector3f(eye.x, eye.y, eye.z);
		m.put(new float[] { u.x, v.x, n.x, 0, u.y, v.y, n.y, 0, u.z, v.z, n.z,
				0, -Vector3f.dot(eVec, u), -Vector3f.dot(eVec, v),
				-Vector3f.dot(eVec, n), 1 });
		GL11.glMatrixMode(GL_MODELVIEW);
		GL11.glLoadMatrix(m);

	}

	public void slide(float delU, float delV, float delN) {
		eye.x += delU * u.x + delV * v.x + delN * n.x;
		eye.y += delU * u.y + delV * v.y + delN * n.y;
		eye.z += delU * u.z + delV * v.z + delN * n.z;
	}
	**/
}