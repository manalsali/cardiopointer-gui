package opengl;


import static org.lwjgl.opengl.GL11.GL_COLOR_ARRAY;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColorPointer;
import static org.lwjgl.opengl.GL11.glDisableClientState;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnableClientState;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertexPointer;
import static org.lwjgl.opengl.GL11.glViewport;
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
import org.lwjgl.util.vector.Vector3f;


/**
 * All OpenGL tasks relating to creating, translating and rendering handled here.
 *
 */

public class PrototypeGLContext extends Application {
	
	int vertexHandle; // vertexbuffer
	int colorHandle; //color buffer
	
	FloatBuffer projBuffer;
	FloatBuffer viewBuffer;
	Shader shaderProgram;
	
	//FPCam fpCam;
	//boolean rotations = false;
	
	Camera camera;
	
	
	public void Initialise()
	{

		camera = new Camera(45, (float) Display.getWidth() / (float) Display.getHeight(), 0.1f, 100f);
        camera.setPosition(new Vector3f(0, 0, -3));
		
//		fpCam = new FPCam(0, 0, 0);
		
		glMatrixMode(GL_PROJECTION);
		
		// 3D shape has a more realistic look with Perspective mode rather than Orthographic
	//	gluPerspective(70f, 800f/600f, 1, 10);
		
		// render to the full size of the window
		glViewport(0,0,Display.getWidth(), Display.getHeight());
		
		glMatrixMode(GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		glEnable(GL_DEPTH_TEST);
	
		glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
   
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(3*24);
        vertexBuffer.put(new float[]
        {
            
            -0.5f,  0.5f,  0.5f,
             0.5f,  0.5f,  0.5f,
            -0.5f, -0.5f,  0.5f,
             0.5f, -0.5f,  0.5f,

          
             0.5f,  0.5f,  0.5f,
             0.5f,  0.5f, -0.5f,
             0.5f, -0.5f,  0.5f,
             0.5f, -0.5f, -0.5f,
            
      
             0.5f,  0.5f, -0.5f,
            -0.5f,  0.5f, -0.5f,
             0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,
            
        
            -0.5f,  0.5f, -0.5f,
            -0.5f,  0.5f,  0.5f,
            -0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f,  0.5f,
            
    
            -0.5f,  0.5f,  0.5f,
             0.5f,  0.5f,  0.5f,
            -0.5f,  0.5f, -0.5f,
             0.5f,  0.5f, -0.5f,
            

            -0.5f, -0.5f,  0.5f,
             0.5f, -0.5f,  0.5f,
            -0.5f, -0.5f, -0.5f,
             0.5f, -0.5f, -0.5f,
        });
        
         // set the pointer back to the start of buffer
        vertexBuffer.rewind();  // set the pointer back to the start of buffer
        
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
        
        shaderProgram = new Shader();
        shaderProgram.attachVertexShader("src/opengl/shader.vert");
        shaderProgram.attachFragmentShader("src/opengl/shader.frag");
        shaderProgram.link();
        
        // move the camera back in the z axis ( cube centre is drawn around origin)
        //glTranslatef(0, 0, -3); 
        
	}
	// method called 60 times per second
	public void render()
	{
		
		camera.apply();
		shaderProgram.bind();
		
		shaderProgram.setUniform("projection", camera.getProjectionMatrix());
		shaderProgram.setUniform("view", camera.getViewMatrix());
		
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
        //rotation controlled by motion control device
        
        glBindBuffer(GL_ARRAY_BUFFER, vertexHandle);
        glVertexPointer(3, GL_FLOAT, 0, 0);
        
        glBindBuffer(GL_ARRAY_BUFFER, colorHandle);
        glColorPointer(3, GL_FLOAT, 0, 0);
       
        glDrawArrays(GL_TRIANGLE_STRIP, 0, 24);
        
        Shader.unbind();
       
	}
	
	public void destroy()
	{
		// free memory taken up in the GPU
		 glDeleteBuffers(vertexHandle);
	     glDeleteBuffers(colorHandle);
	     glDisableClientState(GL_VERTEX_ARRAY);
	     glDisableClientState(GL_COLOR_ARRAY);
	}
	
	public void update() {
		
		
		boolean up = Keyboard.isKeyDown(Keyboard.KEY_UP);
		boolean down = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		boolean left = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
		boolean right = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);

		// Look up
	    if (up)
	        camera.addRotation(-1f, 0, 0);

	    // Look down
	    if (down)
	        camera.addRotation(1f, 0, 0);

	    // Turn left
	    if (left)
	        camera.addRotation(0, -.1f, 0);

	    // Turn right
	    if (right)
	        camera.addRotation(0, .1f, 0);

	    // Move front
	    if (Keyboard.isKeyDown(Keyboard.KEY_W))
	        camera.move(0.01f, 1);

	    // Move back
	    if (Keyboard.isKeyDown(Keyboard.KEY_S))
	        camera.move(-0.1f, 1);

	    // Strafe left
	    if (Keyboard.isKeyDown(Keyboard.KEY_A))
	        camera.move(0.1f, 0);

	    // Strafe right
	    if (Keyboard.isKeyDown(Keyboard.KEY_D))
	        camera.move(-0.1f, 0);
		
		
			
	/**	if (forward)
			fpCam.move(0.01f, 1);
		if (backward)
			fpCam.move(-0.01f, 1);
		if (left)
			fpCam.move(-0.01f, 0);
		if (right)
			fpCam.move(0.01f, 0);

		if (forward && right)
			GL11.glRotatef(45, 0, 1, 0);

		if (forward && left)
			GL11.glRotatef(45, 0, 1, 0);

		GL11.glLoadIdentity();
		fpCam.lookThrough(); **/
	}
	
}
