package opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class FinalCamera {
	
	Vector3f eye, rotation;
	
	private float fieldOfView,aspectRatio,nearClip,farClip;
	
	private float yaw, roll, pitch; 
	
	public FinalCamera(float fieldOfView, float aspectRatio, float nearClip,
			float farClip) {
		
		yaw = 0;
		roll = 0;
		pitch = 0;
		
		eye = new Vector3f(0,0,0); // camera
		rotation = new Vector3f(0,0,0);
		
		this.fieldOfView = fieldOfView;
		this.aspectRatio = aspectRatio;
		this.nearClip = nearClip;
		this.farClip = farClip;
		initialiseProjection();
	}

	private void initialiseProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fieldOfView, aspectRatio, nearClip, farClip);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
	}
	
	public void useView() {
		glRotatef(pitch, 1, 0, 0);
		glRotatef(yaw, 0, 1, 0);
		glRotatef(roll, 0,0,1);
		glTranslatef(eye.x, eye.y, eye.z);
		//gluLookAt(eye.x, eye.y, eye.z, center.x, center.y, center.z, up.x, up.y, up.z);
	}

	public void move(float amt, float dir)
	{
	eye.z += amt * Math.sin(Math.toRadians(yaw + 90 * dir));
	eye.x += amt * Math.cos(Math.toRadians(yaw + 90 * dir));
	}

	public void rotateY(float amt)
	{
		yaw += amt;
	}
	
	
/**	private float x;
	private float y;
	private float z;
	private float rotationX;
	private float rotationY;
	private float rotationZ;

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getRotationX() {
		return rotationX;
	}

	public void setRotationX(float rotationX) {
		this.rotationX = rotationX;
	}

	public float getRotationY() {
		return rotationY;
	}

	public void setRotationY(float rotationY) {
		this.rotationY = rotationY;
	}

	public float getRotationZ() {
		return rotationZ;
	}

	public void setRotationZ(float rotationZ) {
		this.rotationZ = rotationZ;
	}

	private float fieldOfView;
	private float aspectRatio;
	private float nearClip;
	private float farClip;

	public FinalCamera(float fieldOfView, float aspectRatio, float nearClip,
			float farClip) {
		x = 0;
		y = 0;
		z = 0;
		this.fieldOfView = fieldOfView;
		this.aspectRatio = aspectRatio;
		this.nearClip = nearClip;
		this.farClip = farClip;
		initialiseProjection();
	}

	private void initialiseProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fieldOfView, aspectRatio, nearClip, farClip);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
	}

	public void useView() {
		glRotatef(rotationX, 1, 0, 0);
		glRotatef(rotationY, 0, 1, 0);
		glRotatef(rotationZ, 0, 0, 1);
		glTranslatef(x, y, z);
	}

	public void move(float amt, float dir) {
		z += amt * Math.sin(Math.toRadians(rotationY + 90 * dir));
		x += amt * Math.cos(Math.toRadians(rotationY + 90 * dir));
	}

	public void rotateY(float amt) {
		rotationY += amt;
	}

	public void rotateX(float amt) {
		rotationX += amt;
	}**/
}