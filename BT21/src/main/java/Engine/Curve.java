package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;

public class Curve extends Object {
    private ArrayList<Vector3f> listVertices = new ArrayList<>();
    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList,vertices,color);
        this.vertices = vertices;
        bezier(this.vertices);
        setupVAOVBO();
        this.color = color;
//        uniformsMap = new UniformsMap(getProgramId());
//        uniformsMap.createUniform("uni_color");
    }
    public static float combination(int n, int r) {
        float val = factorial(n) / (factorial(r) * factorial(n - r));
        return val;
    }

    public static float factorial(int angka) {
        int i = 1;
        long factorial = 1;
        while (i <= angka) {
            factorial *= i;
            i++;
        }
        return factorial;
    }

    //untuk mencari kurva bezier
    // kombinasi untuk mencari nilai2 di segitiga pascal
    public void bezier(List<Vector3f> titik) {
        listVertices.clear();
        listVertices.add(vertices.get(0));
        float x1 = 0;
        float y1 = 0;

        float kombi = 0;

        for (float i = 0; i <= 1.0; i += 0.05) {
            int k = 0;
            float hasilx = 0;
            float hasily = 0;
            for (int j = titik.size() - 1; j >= 0; j--) {
                kombi = combination(titik.size() - 1, k);
                x1 = titik.get(k).x;
                y1 = titik.get(k).y;
                hasilx = (float) (hasilx + kombi * Math.pow((1 - i), j) * Math.pow(i, k) * x1);
                hasily = (float) (hasily + kombi * Math.pow((1 - i), j) * Math.pow(i, k) * y1);
                k++;

            }
//            System.out.println(hasilx + " " + hasily);
            listVertices.add(new Vector3f(hasilx, hasily, 1.0f));
        }
//        for (Vector3f vertices: listVertices) {
//            System.out.println(vertices.x + " " + vertices.y + " " + vertices.z);
//        }
    }

    public void draw(){
//        Object line = new Object(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(points),
//                new Vector4f(0.0f,0.0f,0.0f,0.0f)
//        );
//        line.drawLine();
//        if(vertices.size()<3) {
//            if(vertices.size()==2){
//                for (Vector3f vertice: vertices){
//                    curveVertices.add(vertice);
//                }
//            }
//            return;
//        }
        setupVAOVBO();
        drawSetup();
        glLineWidth(3f);
        glPointSize(3f);
        glDrawArrays(GL_LINE_STRIP, 0, listVertices.size());

    }
//    public void makeCurve(){
//        List<Vector3f> result = new ArrayList<>();
//
//        for (double i=0; i<1;i+=0.01){
//            float pointx = 0, pointy = 0;
//            for (int j=0;j<vertices.size();j++){
//                double a = factorial(vertices.size()-1)/(factorial(j)*factorial(vertices.size()-j-1));
//                double b = Math.pow((1-i),(vertices.size()-j-1));
//                double c = Math.pow(i,j);
//                double temp =  a * b * c;
//                pointx= (float) (pointx + vertices.get(j).x * temp);
//                pointy= (float) (pointy + vertices.get(j).y * temp);
//            }
//            result.add(new Vector3f(pointx,pointy,0));
//        }
//        this.vertices = result;
//    }
//
//    public int factorial(int n){
//        if (n == 0)
//            return 1;
//        else
//            return(n * factorial(n-1));
//    }
}
