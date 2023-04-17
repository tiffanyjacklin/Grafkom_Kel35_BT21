package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Star extends Object {

    List<Integer> index;
    int ibo;

    //index buffer object || element buffer object

    public Star(List<ShaderModuleData> shaderModuleDataList, Vector4f color, List<Integer> index, double titikPusatx, double titikPusaty,
                double jari2, double sudut) {
        super(shaderModuleDataList);

        this.vertices = new ArrayList<>();
        createCircle(titikPusatx, titikPusaty,jari2 , sudut);
        setupVAOVBO();

        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");

        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }

    public void createCircle(double titikpusatx, double titikpusaty,double jari2, double sudut) {
        for (double i = sudut; i < 360+sudut; i += 360/5) {
            float x = (float) (titikpusatx + (jari2 * Math.round(Math.cos(Math.toRadians(i)) * 100) / 100));
            float y = (float) (titikpusaty + (jari2 * Math.round(Math.sin(Math.toRadians(i)) * 100) / 100));
            vertices.add(new Vector3f(x, y, 0.0f));
        }
    }

    public void draw(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(2); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);

        glDrawElements(GL_LINE_LOOP,
                index.size(),GL_UNSIGNED_INT,0);
    }




}
