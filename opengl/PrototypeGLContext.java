package opengl;

import static org.lwjgl.opengl.GL11.GL_COLOR_ARRAY;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColorPointer;
import static org.lwjgl.opengl.GL11.glDisableClientState;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertexPointer;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/**
 * All OpenGL tasks relating to creating, translating and rendering handled
 * here.
 * 
 */

public class PrototypeGLContext extends Application {

	int vertexHandle; // vertexbuffer
	int colorHandle; // color buffer

	FPCam camera;

	public void Initialise() {

		camera = new FPCam(45, (float) Display.getWidth() / (float) Display.getHeight(), 0.1f, 100f);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		
		GL11.glViewport(0,0,Display.getWidth(), Display.getHeight());
		
		glEnable(GL_DEPTH_TEST);
		
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);
		   
		        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(3*24);
		        vertexBuffer.put(new float[]
		        {
		            
		            -0.5f, 0.5f, 0.5f,
		             0.5f, 0.5f, 0.5f,
		            -0.5f, -0.5f, 0.5f,
		             0.5f, -0.5f, 0.5f,

		          
		             0.5f, 0.5f, 0.5f,
		             0.5f, 0.5f, -0.5f,
		             0.5f, -0.5f, 0.5f,
		             0.5f, -0.5f, -0.5f,
		            
		      
		             0.5f, 0.5f, -0.5f,
		            -0.5f, 0.5f, -0.5f,
		             0.5f, -0.5f, -0.5f,
		            -0.5f, -0.5f, -0.5f,
		            
		        
		            -0.5f, 0.5f, -0.5f,
		            -0.5f, 0.5f, 0.5f,
		            -0.5f, -0.5f, -0.5f,
		            -0.5f, -0.5f, 0.5f,
		            
		    
		            -0.5f, 0.5f, 0.5f,
		             0.5f, 0.5f, 0.5f,
		            -0.5f, 0.5f, -0.5f,
		             0.5f, 0.5f, -0.5f,
		            

		            -0.5f, -0.5f, 0.5f,
		             0.5f, -0.5f, 0.5f,
		            -0.5f, -0.5f, -0.5f,
		             0.5f, -0.5f, -0.5f,
		        });
		        
		         // set the pointer back to the start of buffer
		        vertexBuffer.rewind(); // set the pointer back to the start of buffer
		        
		        FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(3*24);
		        colorBuffer.put(new float[]
		        {
		            // Front face
		            1, 0, 0,
		            1, 1, 0,
		            1, 0, 1,
		            1, 0, 0,
		            
		            // Right face
		            1, 1, 1,
		            1, 1, 1,
		            1, 1, 1,
		            1, 1, 1,
		            
		            // Back face
		            0, 1, 1,
		            1, 0, 0,
		            0, 1, 0,
		            0, 1, 1,
		            
		            // Left face
		            1, 0, 0,
		            0, 1, 0,
		            0, 0, 1,
		            1, 0, 0,
		            
		            // Top face
		            0, 1, 0,
		            1, 0, 1,
		            1, 0, 1,
		            0, 1, 0,
		            
		            // Bottom face
		            0, 0, 0,
		            1, 0, 0,
		            0, 0, 0,
		            0, 0, 0
		        });
		        colorBuffer.rewind();
		        
		        // Allocate buffer space on the GPU and bind to the vertex and colour buffers created
		        vertexHandle = glGenBuffers();
		        glBindBuffer(GL_ARRAY_BUFFER, vertexHandle);
		        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
		        glBindBuffer(GL_ARRAY_BUFFER, 0);
		   
		        colorHandle = glGenBuffers();
		        glBindBuffer(GL_ARRAY_BUFFER, colorHandle);
		        glBufferData(GL_ARRAY_BUFFER, colorBuffer, GL_STATIC_DRAW);
		        glBindBuffer(GL_ARRAY_BUFFER, 0);

	}

	// method called 60 times per second
	public void render() {

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

		// rotation controlled by motion control device

		glBindBuffer(GL_ARRAY_BUFFER, vertexHandle);
		glVertexPointer(3, GL_FLOAT, 0, 0);

		glBindBuffer(GL_ARRAY_BUFFER, colorHandle);
		glColorPointer(3, GL_FLOAT, 0, 0);

		glDrawArrays(GL_TRIANGLE_STRIP, 0, 24);

	}

	public void destroy() {
		// free memory taken up in the GPU
		glDeleteBuffers(vertexHandle);
		glDeleteBuffers(colorHandle);
		glDisableClientState(GL_VERTEX_ARRAY);
		glDisableClientState(GL_COLOR_ARRAY);
	}

	public void update() {

		boolean forward = Keyboard.isKeyDown(Keyboard.KEY_W);
		boolean backward = Keyboard.isKeyDown(Keyboard.KEY_S);
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_A);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);
		boolean rotateRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
		boolean rotateLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		boolean rotateUp = Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean rotateDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN);

		if(forward)
			camera.move(0.01f,1);
		
		if(backward)
			camera.move(-0.01f,1);
			
		if(left)
			camera.move(0.01f,0);
			
		if(right)
			camera.move(-0.01f,0);

		if(rotateRight)
			camera.rotateY(1f);
			
		if(rotateLeft)
			camera.rotateY(1f);
			
		if(rotateUp)
			camera.rotateX(1f);
			
		if(rotateDown)
			camera.rotateY(1f);
		
		glClear(GL_COLOR_BUFFER_BIT);
		GL11.glLoadIdentity();
		camera.useView();
	}
}