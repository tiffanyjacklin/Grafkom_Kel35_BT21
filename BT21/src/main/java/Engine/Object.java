package Engine;

import org.joml.Matrix4d;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object extends ShaderProgram{

    public List<Vector3f> vertices;
    int vao;
    int vbo;
    List<Vector3f> verticesBezier;
    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;
    public Matrix4f model;

    List<Object> childObject;

    float degrees, height;
    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }


    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();

    }

    //with vertice color
    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();
        model = new Matrix4f().identity();
        childObject = new ArrayList<>();
    }

    public Object(List<ShaderModuleData> shaderModuleDataList) {
        super(shaderModuleDataList);
    }
    public Object(List<ShaderModuleData> shaderModuleDataList
            , List<Vector3f> vertices, List<Vector3f> verticesBezier, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        this.verticesBezier = createBezier(vertices.size(),vertices);

        this.color = color;
        setupVAOVBOCurve();
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
    }
    public void setupVAOVBOWithVerticesColor(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);

        //set vbocolor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesColor),
                GL_STATIC_DRAW);
    }


    public void setupVAOVBO(){
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color",color);
        uniformsMap.setUniform("model", model);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void drawSetupWithVerticesColor(){
        bind();

        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);

        // bind vbo color
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3,
                GL_FLOAT,
                false,
                0, 0);
    }

    public void draw(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLE_FAN,
                0,
                vertices.size());
        for(Object child:childObject){
            child.draw();
            for (Object grandchild: child.getChildObject()) {
                grandchild.draw();
                for (Object greatgrandchild: grandchild.getChildObject()) {
                    greatgrandchild.draw();

                }
            }
        }
    }
    public void drawLineChim(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(3); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public void drawLine(){
        drawSetup();
        // Draw the vertices
        //optional
        glLineWidth(5); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_LINE_STRIP,
                0,
                vertices.size());
    }
    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f, 0.0f, 0.0f, centerTemp);
        return centerTemp;

    }
    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }
//    public static float combination(int n, int r) {
//        float val = factorial(n) / (factorial(r) * factorial(n - r));
//        return val;
//    }
//
//    public static float factorial(int angka) {
//        int i = 1;
//        long factorial = 1;
//        while (i <= angka) {
//            factorial *= i;
//            i++;
//        }
//        return factorial;
//    }
//
//    //untuk mencari kurva bezier
//    // kombinasi untuk mencari nilai2 di segitiga pascal
//    public List<Vector3f> makeBezier(List<Vector3f> titik) {
//        verticesBezier.clear();
//        verticesBezier.add(vertices.get(0));
//        float x1 = 0;
//        float y1 = 0;
//
//        float kombi = 0;
//
//        for (float i = 0; i <= 1.0; i += 0.05) {
//            int k = 0;
//            float hasilx = 0;
//            float hasily = 0;
//            for (int j = titik.size() - 1; j >= 0; j--) {
//                kombi = combination(titik.size() - 1, k);
//                x1 = titik.get(k).x;
//                y1 = titik.get(k).y;
//                hasilx = (float) (hasilx + kombi * Math.pow((1 - i), j) * Math.pow(i, k) * x1);
//                hasily = (float) (hasily + kombi * Math.pow((1 - i), j) * Math.pow(i, k) * y1);
//                k++;
//
//            }
//            System.out.println(hasilx + " " + hasily);
//            verticesBezier.add(new Vector3f(hasilx, hasily, 1.0f));
//        }
//        return verticesBezier;
////        for (Vector3f vertices: listVertices) {
////            System.out.println(vertices.x + " " + vertices.y + " " + vertices.z);
////        }
//    }
    public static int fact(int n){
        if (n == 0) return 1;
        return n*fact(n-1);
    }
    public List<Vector3f> createBezier(int n, List<Vector3f> vertices){
        boolean cekBezier = true;
        verticesBezier = new ArrayList<>();
        for (float t = 0; t < 1; t += 0.01f) {
            float x = 0.0f;
            float y = 0.0f;
            for (int i = 0; i < n; i++) {
                x += (float) (fact(n - 1) / (fact(i) * fact((n - 1) - i)) * Math.pow(1 - t, ((n - 1) - i)) * Math.pow(t, i)) * vertices.get(i).x;
                y += (float) (fact(n - 1) / (fact(i) * fact((n - 1) - i)) * Math.pow(1 - t, ((n - 1) - i)) * Math.pow(t, i)) * vertices.get(i).y;
            }
            for (int j = 0; j < verticesBezier.size(); j++) {
                if (verticesBezier.get(j).x == x && verticesBezier.get(j).y == y){
                    cekBezier = false;
                }
            }
            if (cekBezier == true){
//                System.out.println(x + " " + y);
                verticesBezier.add(new Vector3f(x, y, 0.0f));
            }
            cekBezier = true;
        }

        return verticesBezier;
    }

    public void changeVertices(int index,float x, float y){
        vertices.get(index).x = x;
        vertices.get(index).y = y;
        setupVAOVBO();
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        // Draw the vertices
        //optional
        glLineWidth(10); //ketebalan garis
        glPointSize(10); //besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT
        glDrawArrays(GL_TRIANGLES,
                0,
                vertices.size());
        for(Object child:childObject){
            child.draw();
        }
    }

    public void setDegrees(float degrees) {
        this.degrees = degrees;
    }

    public float getDegrees() {
        return degrees;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    public void setupVAOVBOCurve() {
        //set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        //set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(verticesBezier),
                GL_STATIC_DRAW);
    }
    public void drawSetupCurve(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3,
                GL_FLOAT,
                false,
                0, 0);
    }
    public void drawCurve(){
        System.out.println(verticesBezier);
        drawSetupCurve();
        glLineWidth(5); //ketebalan garis
        glPointSize(5); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP,
                0,
                verticesBezier.size());
    }
    public void translateObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.translateObject(offsetX, offsetY, offsetZ);
        }
    }
    public void rotateObject(Float degree, Float offsetX, Float offsetY, Float offsetZ) {
        //nnti degree ny diubah ke rad dl
        model = new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.rotateObject(degree,offsetX, offsetY, offsetZ);
        }
    }
    public void scaleObject(Float offsetX, Float offsetY, Float offsetZ) {
        model = new Matrix4f().scale(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for(Object child:childObject) {
            child.scaleObject(offsetX, offsetY, offsetZ);
        }
    }
}