import Engine.*;
import Engine.Object;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (800, 800, "BT21");
    private ArrayList<Object> background = new ArrayList<>();
    private ArrayList<Object> chimmy = new ArrayList<>();
    private ArrayList<Object> van
            = new ArrayList<>();
    private ArrayList<Object> koya = new ArrayList<>();

    boolean objectClicked = false;
    int objectClikedIndex;
    float degKakiKiriNaik = 0f;
    float degKakiKiriTurun = 0.5f;
    float degKakiKananNaik = 0f;
    float degKakiKananTurun = 0.5f;
    boolean turun = true;
    boolean kakiKiriNaik = false;
    boolean kakiKananNaik = false;
    boolean pressKakiKiriNaik = true;
    boolean pressKakiKiriTurun = true;
    boolean pressKakiKananNaik = true;
    boolean pressKakiKananTurun = true;
    boolean naik = false;
    boolean kakiMulai = true;
    float besarMataBuka = 0f;
    float besarMataTutup = 0.9f;
    boolean tutupMata = true;
    boolean mulutHappy = true;
    float degJalanMajuKiri = 0.0f;
    float degJalanMundurKiri = 0.0f;
    float degJalanMajuTengahKiri = 0.0f;
    boolean lompat = true;
    int belomZ = 0, belomC = 0, geserChimmy = 0, geserKoya = 0, geserVan = 0, geserSemua = 0;
    int arah = 1;
    boolean terbang = false;

    public void init() {
        window.init();
        GL.createCapabilities();

        background.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.71765f, 0.67059f, 0.67059f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).scaleObject(6.0f, 4.0f, 0.01f);
        background.get(0).rotateObject((float) Math.toRadians(168f), 0f, 0f, 1f);
        background.get(0).translateObject(0.0f, -0.64f, 0.8f);

//lighter block
        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.51765f, 0.47059f, 0.47059f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(0).scaleObject(6.0f, 0.1f, 0.3f);
        background.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(168f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(0).translateObject(0.0f, 0.45f, 0.8f);
//darker block
        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.41765f, 0.37059f, 0.37059f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(1).scaleObject(6.0f, 0.1f, 0.4f);
        background.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(168f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(1).translateObject(0.0f, 0.4f, 0.85f);
//sidewalk
        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.82353f, 0.80784f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(2).scaleObject(6.0f, 2.8f, 0.3f);
        background.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(168f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(2).translateObject(0.0f, 1.19f, 0.8f);

        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.71765f, 0.67059f, 0.67059f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(3).scaleObject(5.f, 0.35f, 0.1f);
        background.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(42f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(3).translateObject(-0.4f, -0.6f, 0.8f);
        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.71765f, 0.67059f, 0.67059f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(4).scaleObject(5.0f, 0.55f, 0.2f);
        background.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(42f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(4).translateObject(-1.8f, -0.2f, 0.8f);

        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.87843f, 0.85882f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(5).scaleObject(6.0f, 0.2f, 0.1f);
        background.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(167f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(5).translateObject(0.0f, 0.25f, 0.8f);

        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.87843f, 0.85882f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(6).scaleObject(6.0f, 0.23f, 0.1f);
        background.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(166f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(6).translateObject(0.0f, 0.05f, 0.8f);

        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.87843f, 0.85882f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(7).scaleObject(6.0f, 0.26f, 0.1f);
        background.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(165f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(7).translateObject(0.0f, -0.2f, 0.8f);
        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.87843f, 0.85882f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(8).scaleObject(6.0f, 0.29f, 0.1f);
        background.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(164f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(8).translateObject(0.0f, -0.45f, 0.8f);
        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.87843f, 0.85882f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(9).scaleObject(6.0f, 0.32f, 0.1f);
        background.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(163f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(9).translateObject(0.0f, -0.75f, 0.8f);

        background.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.87451f, 0.87843f, 0.85882f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f, 0.5f, 0.5f, 36, 18, 13
        ));
        background.get(0).getChildObject().get(10).scaleObject(2.5f, 0.35f, 0.1f);
        background.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(162f), 0f, 0f, 1f);
        background.get(0).getChildObject().get(10).translateObject(-0.6f, -0.9f, 0.8f);


        //badan
        chimmy.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.5f,0.5f,0.5f,36,18,3
        ));
        chimmy.get(0).scaleObject(0.4f, 0.15f, 0.2f);
        chimmy.get(0).rotateObject((float) Math.toRadians(90f),1f,0f,0f);
        //patokan kepala
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.29216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(0).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(0).translateObject(0.0f, 0.16f, 0.0f);

        //kepala kuning besar (chimmy)
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,5
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.25f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.3f, 0.0f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.15f, 1.0f, 1.0f);
        chimmy.get(0).getChildObject().get(0).setDegrees(180f);

        // kepala kuning kecil
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,5
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, 0.65f, 0.0f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.6f, 0.3f, 0.25f);

        // kepala putih
        chimmy.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                1.0f,
                1.0f,
                1.0f, 36,18,4
        ));
        chimmy.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.4f,0.3f,0.01f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.0f, 0.27f, 0.11f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(180f), 0f,1f,0f);

        //mata kiri
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,3)
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(0.03f,0.03f,0.0001f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(0.05f, 0.3f, 0.12f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(180f), 0f,1f,0f);

        //mata kanan
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,3)
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(0.03f,0.03f,0.0001f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(-0.05f, 0.3f, 0.12f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(180f), 0f,1f,0f);

        // hidung
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,6
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(5).scaleObject(0.03f,0.04f,0.01f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(5).translateObject(-0.27f, 0.0f,-0.12f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(270f), 0f,0f,1f);

        // lidah
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.9451f, 0.52157f, 0.48627f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,0
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(6).scaleObject(0.05f,0.04f,0.01f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(6).translateObject(-0.185f, 0.18f,-0.12f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(300f), 0.0f,0.0f,1f);
        //patokan telinga kanan
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.91176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(7).scaleObject(0.01f,0.01f,0.01f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(7).translateObject(0.2f, 0.48f,0.0f);

        // telinga kanan
        chimmy.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,7
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(0).scaleObject(0.4f,0.08f,0.3f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(0).translateObject(-0.34f, 0.41f,0.0f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float)Math.toRadians(300f), 0.0f,0.0f,1.0f);

        //patokan telinga kiri
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(8).scaleObject(0.01f,0.01f,0.01f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(8).translateObject(-0.2f, 0.48f,0.0f);
        // telinga kiri
        chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject().add(
//        chimmy.get(0).getChildObject().get(1).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,7
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject().get(0).scaleObject(0.4f,0.08f,0.3f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject().get(0).translateObject(-0.34f, -0.41f,0.0f);
        chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject().get(0).rotateObject((float)Math.toRadians(240f), 0.0f,0.0f,1.0f);

        // mulut chimmy
        chimmy.get(0).getChildObject().get(0).getChildObject().add(
                new Curve(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.047f, -0.1205f, 0),
                                        new Vector3f(-0.046f, -0.121f, 0),
                                        new Vector3f(-0.045f, -0.12127f, 0.f),
                                        new Vector3f(-0.0445f, -0.12135f, 0.f),
                                        new Vector3f(-0.044f, -0.1214f, 0.f),
                                        new Vector3f(-0.0435f, -0.12135f, 0.f),
                                        new Vector3f(-0.043f, -0.12127f, 0),
                                        new Vector3f(-0.042f, -0.121f, 0.f),
                                        new Vector3f(-0.041f, -0.1205f, 0.f)
//                                        new Vector3f(-0.75f, -0.75f, 0.0f),
//                                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                                        new Vector3f(-0.25f, -0.75f, 0.0f)
                                )
                        ), new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f)
                )
        );
        chimmy.get(0).getChildObject().get(0).getChildObject().get(9).scaleObject(20.5f, 10.5f, 0.0001f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(0.462f, 1.205f, -0.14f);

        chimmy.get(0).getChildObject().get(0).getChildObject().get(9).translateObject(0.9f,1.51f,-0.12f);
//        chimmy.get(0).getChildObject().get(0).getChildObject().get(9).scaleObject(0.4f,0.08f,0.3f);
//        chimmy.get(0).getChildObject().get(0).getChildObject().get(9).translateObject(-0.34f, -0.41f,0.0f);
//        chimmy.get(0).getChildObject().get(0).getChildObject().get(9).rotateObject((float)Math.toRadians(240f), 0.0f,0.0f,1.0f);

        //patokan tangan kanan
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(1).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(1).translateObject(0.2f, 0.06f, 0.0f);

        //tangan kanan
        chimmy.get(0).getChildObject().get(1).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,6
                )
        );
        chimmy.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.2f, 0.1f, 0.1f);
        chimmy.get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(290f),0f,0f,1f);
        chimmy.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.225f, 0.0f, 0.0f);

        // tangan kanan putih
        chimmy.get(0).getChildObject().get(1).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,0
                )
        );
        chimmy.get(0).getChildObject().get(1).getChildObject().get(1).scaleObject(0.075f, 0.075f, 0.075f);
        chimmy.get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float) Math.toRadians(290f),0f,0f,1f);
        chimmy.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.25f, -0.063f, 0.0f);

        //patokan tangan kiri
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(2).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(2).translateObject(-0.2f, 0.06f, 0.0f);
//        chimmy.get(0).getChildObject().get(12).translateObject(-0.03f, 0.07f, -0.07f);

        //tangan kiri
        chimmy.get(0).getChildObject().get(2).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,6
                )
        );

        chimmy.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.2f, 0.1f, 0.1f);
        chimmy.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(110f),0f,0f,-1f);
        chimmy.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.225f, 0.0f, 0.0f);
        // tangan kanan putih
        chimmy.get(0).getChildObject().get(2).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,0
                )
        );

        chimmy.get(0).getChildObject().get(2).getChildObject().get(1).scaleObject(0.075f, 0.075f, 0.075f);
        chimmy.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float) Math.toRadians(250f),0f,0f,1f);
        chimmy.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-0.25f, -0.063f, 0.0f);

        //patokan kaki kanan
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.19216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(3).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(3).translateObject(0.1f, -0.1f, 0.0f);

        // kaki kanan
        chimmy.get(0).getChildObject().get(3).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,4
                )
        );
        chimmy.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.2f, 0.4f, 0.2f);
        chimmy.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(0.1f, -0.1f, 0.0f);

        // kaki kanan bawah
        chimmy.get(0).getChildObject().get(3).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,4
                )
        );
        chimmy.get(0).getChildObject().get(3).getChildObject().get(1).scaleObject(0.2f, 0.1f, 0.2f);
        chimmy.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(0.1f, -0.25f, 0.0f);

        //patokan kaki kiri
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.19216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(4).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(4).translateObject(-0.1f, -0.1f, 0.0f);

        // kaki kiri
        chimmy.get(0).getChildObject().get(4).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,4
                )
        );
        chimmy.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.2f, 0.4f, 0.2f);
        chimmy.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.1f, -0.1f, 0.0f);

        // kaki kiri bawah
        chimmy.get(0).getChildObject().get(4).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.99216f, 0.84706f, 0.17647f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.05f,
                        0.05f,
                        0.05f, 36,18,4
                )
        );
        chimmy.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.2f, 0.1f, 0.2f);
        chimmy.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(-0.1f, -0.25f, 0.0f);

        //patokan gandul" kanan
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.91765f, 0.42745f, 0.02353f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(5).scaleObject(0.01f,0.01f,0.01f);
        chimmy.get(0).getChildObject().get(5).translateObject(0.03f, 0.07f, -0.07f);
        // gandul" kanan
        chimmy.get(0).getChildObject().get(5).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.91765f, 0.42745f, 0.02353f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(5).getChildObject().get(0).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.03f, -0.02f, -0.09f);
        // tali kanan
        chimmy.get(0).getChildObject().get(5).getChildObject().add(
                new Curve(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.047f, -0.1205f, 0),
                                        new Vector3f(-0.046f, -0.121f, 0),
                                        new Vector3f(-0.045f, -0.12127f, 0.f),
                                        new Vector3f(-0.0445f, -0.12135f, 0.f),
                                        new Vector3f(-0.044f, -0.1214f, 0.f)
                                )
                        ), new Vector4f(0.91765f, 0.42745f, 0.02353f, 0.0f)
                )
        );
        chimmy.get(0).getChildObject().get(5).getChildObject().get(1).scaleObject(30.5f, 10.5f, 0.0001f);
        chimmy.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(1.37f,1.3f,-0.085f);
        chimmy.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float)Math.toRadians(280f), 0.0f,0.0f,1.0f);

//        chimmy.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(0.9f,1.51f,-0.12f);
        //patokan gandul" kiri
        chimmy.get(0).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.91765f, 0.42745f, 0.02353f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(6).scaleObject(0.01f,0.01f,0.01f);
        chimmy.get(0).getChildObject().get(6).translateObject(-0.03f, 0.07f, -0.07f);
        // gandul" kiri
        chimmy.get(0).getChildObject().get(6).getChildObject().add(
                new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.91765f, 0.42745f, 0.02353f, 0.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        1.0f,
                        1.0f,
                        1.0f, 36,18,4)
        );
        chimmy.get(0).getChildObject().get(6).getChildObject().get(0).scaleObject(0.03f,0.03f,0.03f);
        chimmy.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(-0.04f, -0.02f, -0.09f);
        // tali kanan
        chimmy.get(0).getChildObject().get(6).getChildObject().add(
                new Curve(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.044f, -0.1214f, 0.f),
                                        new Vector3f(-0.0435f, -0.12135f, 0.f),
                                        new Vector3f(-0.043f, -0.12127f, 0),
                                        new Vector3f(-0.042f, -0.121f, 0.f),
                                        new Vector3f(-0.041f, -0.1205f, 0.f)
//                                        new Vector3f(-0.75f, -0.75f, 0.0f),
//                                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                                        new Vector3f(-0.25f, -0.75f, 0.0f)
                                )
                        ), new Vector4f(0.91765f, 0.42745f, 0.02353f, 0.0f)
                )
        );
        chimmy.get(0).getChildObject().get(6).getChildObject().get(1).scaleObject(30.5f, 10.5f, 0.0001f);
        chimmy.get(0).getChildObject().get(6).getChildObject().get(1).translateObject(1.32f,1.31f,-0.085f);
        chimmy.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float)Math.toRadians(80f), 0.0f,0.0f,1.0f);
//code
//        van.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,0.0f,1.0f,1.0f)
//        ));
//
//        van.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f,0.5f,0.0f),
//                                new Vector3f(0.0f,1.0f,0.0f),
//                                new Vector3f(0.0f,0.0f,1.0f)
//                        )
//                )
//        ));
//
        // Badan abu abu
        van.add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.535f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 3
                )
        );
        van.get(0).setHeight(0f);
        van.get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        van.get(0).scaleObject(0.14f, 0.17f, 0.1f);
        van.get(0).translateObject(-0.07f, 0.115f, 0f);

        // Badan putih
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 3
                )
        );

        van.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        van.get(0).getChildObject().get(0).scaleObject(0.14f, 0.17f, 0.1f);
        van.get(0).getChildObject().get(0).translateObject(0.07f, 0.115f, 0f);

        // Patokan Lengan kiri
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(1.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 4
                )
        );

        van.get(0).getChildObject().get(1).scaleObject(0.03f, 0.03f, 0.03f);
        van.get(0).getChildObject().get(1).translateObject(-0.14f, 0.083f, 0f);

        // Lengan kiri
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 4
                )
        );
        van.get(0).getChildObject().get(2).setDegrees(0f);
        van.get(0).getChildObject().get(2).scaleObject(0.2f, 0.15f, 0.2f);
        van.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(240f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(2).translateObject(-0.1f, 0.076f, 0f);

        // Patokan Lengan kanan
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(1.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 4
                )
        );
        van.get(0).getChildObject().get(3).scaleObject(0.03f, 0.03f, 0.03f);
        van.get(0).getChildObject().get(3).translateObject(0.14f, 0.083f, 0f);

        // Lengan kanan
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 4
                )
        );
        van.get(0).getChildObject().get(4).scaleObject(0.2f, 0.15f, 0.2f);
        van.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(120f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(4).translateObject(0.1f, 0.076f, 0f);

        // Patokan Kaki kiri
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(1.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 4
                )
        );
        van.get(0).getChildObject().get(5).setDegrees(0f);
        van.get(0).getChildObject().get(5).scaleObject(0.03f, 0.03f, 0.03f);
        van.get(0).getChildObject().get(5).translateObject(-0.076f, -0.02f, 0f);

        // Kaki abu abu
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 3
                )
        );
        van.get(0).getChildObject().get(6).setDegrees(90f);
        van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        van.get(0).getChildObject().get(6).scaleObject(0.13f, 0.08f, 0.1f);
        van.get(0).getChildObject().get(6).translateObject(-0.076f, -0.06f, 0f);

        // Telapak kaki abu abu
        van.get(0).getChildObject().get(6).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 0
                )
        );
        van.get(0).getChildObject().get(6).getChildObject().get(0).scaleObject(0.05f, 0.13f, 0.1f);
        van.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(270f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(-0.076f, -0.12f, 0f);

        // Patokan Kaki kanan
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(1.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 4
                )
        );
        van.get(0).getChildObject().get(7).setDegrees(0f);
        van.get(0).getChildObject().get(7).scaleObject(0.03f, 0.03f, 0.03f);
        van.get(0).getChildObject().get(7).translateObject(0.076f, -0.02f, 0f);

        // Kaki putih
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 3
                )
        );
        van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        van.get(0).getChildObject().get(8).scaleObject(0.13f, 0.08f, 0.1f);
        van.get(0).getChildObject().get(8).translateObject(0.076f, -0.06f, 0f);

        // Telapak kaki putih
        van.get(0).getChildObject().get(8).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 0
                )
        );
        van.get(0).getChildObject().get(8).getChildObject().get(0).scaleObject(0.05f, 0.13f, 0.1f);
        van.get(0).getChildObject().get(8).getChildObject().get(0).rotateObject((float) Math.toRadians(270f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(8).getChildObject().get(0).translateObject(0.076f, -0.12f, 0f);

        // Kepala abu abu
        van.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ),
                new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.125f,
                0.125f,
                0.125f,
                36, 18, 0
        ));

        van.get(0).getChildObject().get(9).setDegrees(180f);
        van.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(180f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(9).scaleObject(0.4f, 0.4f, 0.4f);
        van.get(0).getChildObject().get(9).translateObject(0f, 0.3f, 0f);

        // Kepala putih
        van.get(0).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 0
                )
        );

        van.get(0).getChildObject().get(10).scaleObject(0.4f, 0.4f, 0.4f);
        van.get(0).getChildObject().get(10).translateObject(0f, 0.3f, 0f);


        // Tanduk abu abu
        van.get(0).getChildObject().get(9).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.530f, 0.535f, 0.535f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 1
                )
        );
        van.get(0).getChildObject().get(9).getChildObject().get(0).rotateObject((float) Math.toRadians(270f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(9).getChildObject().get(0).scaleObject(0.16f, 0.11f, 0.2f);
        van.get(0).getChildObject().get(9).getChildObject().get(0).translateObject(0f, 0.59f, 0f);

        // Tanduk putih
        van.get(0).getChildObject().get(10).getChildObject().add(new Sphere(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1f, 1f, 1f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.125f,
                        0.125f,
                        0.125f,
                        36, 18, 2
                )
        );
        van.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject((float) Math.toRadians(270f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(10).getChildObject().get(0).scaleObject(0.16f, 0.11f, 0.2f);
        van.get(0).getChildObject().get(10).getChildObject().get(0).translateObject(0f, 0.59f, 0f);
//
//        van.get(0).getChildObject().get(6).getChildObject().add(
//                new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(-0.5f, 0.5f, 0.0f),
//                                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                                        new Vector3f(0.5f, -0.5f, 0.0f),
//                                        new Vector3f(0.5f, 0.5f, 0.0f)
//                                )
//                        ),
//                        new Vector4f(0f, 0f, 0.0f, 0.0f),
//                        Arrays.asList(0.0f, 0.0f, 0.0f),
//                        1.0f,
//                        1.0f,
//                        1.0f,3)
//        );
//        van.get(0).getChildObject().get(6).getChildObject().get(1).scaleObject(0.05f,0.05f,0.0001f);
//        van.get(0).getChildObject().get(6).getChildObject().get(1).translateObject(-0.09f, 0.26f, 0.18f);
//        van.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float)Math.toRadians(180f), 0f,1f,0f);
        // Mata Lingkaran hitam
        van.get(0).getChildObject().get(10).getChildObject().add(new Circle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.04f,
                        0.04f,
                        0
                )
        );
        van.get(0).getChildObject().get(10).getChildObject().get(1).translateObject(0.09f, 0.26f, -0.2f);
        // Mata Lingkaran putih
//        van.get(0).getChildObject().get(6).getChildObject().add(
//                new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(-0.5f, 0.5f, 0.0f),
//                                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                                        new Vector3f(0.5f, -0.5f, 0.0f),
//                                        new Vector3f(0.5f, 0.5f, 0.0f)
//                                )
//                        ),
//                        new Vector4f(1f, 1f, 1.0f, 0.0f),
//                        Arrays.asList(1.0f, 1.0f, 1.0f),
//                        1.0f,
//                        1.0f,
//                        1.0f,3)
//        );
//        van.get(0).getChildObject().get(6).getChildObject().get(2).scaleObject(0.026f,0.026f,0.0001f);
//        van.get(0).getChildObject().get(6).getChildObject().get(2).translateObject(-0.09f, 0.26f, 0.18f);
//        van.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float)Math.toRadians(180f), 0f,1f,0f);
//
        van.get(0).getChildObject().get(10).getChildObject().add(new Circle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.026f,
                        0.026f, 0
                )
        );
        van.get(0).getChildObject().get(10).getChildObject().get(2).translateObject(0.09f, 0.26f, -0.21f);

        // Mata silang 1 (miring kiri)
        van.get(0).getChildObject().get(10).getChildObject().add(new Circle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.009f,
                        0.055f, 1
                )
        );
        van.get(0).getChildObject().get(10).getChildObject().get(3).rotateObject((float) Math.toRadians(45f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(10).getChildObject().get(3).translateObject(-0.09f, 0.26f, -0.2f);

        // Mata silang 2 (miring kanan)
        van.get(0).getChildObject().get(10).getChildObject().add(new Circle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                        Arrays.asList(0.0f, 0.0f, 0.0f),
                        0.009f,
                        0.055f, 1
                )
        );
        van.get(0).getChildObject().get(10).getChildObject().get(4).rotateObject((float) Math.toRadians(135f), 0f, 0f, 1f);
        van.get(0).getChildObject().get(10).getChildObject().get(4).translateObject(-0.09f, 0.26f, -0.2f);

//        // Mulut van

//        van.get(0).getChildObject().get(7).getChildObject().add(new Curve(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                                List.of(
//                                        new Vector3f(0.5f,0.5f,0f),
//                                        new Vector3f(0.8f, 0.8f, 0.2f)
//                                )
//                        ),new Vector4f(1.0f,0.0f,0.0f,1.0f)
//        ));
//        van.get(0).getChildObject().get(10).getChildObject().add(new Circle(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(-0.5f, 0.5f, 0.0f),
//                                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                                        new Vector3f(0.5f, -0.5f, 0.0f),
//                                        new Vector3f(0.5f, 0.5f, 0.0f)
//                                )
//                        ),
//                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
//                        Arrays.asList(0.0f, 0.0f, 0.0f),
//                        0.009f,
//                        0.055f, 1
//                )
//        );
        van.get(0).getChildObject().get(10).getChildObject().add(
                new Curve(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.047f, -0.1205f, 0),
                                        new Vector3f(-0.044f, -0.1205f, 0.f),
                                        new Vector3f(-0.041f, -0.1205f, 0.f)
//                                        new Vector3f(-0.75f, -0.75f, 0.0f),
//                                        new Vector3f(-0.5f, -0.5f, 0.0f),
//                                        new Vector3f(-0.25f, -0.75f, 0.0f)
                                )
                        ), new Vector4f(0.01176f, 0.01569f, 0.0f, 0.0f)
                )
        );
        van.get(0).getChildObject().get(10).getChildObject().get(5).scaleObject(20.5f, 10.5f, 0.0001f);
//        van.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(0.462f, 1.205f, -0.14f);

        van.get(0).getChildObject().get(10).getChildObject().get(5).translateObject(0.9f,1.46f,-0.2f);
//        van.get(0).getChildObject().get(10).getChildObject().get(5).rotateObject((float) Math.toRadians(90f), 0f, 0f, 1f);
//        van.get(0).getChildObject().get(10).getChildObject().get(5).translateObject(0.0f, 0.19f, -0.2f);

        //badan koya
        koya.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
//                ), new Vector4f(0.930f, 0.0465f, 0.0465f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.0001f, 0.0001f, 0.1f, 36, 18, 3
        ));
        koya.get(0).rotateObject((float) Math.toRadians(90f), 1.0f, 0.0f, 0.0f);
        koya.get(0).scaleObject(0.24f, 0.15f, 0.18f);
        koya.get(0).translateObject(-0.0f, -0.2f, 0.0f);

        //kepala koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 36, 18, 4
        ));
        koya.get(0).getChildObject().get(0).scaleObject(0.42f, 0.3f, 0.3f);
        koya.get(0).getChildObject().get(0).setDegrees(180f);

        //hidung koya
        koya.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(0.520f, 0.0292f, 0.730f, 1.0f),
                ), new Vector4f(0.396f, 0.00f, 0.880f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f, 0.1f, 0.01f, 72, 36, 0
        ));
        koya.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        koya.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.08f, 0.1f, 0.05f);
        koya.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, -0.14f);

//        koya.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.5f, 0.0f, -0.5f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(180),0.0f,1.0f,0.0f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.4f, 0.6f, -0.28f);

        //mata kiri koya
        koya.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f, 0.1f, 0.01f, 72, 36, 12
        ));
        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.5f, 0.025f, 0.25f);

//        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.055f, 0.0075f, 0.001f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.06f, 0.007f, 0k.050f);
        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.08f, -0.0f, -0.144f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(0.2f, 0.0f, 0.0f, 1.0f);

        //mata kanan koya
        koya.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.05f, 0.1f, 0.01f, 72, 36, 12
        ));
//        koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.06f, 0.015f, 0.00001f);
        koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.5f, 0.025f, 0.25f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.06f, 0.007f, 0.050f);
        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(0.08f, -0.0f, -0.144f);

        //mulut koya
        koya.get(0).getChildObject().get(0).getChildObject().add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.047f, -0.1205f, 0),
                                new Vector3f(-0.046f, -0.121f, 0),
                                new Vector3f(-0.045f, -0.12127f, 0.f),
                                new Vector3f(-0.0445f, -0.12135f, 0.f),
                                new Vector3f(-0.044f, -0.1214f, 0.f),
                                new Vector3f(-0.0435f, -0.12135f, 0.f),
                                new Vector3f(-0.043f, -0.12127f, 0),
                                new Vector3f(-0.042f, -0.121f, 0.f),
                                new Vector3f(-0.041f, -0.1205f, 0.f)

                        )
                ),
                new Vector4f(0f, 0f, 0f, 1f)

        ));
        koya.get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(10.5f, 10.5f, 0.0001f);
        koya.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(0.462f, 1.205f, -0.14f);

        //Telinga kiri koya
        koya.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 10
        ));
        koya.get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(0.18f, 0.18f, 0.20f);
        koya.get(0).getChildObject().get(0).getChildObject().get(4).rotateObject(0.3f, 0.0f, 0.0f, 1.0f);
        koya.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(-0.2f, 0.1f, 0.0f);

        //Telinga kiri dalam koya
        koya.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.864f, 0.949f, 0.960f, 1.0f),
//                ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 10
        ));
        koya.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.03f);
        koya.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).rotateObject(0.3f, 0.0f, 0.0f, 1.0f);
        koya.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.19f, 0.09f, -0.093f);

        //Telinga kanan koya
        koya.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 10
        ));
//        koya.get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(0.18f, 0.18f, 0.20f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(4).rotateObject(0.3f, 0.0f, 0.0f, 1.0f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(-0.2f, 0.1f, 0.0f);
        koya.get(0).getChildObject().get(0).getChildObject().get(5).scaleObject(0.18f, 0.18f, 0.20f);
        koya.get(0).getChildObject().get(0).getChildObject().get(5).rotateObject(-1.52f, 0.0f, 0.0f, 1.0f);
        koya.get(0).getChildObject().get(0).getChildObject().get(5).translateObject(0.2f, 0.1f, 0.0f);

        //Telinga kanan dalam koya
        koya.get(0).getChildObject().get(0).getChildObject().get(5).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.864f, 0.949f, 0.960f, 1.0f),
//                ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 10
        ));
        koya.get(0).getChildObject().get(0).getChildObject().get(5).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.03f);
        koya.get(0).getChildObject().get(0).getChildObject().get(5).getChildObject().get(0).rotateObject(-1.52f, 0.0f, 0.0f, 1.0f);
        koya.get(0).getChildObject().get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.19f, 0.09f, -0.093f);

        //Badan tengah
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.864f, 0.949f, 0.960f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 9
        ));
        koya.get(0).getChildObject().get(1).scaleObject(0.17f, 0.3f, 0.05f);
        koya.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(180), 0.0f, 1.0f, 0.0f);
        koya.get(0).getChildObject().get(1).translateObject(0.0f, -0.14f, -0.088f);

        //tangan kiri koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
//                ), new Vector4f(0.840f, 0.168f, 0.0336f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 4
        ));
        koya.get(0).getChildObject().get(2).scaleObject(0.06f, 0.15f, 0.05f);
        koya.get(0).getChildObject().get(2).rotateObject(-0.4f, 0.0f, 0.0f, 1.0f);
        koya.get(0).getChildObject().get(2).translateObject(-0.15f, -0.2f, 0.0f);

        //tangan kanan koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
//                ), new Vector4f(0.840f, 0.168f, 0.0336f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 4
        ));

        koya.get(0).getChildObject().get(3).scaleObject(0.06f, 0.15f, 0.05f);
        koya.get(0).getChildObject().get(3).rotateObject(0.4f, 0.0f, 0.0f, 1.0f);
        koya.get(0).getChildObject().get(3).translateObject(0.15f, -0.2f, 0.0f);

        //kaki kiri koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 8
        ));
        koya.get(0).getChildObject().get(4).scaleObject(0.125f, 0.2f, 0.125f);
        koya.get(0).getChildObject().get(4).translateObject(-0.056f, -0.29f, 0.0f);

        //kaki kanan koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 8
        ));
        koya.get(0).getChildObject().get(5).scaleObject(0.125f, 0.2f, 0.125f);
        koya.get(0).getChildObject().get(5).translateObject(0.056f, -0.29f, 0.0f);
//        koya.get(0).getChildObject().get(5).scaleObject(0.125f, 0.2f, 0.125f);
//        koya.get(0).getChildObject().get(5).translateObject(0.5f, -0.29f, 0.0f);

        //poros tangan kiri koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 8
        ));
        koya.get(0).getChildObject().get(6).scaleObject(0.03f, 0.03f, 0.03f);
        koya.get(0).getChildObject().get(6).translateObject(-0.12f, -0.14f, 0.0f);

        //poros tangan kanan koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 8
        ));

        koya.get(0).getChildObject().get(7).scaleObject(0.03f, 0.03f, 0.03f);
        koya.get(0).getChildObject().get(7).translateObject(0.10f, -0.14f, 0.0f);

        //poros kaki kiri koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                ), new Vector4f(0.840f, 0.215f, 0.0252f, 1.0f),
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 4
        ));
        koya.get(0).getChildObject().get(8).scaleObject(0.03f, 0.03f, 0.03f);
        koya.get(0).getChildObject().get(8).translateObject(-0.06f, -0.25f, 0.0f);
//        koya.get(0).getChildObject().get(8).translateObject(-0.0f, 0.1f, 0.9f);

        //poros kaki kanan koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                ), new Vector4f(0.845f, 0.559f, 0.860f, 1.0f),
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 4
        ));
        koya.get(0).getChildObject().get(9).scaleObject(0.03f, 0.03f, 0.03f);
        koya.get(0).getChildObject().get(9).translateObject(0.06f, -0.25f, 0.0f);


        //ekor koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 12
        ));
        koya.get(0).getChildObject().get(10).scaleObject(0.055f, 0.055f, 0.05f);
        koya.get(0).getChildObject().get(10).translateObject(0.0f, -0.27f, 0.08f);

        //poros mata kiri koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
                ), new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
//                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
//                ), new Vector4f(0.0252f, 0.840f, 0.365f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 4
        ));
        koya.get(0).getChildObject().get(11).scaleObject(0.006f, 0.006f, 0.0001f);
        koya.get(0).getChildObject().get(11).translateObject(-0.09f, -0.0f, -0.144f);

//        koya.get(0).scaleObject(1.2f,1.2f,1.2f);
//        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.08f, -0.0f, -0.144f);

        //poros mata kanan koya
        koya.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, 0.5f, 0.0f)
                        )
//                ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                ), new Vector4f(0.407f, 0.876f, 0.970f, 1.0f),
                ), new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                0.01f, 0.01f, 0.01f, 72, 36, 4
        ));
        koya.get(0).getChildObject().get(12).scaleObject(0.006f, 0.006f, 0.0001f);
        koya.get(0).getChildObject().get(12).translateObject(0.09f, -0.0f, -0.144f);


        koya.get(0).scaleObject(1.2f, 1.2f, 1.2f);
        van.get(0).scaleObject(1.2f, 1.2f, 1.2f);

        chimmy.get(0).scaleObject(0.8f, 0.8f, 0.8f);

        // peletakkan van chimmy koya
//        van.get(0).translateObject(0.5f,0.25f,0.0f);

        van.get(0).translateObject(0.0f, 0.25f, 0.0f);
        chimmy.get(0).translateObject(0.4f, -0.55f, 0.0f);
        koya.get(0).translateObject(-0.4f, -0.3f, 0.0f);

    }


    public void input() {
        // geser kiri van
        if (window.isKeyPressed(GLFW_KEY_1)) {
            Vector3f kaki_kiri = van.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan = van.get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));

            if (geserVan < 10){
                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(-0.005f, -0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);

                geserVan += 1;

            }
            else if (geserVan < 20){
                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(-0.005f, -0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);
                geserVan += 1;
            }
            if (geserVan == 20){
                geserVan = 0;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_2)) {
            Vector3f kaki_kiri = van.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan = van.get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));

            if (geserVan < 10){
                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(0.005f, 0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);

                geserVan += 1;

            }
            else if (geserVan < 20){
                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(0.005f, 0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);
                geserVan += 1;
            }
            if (geserVan == 20){
                geserVan = 0;
            }
        }

        // geser kiri chimmy
        if (window.isKeyPressed(GLFW_KEY_3)) {
            Vector3f kaki_kiri = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan = chimmy.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));

            if (geserChimmy < 10){
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                    child.translateObject(kaki_kiri.x, kaki_kiri.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                    child.rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                    child.translateObject(kaki_kanan.x, kaki_kanan.y, 0f);
                }
                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(-0.005f, -0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);

                geserChimmy += 1;

            }
            else if (geserChimmy < 20){
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                    child.translateObject(kaki_kiri.x, kaki_kiri.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                    child.rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                    child.translateObject(kaki_kanan.x, kaki_kanan.y, 0f);
                }
                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(-0.005f, -0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);

                geserChimmy += 1;
            }
            if (geserChimmy == 20){
                geserChimmy = 0;
            }
        }
        // geser kanan chimmy
        if (window.isKeyPressed(GLFW_KEY_4)) {
            Vector3f kaki_kiri = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan = chimmy.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));

            if (geserChimmy < 10){
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, 1f);
                    child.translateObject(kaki_kiri.x, kaki_kiri.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, -1f);
                    child.translateObject(kaki_kanan.x, kaki_kanan.y, 0f);
                }
                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(0.005f, 0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);

                geserChimmy += 1;

            }
            else if (geserChimmy < 20){
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, -1f);
                    child.translateObject(kaki_kiri.x, kaki_kiri.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, 1f);
                    child.translateObject(kaki_kanan.x, kaki_kanan.y, 0f);
                }

                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(0.005f, 0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);

                geserChimmy += 1;
            }
            if (geserChimmy == 20){
                geserChimmy = 0;
            }
        }
        // geser kiri koya
        if (window.isKeyPressed(GLFW_KEY_5)) {
            Vector3f kaki_kiri = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));

            if (geserKoya < 10){
                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(-0.005f, -0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                geserKoya += 1;
            }
            else if (geserKoya < 20){
                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(-0.005f, -0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                geserKoya += 1;
            }
            if (geserKoya == 20){
                geserKoya = 0;
            }
        }
        // geser kanan koya
        if (window.isKeyPressed(GLFW_KEY_6)) {
            Vector3f kaki_kiri = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));

            if (geserKoya < 10){
                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(0.005f, 0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                geserKoya += 1;
            }
            else if (geserKoya < 20){
                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri.x, kaki_kiri.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan.x, -kaki_kanan.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan.x, kaki_kanan.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(0.005f, 0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                geserKoya += 1;
            }
            if (geserKoya == 20){
                geserKoya = 0;
            }
        }
        // semuaaaaaaaaaaaa geser ke kiriiii
        if (window.isKeyPressed(GLFW_KEY_7)) {
            Vector3f kaki_kiri_koya = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan_koya = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));
            Vector3f kaki_kiri_chimmy = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan_chimmy = chimmy.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));
            Vector3f kaki_kiri_van = van.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan_van = van.get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));


            if (geserSemua < 10){

                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri_chimmy.x, -kaki_kiri_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, 1f);
                    child.translateObject(kaki_kiri_chimmy.x, kaki_kiri_chimmy.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan_chimmy.x, -kaki_kanan_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, -1f);
                    child.translateObject(kaki_kanan_chimmy.x, kaki_kanan_chimmy.y, 0f);
                }
                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(-0.005f, -0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);



                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri_koya.x, -kaki_kiri_koya.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri_koya.x, kaki_kiri_koya.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan_koya.x, -kaki_kanan_koya.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan_koya.x, kaki_kanan_koya.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(-0.005f, -0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri_van.x, -kaki_kiri_van.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri_van.x, kaki_kiri_van.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan_van.x, -kaki_kanan_van.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan_van.x, kaki_kanan_van.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(-0.005f, -0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);
                geserSemua += 1;
            }
            else if (geserSemua < 20){
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri_chimmy.x, -kaki_kiri_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, -1f);
                    child.translateObject(kaki_kiri_chimmy.x, kaki_kiri_chimmy.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan_chimmy.x, -kaki_kanan_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, 1f);
                    child.translateObject(kaki_kanan_chimmy.x, kaki_kanan_chimmy.y, 0f);
                }

                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(-0.005f, -0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);


                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri_koya.x, -kaki_kiri_koya.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri_koya.x, kaki_kiri_koya.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan_koya.x, -kaki_kanan_koya.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan_koya.x, kaki_kanan_koya.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(-0.005f, -0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri_van.x, -kaki_kiri_van.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri_van.x, kaki_kiri_van.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan_van.x, -kaki_kanan_van.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan_van.x, kaki_kanan_van.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(-0.005f, -0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);
                geserSemua += 1;
            }
            if (geserSemua == 20){
                geserSemua = 0;
            }
        }
        // semuaaaaaaaaaaaa geser ke kanan
        if (window.isKeyPressed(GLFW_KEY_8)) {
            Vector3f kaki_kiri_koya = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan_koya = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));
            Vector3f kaki_kiri_chimmy = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan_chimmy = chimmy.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));
            Vector3f kaki_kiri_van = van.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f kaki_kanan_van = van.get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f));


            if (geserSemua < 10){

                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri_chimmy.x, -kaki_kiri_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, 1f);
                    child.translateObject(kaki_kiri_chimmy.x, kaki_kiri_chimmy.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan_chimmy.x, -kaki_kanan_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, -1f);
                    child.translateObject(kaki_kanan_chimmy.x, kaki_kanan_chimmy.y, 0f);
                }
                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(0.005f, 0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);


                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri_koya.x, -kaki_kiri_koya.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri_koya.x, kaki_kiri_koya.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan_koya.x, -kaki_kanan_koya.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan_koya.x, kaki_kanan_koya.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(0.005f, 0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri_van.x, -kaki_kiri_van.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri_van.x, kaki_kiri_van.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan_van.x, -kaki_kanan_van.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan_van.x, kaki_kanan_van.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(0.005f, 0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);
                geserSemua += 1;
            }
            else if (geserSemua < 20){
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri_chimmy.x, -kaki_kiri_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, -1f);
                    child.translateObject(kaki_kiri_chimmy.x, kaki_kiri_chimmy.y, 0f);
                }
                for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                    child.translateObject(-kaki_kanan_chimmy.x, -kaki_kanan_chimmy.y, 0f);
                    child.rotateObject((float) Math.toRadians(1.5f), 0f, 0f, 1f);
                    child.translateObject(kaki_kanan_chimmy.x, kaki_kanan_chimmy.y, 0f);
                }
                chimmy.get(0).translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                chimmy.get(0).translateObject(0.005f, 0.005f, 0f);
                chimmy.get(0).translateObject(badan_chimmy.x, badan_chimmy.y, 0f);


                koya.get(0).getChildObject().get(4).translateObject(-kaki_kiri_koya.x, -kaki_kiri_koya.y, 0f);
                koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                koya.get(0).getChildObject().get(4).translateObject(kaki_kiri_koya.x, kaki_kiri_koya.y, 0f);

                koya.get(0).getChildObject().get(5).translateObject(-kaki_kanan_koya.x, -kaki_kanan_koya.y, 0f);
                koya.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                koya.get(0).getChildObject().get(5).translateObject(kaki_kanan_koya.x, kaki_kanan_koya.y, 0f);

                koya.get(0).translateObject(-badan_koya.x, -badan_koya.y, 0f);
                koya.get(0).translateObject(0.005f, 0.005f, 0f);
                koya.get(0).translateObject(badan_koya.x, badan_koya.y, 0f);

                van.get(0).getChildObject().get(6).translateObject(-kaki_kiri_van.x, -kaki_kiri_van.y, 0f);
                van.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                van.get(0).getChildObject().get(6).translateObject(kaki_kiri_van.x, kaki_kiri_van.y, 0f);

                van.get(0).getChildObject().get(8).translateObject(-kaki_kanan_van.x, -kaki_kanan_van.y, 0f);
                van.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                van.get(0).getChildObject().get(8).translateObject(kaki_kanan_van.x, kaki_kanan_van.y, 0f);

                van.get(0).translateObject(-badan_van.x, -badan_van.y, 0f);
                van.get(0).translateObject(0.005f, 0.005f, 0f);
                van.get(0).translateObject(badan_van.x, badan_van.y, 0f);

                geserSemua += 1;
            }
            if (geserSemua == 20){
                geserSemua = 0;
            }
        }


        // tangan muter
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            Vector3f kanan = chimmy.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f, 0.0f, 0f));

            for (Object child : chimmy.get(0).getChildObject().get(1).getChildObject()) {
                child.translateObject(-kanan.x, -kanan.y, 0f);
                child.rotateObject((float) Math.toRadians(15f), 1f, 0f, 0f);
                child.translateObject(kanan.x, kanan.y, 0f);
            }

            Vector3f kiri = chimmy.get(0).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f, 0.0f, 0f));

            for (Object child : chimmy.get(0).getChildObject().get(2).getChildObject()) {
                child.translateObject(-kiri.x, -kiri.y, 0f);
                child.rotateObject((float) Math.toRadians(15f), 1f, 0f, 0f);
                child.translateObject(kiri.x, kiri.y, 0f);
            }
            Vector3f kiri2 = koya.get(0).getChildObject().get(6).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            koya.get(0).getChildObject().get(2).translateObject(-kiri2.x, -kiri2.y, 0f);
            koya.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(15f), 1f, 0f, 0f);
            koya.get(0).getChildObject().get(2).translateObject(kiri2.x, kiri2.y, 0f);

            Vector3f kanan2 = koya.get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            koya.get(0).getChildObject().get(3).translateObject(-kanan2.x, -kanan2.y, 0f);
            koya.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(15f), 1f, 0f, 0f);
            koya.get(0).getChildObject().get(3).translateObject(kanan2.x, kanan2.y, 0f);

            Vector3f kiri3 = van.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            van.get(0).getChildObject().get(2).translateObject(-kiri3.x, -kiri3.y, 0f);
            van.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(15f), 1f, 0f, 0f);
            van.get(0).getChildObject().get(2).translateObject(kiri3.x, kiri3.y, 0f);

            Vector3f kanan3 = van.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            van.get(0).getChildObject().get(4).translateObject(-kanan3.x, -kanan3.y, 0f);
            van.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(15f), 1f, 0f, 0f);
            van.get(0).getChildObject().get(4).translateObject(kanan3.x, kanan3.y, 0f);


        }

        // jalan di tempat
        if (window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f kiri = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                child.translateObject(-kiri.x, -kiri.y, 0f);
                child.rotateObject(-(float) Math.toRadians(arah * 1f), 1.0f, 0.0f, 0f);
                child.translateObject(kiri.x, kiri.y, 0f);
            }
            Vector3f kanan = chimmy.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy.get(0).getChildObject().get(3).getChildObject()) {
                child.translateObject(-kanan.x, -kanan.y, 0f);
                child.rotateObject(-(float) Math.toRadians(arah * 1f), -1.0f, 0.0f, 0f);
                child.translateObject(kanan.x, kanan.y, 0f);
            }

            chimmy.get(0).getChildObject().get(4).setDegrees(chimmy.get(0).getChildObject().get(4).getDegrees() + (arah * 1f));
            chimmy.get(0).getChildObject().get(3).setDegrees(chimmy.get(0).getChildObject().get(3).getDegrees() + (arah * 1f));
            if (arah == 1) {
                if (chimmy.get(0).getChildObject().get(3).getDegrees() >= 45f) {
                    arah = -1;
                }
            } else {
                if (chimmy.get(0).getChildObject().get(3).getDegrees() <= -45f) {
                    arah = 1;
                }
            }

            //koya
            Vector3f kiri2 = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            koya.get(0).getChildObject().get(4).translateObject(-kiri2.x, -kiri2.y, 0f);
            koya.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(arah * 1f), 1.0f, 0.0f, 0f);
            koya.get(0).getChildObject().get(4).translateObject(kiri2.x, kiri2.y, 0f);

            Vector3f kanan2 = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            koya.get(0).getChildObject().get(5).translateObject(-kanan2.x, -kanan2.y, 0f);
            koya.get(0).getChildObject().get(5).rotateObject(-(float) Math.toRadians(arah * 1f), 1.0f, 0.0f, 0f);
            koya.get(0).getChildObject().get(5).translateObject(kanan2.x, kanan2.y, 0f);

            if (arah == 1) {
                if (chimmy.get(0).getChildObject().get(3).getDegrees() >= 45f) {
                    arah = -1;
                }
            } else {
                if (chimmy.get(0).getChildObject().get(3).getDegrees() <= -45f) {
                    arah = 1;
                }
            }

            Vector3f kiri3 = van.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van.get(0).getChildObject().get(6).getChildObject()) {
                child.translateObject(-kiri3.x, -kiri3.y, 0f);
                child.rotateObject(-(float) Math.toRadians(arah * 1f), 1.0f, 0.0f, 0f);
                child.translateObject(kiri3.x, kiri3.y, 0f);
            }
            Vector3f kanan3 = van.get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van.get(0).getChildObject().get(8).getChildObject()) {
                child.translateObject(-kanan3.x, -kanan3.y, 0f);
                child.rotateObject(-(float) Math.toRadians(arah * 1f), -1.0f, 0.0f, 0f);
                child.translateObject(kanan3.x, kanan3.y, 0f);
            }

            van.get(0).getChildObject().get(5).setDegrees(van.get(0).getChildObject().get(5).getDegrees() + (arah * 1f));
            van.get(0).getChildObject().get(7).setDegrees(van.get(0).getChildObject().get(7).getDegrees() + (arah * 1f));
            if (arah == 1) {
                if (van.get(0).getChildObject().get(5).getDegrees() >= 45f) {
                    arah = -1;
                }
            } else {
                if (van.get(0).getChildObject().get(5).getDegrees() <= -45f) {
                    arah = 1;
                }
            }
        }

        // Geleng kepala
        if (window.isKeyPressed(GLFW_KEY_E)) {
            //van
            Vector3f tempCenterPoint = van.get(0).getChildObject().get(9).updateCenterPoint();
            van.get(0).getChildObject().get(9).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                    tempCenterPoint.z * -1);
            van.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                    tempCenterPoint.z * -1);


            van.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 1.0f, 0f);
            van.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 1.0f, 0f);
            van.get(0).getChildObject().get(9).setDegrees(van.get(0).getChildObject().get(9).getDegrees() + (0.5f * arah));
            if (van.get(0).getChildObject().get(9).getDegrees() >= 210f) {
                arah = -1;
            } else if (van.get(0).getChildObject().get(9).getDegrees() <= 150f) {
                arah = 1;
            }
            van.get(0).getChildObject().get(9).translateObject(tempCenterPoint.x, tempCenterPoint.y,
                    tempCenterPoint.z);
            van.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x, tempCenterPoint.y,
                    tempCenterPoint.z);

            //koya
            Vector3f tempCenterPoint2 = koya.get(0).getChildObject().get(0).updateCenterPoint();
            koya.get(0).getChildObject().get(0).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);
            koya.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);
            koya.get(0).getChildObject().get(12).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);

            koya.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 1.0f, 0f);
            koya.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 1.0f, 0f);
            koya.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 1.0f, 0f);
            koya.get(0).getChildObject().get(0).setDegrees(koya.get(0).getChildObject().get(0).getDegrees() + (0.5f * arah));
            if (koya.get(0).getChildObject().get(0).getDegrees() >= 210f) {
                arah = -1;
            } else if (koya.get(0).getChildObject().get(0).getDegrees() <= 150f) {
                arah = 1;
            }
            koya.get(0).getChildObject().get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);
            koya.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);
            koya.get(0).getChildObject().get(12).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);


            //chimmy
            Vector3f tempCenterPoint3 = chimmy.get(0).getChildObject().get(0).updateCenterPoint();
            chimmy.get(0).getChildObject().get(0).translateObject(tempCenterPoint3.x * -1, tempCenterPoint3.y * -1,
                    tempCenterPoint3.z * -1);

            chimmy.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 1.0f, 0f);
            chimmy.get(0).getChildObject().get(0).setDegrees(chimmy.get(0).getChildObject().get(0).getDegrees() + (0.5f * arah));
            if (chimmy.get(0).getChildObject().get(0).getDegrees() >= 210f) {
                arah = -1;
            } else if (chimmy.get(0).getChildObject().get(0).getDegrees() <= 150f) {
                arah = 1;
            }
            chimmy.get(0).getChildObject().get(0).translateObject(tempCenterPoint3.x, tempCenterPoint3.y,
                    tempCenterPoint3.z);
        }

        if (window.isKeyPressed(GLFW_KEY_R)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 1f, 0f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 1f, 0f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }

            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 1f, 0f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }

        }

        // Angguk kepala
        if (window.isKeyPressed(GLFW_KEY_T)) {
            //van
            Vector3f tempCenterPoint = van.get(0).getChildObject().get(5).updateCenterPoint();
            van.get(0).getChildObject().get(9).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                    tempCenterPoint.z * -1);
            van.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                    tempCenterPoint.z * -1);


            van.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(0.5f * arah), -1.0f, 0f, 0f);
            van.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(0.5f * arah), -1.0f, 0f, 0f);
            van.get(0).getChildObject().get(9).setDegrees(van.get(0).getChildObject().get(9).getDegrees() + (0.5f * arah));
            if (van.get(0).getChildObject().get(9).getDegrees() >= 200f) {
                arah = -1;
            } else if (van.get(0).getChildObject().get(9).getDegrees() <= 180f) {
                arah = 1;
            }
            van.get(0).getChildObject().get(9).translateObject(tempCenterPoint.x, tempCenterPoint.y,
                    tempCenterPoint.z);
            van.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x, tempCenterPoint.y,
                    tempCenterPoint.z);

            //koya
            Vector3f tempCenterPoint2 = koya.get(0).getChildObject().get(0).updateCenterPoint();
            koya.get(0).getChildObject().get(0).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);
            koya.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);
            koya.get(0).getChildObject().get(12).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);

            koya.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(0.5f * arah), -1.0f, 0f, 0f);
            koya.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(0.5f * arah), -1.0f, 0f, 0f);
            koya.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(0.5f * arah), -1.0f, 0f, 0f);
            koya.get(0).getChildObject().get(0).setDegrees(koya.get(0).getChildObject().get(0).getDegrees() + (0.5f * arah));

            if (koya.get(0).getChildObject().get(0).getDegrees() >= 200f) {
                arah = -1;
            } else if (koya.get(0).getChildObject().get(0).getDegrees() <= 180f) {
                arah = 1;
            }
            koya.get(0).getChildObject().get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);
            koya.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);
            koya.get(0).getChildObject().get(12).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);

            //chimmy
            Vector3f tempCenterPoint3 = chimmy.get(0).getChildObject().get(0).updateCenterPoint();
            chimmy.get(0).getChildObject().get(0).translateObject(tempCenterPoint3.x * -1, tempCenterPoint3.y * -1,
                    tempCenterPoint3.z * -1);

            chimmy.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(0.5f * arah), -1.0f, 0f, 0f);
            chimmy.get(0).getChildObject().get(0).setDegrees(koya.get(0).getChildObject().get(0).getDegrees() + (0.5f * arah));
            if (chimmy.get(0).getChildObject().get(0).getDegrees() >= 200f) {
                arah = -1;
            } else if (chimmy.get(0).getChildObject().get(0).getDegrees() <= 180f) {
                arah = 1;
            }
            chimmy.get(0).getChildObject().get(0).translateObject(tempCenterPoint3.x, tempCenterPoint3.y,
                    tempCenterPoint3.z);
        }


        //kaki kiri naik
        if (window.isKeyPressed(GLFW_KEY_A)) {
            if (pressKakiKiriNaik) {
                pressKakiKananNaik = false;
                pressKakiKananTurun = false;
                pressKakiKiriTurun = false;
                degKakiKiriTurun = 0;
                if (degKakiKiriNaik >= -0.4f) {
                    Vector3f kakiKiri = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0, 0, 0));
                    degKakiKiriNaik -= 0.1f;
//                    koya.get(0).getChildObject().get(4).translateObject(0.056f, 0.25f, 0.0f);
//                    koya.get(0).getChildObject().get(4).rotateObject(-degKakiKiriNaik, 1.0f, 0.0f, 0.0f);
//                    koya.get(0).getChildObject().get(4).translateObject(-0.056f, -0.25f, 0.0f);
                    koya.get(0).getChildObject().get(4).translateObject(-kakiKiri.x, -kakiKiri.y, 0.0f);
                    koya.get(0).getChildObject().get(4).rotateObject(-degKakiKiriNaik, 1.0f, 0.0f, 0.0f);
                    koya.get(0).getChildObject().get(4).translateObject(kakiKiri.x, kakiKiri.y, 0.0f);
                    kakiKiriNaik = true;
                    naik = true;
                } else if (naik) {
                    pressKakiKananNaik = true;
                    pressKakiKananTurun = true;
                    pressKakiKiriTurun = true;
                    if (kakiKananNaik && kakiKiriNaik) {
                        //buat duduk
                        koya.get(0).translateObject(0.0f, -0.05f, 0.0f);
//                        Vector3f kakiKiri = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0,0,0));
//                        koya.get(0).translateObject(kakiKiri.x, kakiKiri.y - 0.05f, 0.0f);

                        //mulut datar
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(0, -0.047f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(1, -0.046f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(2, -0.045f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(3, -0.0445f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(5, -0.0435f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(6, -0.043f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(7, -0.042f, -0.1214f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(8, -0.041f, -0.1214f);

                        //buat mata membesar
                        if (tutupMata) {
                            Vector3f mataKiri = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                            koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, 0.0f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 15f, 1.00f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(mataKiri.x, mataKiri.y, -0.0f);

                            Vector3f mataKanan = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                            koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-mataKanan.x, -mataKanan.y, 0.0f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 15f, 1.00f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(mataKanan.x, mataKanan.y, -0.0f);
                            tutupMata = false;
                            besarMataTutup = 0.0f;
                        }
                        turun = false;
                        naik = false;
                    }
                } else {
                    pressKakiKananNaik = true;
                    pressKakiKananTurun = true;
                    pressKakiKiriTurun = true;
                }
            }
        }

        //kaki kiri turun
        if (window.isKeyPressed(GLFW_KEY_S)) {
            System.out.println(pressKakiKiriTurun);
            if (pressKakiKiriTurun) {
                pressKakiKananNaik = false;
                pressKakiKananTurun = false;
                pressKakiKiriNaik = false;
                degKakiKiriNaik = 0;
                kakiKiriNaik = false;
                if (degKakiKiriTurun <= 0.4f) {
                    if (degKakiKananTurun != 0.5f) {
                        if (!turun) {
                            naik = false;
                            turun = true;
                            pressKakiKananNaik = true;
                            pressKakiKananTurun = true;
                            pressKakiKiriNaik = true;
                            //buat berdiri
//                            Vector3f kakiKiri = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0,0,0));
//                            koya.get(0).translateObject(kakiKiri.x, kakiKiri.y + 0.05f, 0.0f);
                            koya.get(0).translateObject(0.0f, 0.05f, 0.0f);
                        }
                    }
                    degKakiKiriTurun += 0.1;
                    Vector3f kakiKiri = koya.get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0, 0, 0));
                    koya.get(0).getChildObject().get(4).translateObject(-kakiKiri.x, -kakiKiri.y, 0.0f);
                    koya.get(0).getChildObject().get(4).rotateObject(-degKakiKiriTurun, 1.0f, 0.0f, 0.0f);
                    koya.get(0).getChildObject().get(4).translateObject(kakiKiri.x, kakiKiri.y, 0.0f);
                } else {
                    pressKakiKananNaik = true;
                    pressKakiKananTurun = true;
                    pressKakiKiriNaik = true;
                }
            }
        }

        //kaki kanan naik
        if (window.isKeyPressed(GLFW_KEY_D)) {
            if (pressKakiKananNaik) {
                kakiMulai = false;
                pressKakiKananTurun = false;
                pressKakiKiriNaik = false;
                pressKakiKiriTurun = false;
                degKakiKananTurun = 0;
                if (degKakiKananNaik >= -0.4f) {
                    degKakiKananNaik -= 0.1f;
                    Vector3f kakiKanan = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0, 0, 0));
                    koya.get(0).getChildObject().get(5).translateObject(-kakiKanan.x, -kakiKanan.y, 0.0f);
                    koya.get(0).getChildObject().get(5).rotateObject(-degKakiKananNaik, 1.0f, 0.0f, 0.0f);
                    koya.get(0).getChildObject().get(5).translateObject(kakiKanan.x, kakiKanan.y, 0.0f);
                    kakiKananNaik = true;
                    naik = true;

                } else if (naik) {
                    System.out.println("masuk");
                    pressKakiKananTurun = true;
                    pressKakiKiriNaik = true;
                    pressKakiKiriTurun = true;
                    if (kakiKananNaik && kakiKiriNaik) {
                        //buat duduk
                        koya.get(0).translateObject(0.0f, -0.05f, 0.0f);
//                        Vector3f kakiKanan = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0,0,0));
//                        koya.get(0).translateObject(kakiKanan.x, kakiKanan.y - 0.05f, 0.0f);

                        //mulut datar
                        if (mulutHappy) {
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(0, -0.047f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(1, -0.046f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(2, -0.045f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(3, -0.0445f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(5, -0.0435f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(6, -0.043f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(7, -0.042f, -0.1214f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(8, -0.041f, -0.1214f);
                        }

                        //buat mata membesar
                        if (tutupMata) {
                            Vector3f mataKiri = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                            koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, 0.0f);
//                            koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 1.2f, 1.00f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 15f, 1.00f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(mataKiri.x, mataKiri.y, -0.0f);

                            Vector3f mataKanan = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                            koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-mataKanan.x, -mataKanan.y, 0.0f);
//                            koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 1.2f, 1.00f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 15f, 1.00f);
                            koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(mataKanan.x, mataKanan.y, -0.0f);
                            tutupMata = false;
                            besarMataTutup = 0.0f;
                        }
                        turun = false;
                        naik = false;
                    }
                } else {
                    pressKakiKananTurun = true;
                    pressKakiKiriNaik = true;
                    pressKakiKiriTurun = true;
                }
            }
        }


        //kaki kanan turun
        if (window.isKeyPressed(GLFW_KEY_F)) {
            if (pressKakiKananTurun) {
                pressKakiKananNaik = false;
                pressKakiKiriNaik = false;
                pressKakiKiriTurun = false;
                kakiMulai = false;
                degKakiKananNaik = 0;
                kakiKananNaik = false;
                if (degKakiKananTurun <= 0.4f) {
                    if (degKakiKiriTurun != 0.5f) {
                        if (!turun) {
                            naik = false;
                            turun = true;
                            pressKakiKananNaik = true;
                            pressKakiKiriNaik = true;
                            pressKakiKiriTurun = true;
                            //buat berdiri
//                            Vector3f kakiKanan = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0,0,0));
//                            koya.get(0).translateObject(kakiKanan.x, kakiKanan.y + 0.05f, 0.0f);
                            koya.get(0).translateObject(0.0f, 0.05f, 0.0f);
                        }
                    }
                    degKakiKananTurun += 0.1f;
                    Vector3f kakiKanan = koya.get(0).getChildObject().get(9).model.transformPosition(new Vector3f(0, 0, 0));
                    koya.get(0).getChildObject().get(5).translateObject(-kakiKanan.x, -kakiKanan.y, 0.0f);
                    koya.get(0).getChildObject().get(5).rotateObject(-degKakiKananTurun, 1.0f, 0.0f, 0.0f);
                    koya.get(0).getChildObject().get(5).translateObject(kakiKanan.x, kakiKanan.y, 0.0f);
                } else {
                    pressKakiKananNaik = true;
                    pressKakiKiriNaik = true;
                    pressKakiKiriTurun = true;
                }
            }
        }
        //Mata membesar
        if (window.isKeyPressed(GLFW_KEY_G)) {
//            besarMataTutup = 0.9f;
            if (tutupMata) {
                if (!turun) {
                    if (besarMataBuka <= 1.5f) {
                        besarMataBuka += 0.1f;
                        Vector3f mataKiri = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 1.2f, 1.00f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(mataKiri.x, mataKiri.y, -0.0f);

                        Vector3f mataKanan = koya.get(0).getChildObject().get(12).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-mataKanan.x, -mataKanan.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 1.2f, 1.00f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(mataKanan.x, mataKanan.y, -0.0f);
                    } else {
                        tutupMata = false;
                        besarMataTutup = 0.0f;
                    }
                } else {
                    if (besarMataBuka <= 1.5f) {
                        besarMataBuka += 0.1f;
                        Vector3f mataKiri = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 1.2f, 1.00f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(mataKiri.x, mataKiri.y, -0.0f);

                        Vector3f mataKanan = koya.get(0).getChildObject().get(12).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-mataKanan.x, -mataKanan.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 1.2f, 1.00f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(mataKanan.x, mataKanan.y, -0.0f);
                    } else {
                        tutupMata = false;
                        besarMataTutup = 0.0f;
                    }
                }
            }
        }

        //Mata mengecil
        if (window.isKeyPressed(GLFW_KEY_H)) {
            if (!tutupMata) {
                if (!turun) {
                    if (besarMataTutup <= 1.5f) {
                        besarMataTutup += 0.1f;
                        Vector3f mataKiri = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 1.0f / 1.2f, 1.0f);
                        ;
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(mataKiri.x, mataKiri.y, -0.0f);

                        Vector3f mataKanan = koya.get(0).getChildObject().get(12).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-mataKanan.x, -mataKanan.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 1.0f / 1.2f, 1.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(mataKanan.x, mataKanan.y, -0.0f);

                    } else {
                        tutupMata = true;
                        besarMataBuka = 0.0f;
                    }
                } else {
                    if (besarMataTutup <= 1.5f) {
                        System.out.println("masuk");
                        besarMataTutup += 0.1f;

                        Vector3f mataKiri = koya.get(0).getChildObject().get(11).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 1.0f / 1.2f, 1.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(mataKiri.x, mataKiri.y, -0.0f);

                        Vector3f mataKanan = koya.get(0).getChildObject().get(12).model.transformPosition(new Vector3f(0, 0, 0));
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-mataKanan.x, -mataKanan.y, 0.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 1.0f / 1.2f, 1.0f);
                        koya.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(mataKanan.x, mataKanan.y, -0.0f);

                    } else {
                        tutupMata = true;
                        besarMataBuka = 0.0f;
                    }
                }

            }
        }

        //mulut melengkung (happy)
        if (window.isKeyPressed(GLFW_KEY_V)) {
            if (!mulutHappy) {
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(0, -0.047f, -0.1205f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(1, -0.046f, -0.121f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(2, -0.045f, -0.12127f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(3, -0.0445f, -0.12135f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(4, -0.044f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(5, -0.0435f, -0.12135f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(6, -0.043f, -0.12127f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(7, -0.042f, -0.121f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(8, -0.041f, -0.1205f);
                mulutHappy = true;
            }
        }

        //mulut datar
        if (window.isKeyPressed(GLFW_KEY_B)) {
            if (mulutHappy) {
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(0, -0.047f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(1, -0.046f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(2, -0.045f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(3, -0.0445f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(4, -0.044f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(5, -0.0435f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(6, -0.043f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(7, -0.042f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(8, -0.041f, -0.1214f);
                mulutHappy = false;
            }
        }

        if (window.isKeyPressed(GLFW_KEY_Z)) {
            if (belomZ < 10) {
                Vector3f kaki_kiri = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(4f), 0f, 0f, -1f);
                    child.translateObject(kaki_kiri.x, kaki_kiri.y, 0f);
                }
                Vector3f kepala = chimmy.get(0).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
                for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject()) {
                    child.translateObject(-kepala.x, -kepala.y, 0f);
                    child.rotateObject((float) Math.toRadians(1f), 0f, 0f, 1f);
                    child.translateObject(kepala.x, kepala.y, 0f);
                }
                Vector3f telinga_kiri = chimmy.get(0).getChildObject().get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
                for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject()) {
                    child.translateObject(-telinga_kiri.x, -telinga_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(2f), 0f, 0f, -1f);
                    child.translateObject(telinga_kiri.x, telinga_kiri.y, 0f);
                }
                Vector3f kanan = chimmy.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f, 0.0f, 0f));
                for (Object child : chimmy.get(0).getChildObject().get(1).getChildObject()) {
                    child.translateObject(-kanan.x, -kanan.y, 0f);
                    child.rotateObject((float) Math.toRadians(11f), 1f, 0f, 0f);
                    child.translateObject(kanan.x, kanan.y, 0f);
                }
                Vector3f kiri = chimmy.get(0).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f, 0.0f, 0f));
                for (Object child : chimmy.get(0).getChildObject().get(2).getChildObject()) {
                    child.translateObject(-kiri.x, -kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(11f), 1f, 0f, 0f);
                    child.translateObject(kiri.x, kiri.y, 0f);
                }
                belomZ += 1;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_X)) {
            if (belomZ > 0) {
                Vector3f kaki_kiri = chimmy.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
                for (Object child : chimmy.get(0).getChildObject().get(4).getChildObject()) {
                    child.translateObject(-kaki_kiri.x, -kaki_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(4f), 0f, 0f, 1f);
                    child.translateObject(kaki_kiri.x, kaki_kiri.y, 0f);
                }
                Vector3f kepala = chimmy.get(0).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
                for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject()) {
                    child.translateObject(-kepala.x, -kepala.y, 0f);
                    child.rotateObject((float) Math.toRadians(1f), 0f, 0f, -1f);
                    child.translateObject(kepala.x, kepala.y, 0f);
                }
                Vector3f telinga_kiri = chimmy.get(0).getChildObject().get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
                for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject()) {
                    child.translateObject(-telinga_kiri.x, -telinga_kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(2f), 0f, 0f, 1f);
                    child.translateObject(telinga_kiri.x, telinga_kiri.y, 0f);
                }
                Vector3f kanan = chimmy.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f, 0.0f, 0f));
                for (Object child : chimmy.get(0).getChildObject().get(1).getChildObject()) {
                    child.translateObject(-kanan.x, -kanan.y, 0f);
                    child.rotateObject((float) Math.toRadians(11f), -1f, 0f, 0f);
                    child.translateObject(kanan.x, kanan.y, 0f);
                }
                Vector3f kiri = chimmy.get(0).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f, 0.0f, 0f));
                for (Object child : chimmy.get(0).getChildObject().get(2).getChildObject()) {
                    child.translateObject(-kiri.x, -kiri.y, 0f);
                    child.rotateObject((float) Math.toRadians(11f), -1f, 0f, 0f);
                    child.translateObject(kiri.x, kiri.y, 0f);
                }
                belomZ -= 1;
            }
        }
        if (window.isKeyPressed(GLFW_KEY_C)) {
            Vector3f telinga_kiri = chimmy.get(0).getChildObject().get(0).getChildObject().get(8).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            Vector3f telinga_kanan = chimmy.get(0).getChildObject().get(0).getChildObject().get(7).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            if (belomC <= 20) {
                if (belomC < 10) {
                    for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject()) {
                        child.translateObject(-telinga_kiri.x, -telinga_kiri.y, 0f);
                        child.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                        child.translateObject(telinga_kiri.x, telinga_kiri.y, 0f);
                    }
                    for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject()) {
                        child.translateObject(-telinga_kanan.x, -telinga_kanan.y, 0f);
                        child.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                        child.translateObject(telinga_kanan.x, telinga_kanan.y, 0f);
                    }
                    belomC += 1;
                } else if (belomC < 20) {
                    for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject().get(8).getChildObject()) {
                        child.translateObject(-telinga_kiri.x, -telinga_kiri.y, 0f);
                        child.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                        child.translateObject(telinga_kiri.x, telinga_kiri.y, 0f);
                    }
                    for (Object child : chimmy.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject()) {
                        child.translateObject(-telinga_kanan.x, -telinga_kanan.y, 0f);
                        child.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, -1f);
                        child.translateObject(telinga_kanan.x, telinga_kanan.y, 0f);
                    }
                    belomC += 1;
                }
                if (belomC == 20) {
                    belomC = 0;
                }
            }
        }
        //mulut melengkung (happy)
        if (window.isKeyPressed(GLFW_KEY_V)) {
            if (!mulutHappy) {
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(0, -0.047f, -0.1205f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(1, -0.046f, -0.121f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(2, -0.045f, -0.12127f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(3, -0.0445f, -0.12135f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(4, -0.044f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(5, -0.0435f, -0.12135f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(6, -0.043f, -0.12127f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(7, -0.042f, -0.121f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(8, -0.041f, -0.1205f);
                mulutHappy = true;
            }
        }

        //mulut datar
        if (window.isKeyPressed(GLFW_KEY_B)) {
            if (mulutHappy) {
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(0, -0.047f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(1, -0.046f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(2, -0.045f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(3, -0.0445f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(4, -0.044f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(5, -0.0435f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(6, -0.043f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(7, -0.042f, -0.1214f);
                koya.get(0).getChildObject().get(0).getChildObject().get(3).changeVertices(8, -0.041f, -0.1214f);
                mulutHappy = false;
            }
        }

        // van


        // Miring kepala
        if (window.isKeyPressed(GLFW_KEY_N)) {
//            van.get(0).rotateObject(((float) Math.toRadians(0.5f)), 0.0f, 1.0f, 0.0f);
            Vector3f tempCenterPoint = van.get(0).getChildObject().get(5).updateCenterPoint();
            van.get(0).getChildObject().get(9).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                    tempCenterPoint.z * -1);
            van.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                    tempCenterPoint.z * -1);


            van.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 0f, 1.0f);
            van.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(0.5f * arah), 0f, 0f, 1.0f);
            van.get(0).getChildObject().get(9).setDegrees(van.get(0).getChildObject().get(9).getDegrees() + (0.5f * arah));
            if (van.get(0).getChildObject().get(9).getDegrees() >= 190f) {
                arah = -1;
            } else if (van.get(0).getChildObject().get(9).getDegrees() <= 170f) {
                arah = 1;
            }
            van.get(0).getChildObject().get(9).translateObject(tempCenterPoint.x, tempCenterPoint.y,
                    tempCenterPoint.z);
            van.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x, tempCenterPoint.y,
                    tempCenterPoint.z);
        }
        // Terbang INI CUMA VAN
        if (window.isKeyPressed(GLFW_KEY_M)) {
            Vector3f tempCenterPoint1 = van.get(0).getChildObject().get(2).updateCenterPoint();
            Vector3f tempCenterPoint2 = van.get(0).getChildObject().get(4).updateCenterPoint();
            van.get(0).getChildObject().get(2).translateObject(tempCenterPoint1.x * -1, tempCenterPoint1.y * -1,
                    tempCenterPoint1.z * -1);
            van.get(0).getChildObject().get(4).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1,
                    tempCenterPoint2.z * -1);

            if (!terbang && van.get(0).getHeight() + 0.003f < 0.3f) {
                if (van.get(0).getChildObject().get(2).getDegrees() <= 19f) {
                    van.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-0.5f), 0f, 0f, 1.0f);
                    van.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1.0f);
                    van.get(0).getChildObject().get(2).setDegrees(van.get(0).getChildObject().get(2).getDegrees() + (0.5f));
                }
                van.get(0).translateObject(0.0f, 0.003f, 0.0f);
                van.get(0).setHeight(van.get(0).getHeight() + (0.003f));

            } else if (van.get(0).getHeight() + 0.003f >= 0.3f || terbang) {
                if (van.get(0).getChildObject().get(2).getDegrees() > 0f) {
                    van.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1.0f);
                    van.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-0.5f), 0f, 0f, 1.0f);
                    van.get(0).getChildObject().get(2).setDegrees(van.get(0).getChildObject().get(2).getDegrees() - (0.5f));
                }

                van.get(0).translateObject(0.0f, -0.003f, 0.0f);
                van.get(0).setHeight(van.get(0).getHeight() - (0.003f));
                terbang = !(van.get(0).getHeight() <= 0f);
            }
            van.get(0).getChildObject().get(2).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,
                    tempCenterPoint1.z);
            van.get(0).getChildObject().get(4).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,
                    tempCenterPoint2.z);

            for (Object child : van.get(0).getChildObject()) {
                Vector3f tempCenterPoint = child.updateCenterPoint();
                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);
//                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                child.translateObject(tempCenterPoint.x, tempCenterPoint.y,
                        tempCenterPoint.z);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_J)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 1f, 0f, 0f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 1f, 0f, 0f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 1f, 0f, 0f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_K)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 1f, 0f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 1f, 0f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 1f, 0f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_L)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 0f, 1f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 0f, 1f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 0f, 1f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_U)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), -1f, 0f, 0f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), -1f, 0f, 0f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), -1f, 0f, 0f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_I)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, -1f, 0f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, -1f, 0f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, -1f, 0f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_O)) {
            Vector3f badan_chimmy = chimmy.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : chimmy) {
                child.translateObject(-badan_chimmy.x, -badan_chimmy.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 0f, -1f);
                child.translateObject(badan_chimmy.x, badan_chimmy.y, 0f);
            }
            Vector3f badan_van = van.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : van) {
                child.translateObject(-badan_van.x, -badan_van.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 0f, -1f);
                child.translateObject(badan_van.x, badan_van.y, 0f);
            }
            Vector3f badan_koya = koya.get(0).model.transformPosition(new Vector3f(0.0f, 0.0f, 0.0f));
            for (Object child : koya) {
                child.translateObject(-badan_koya.x, -badan_koya.y, 0f);
                child.rotateObject((float) Math.toRadians(4f), 0f, 0f, -1f);
                child.translateObject(badan_koya.x, badan_koya.y, 0f);
            }
        }


    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f
                    , 0.0f);
            GL.createCapabilities();
            input();
            //code
            for (Object bg: background) {
//                if (!(bg instanceof Sphere)){
//                    bg.drawCurve();
//                } else{
                bg.draw();
//                }

                for (Object child: bg.getChildObject()) {
                    child.draw();

                }
            }
//            for(Object object: chimmy){
//                if (!(object instanceof Sphere)){
//                    object.draw();
//                }
//                else {
//                    object.drawCurve();
//                }
//                for (Object child: object.getChildObject()) {
//                    if (!(child instanceof Sphere)){
//                        child.draw();
//                    }
//                    else {
//                        child.drawCurve();
//                    }
//                    for (Object grandchild: child.getChildObject()) {
//                        if (!(grandchild instanceof Sphere)){
//                            grandchild.draw();
//                        }
//                        else {
//                            grandchild.drawCurve();
//                        }
//                        for (Object greatgrandchild: grandchild.getChildObject()) {
//                            if (!(greatgrandchild instanceof Sphere)){
//                                greatgrandchild.draw();
//                            }
//                            else {
//                                greatgrandchild.drawCurve();
//                            }
//
//                        }
//                    }
//                }
//
//            }
            for (Object object : chimmy) {
                object.draw();
                for (Object child : object.getChildObject()) {
                    if (child instanceof Curve) {
                        child.drawLineChim();
                    } else {
                        child.draw();
                    }
                    for (Object grandchild : child.getChildObject()) {
                        if (grandchild instanceof Curve) {
                            grandchild.drawLineChim();
                        } else {
                            grandchild.draw();
                        }
                        for (Object greatgrandchild : grandchild.getChildObject()) {
                            if (greatgrandchild instanceof Curve) {
                                greatgrandchild.drawLineChim();
                            } else {
                                greatgrandchild.draw();
                            }
                        }
                    }
                }
            }
            for (Object object : van) {
                object.draw();
                for (Object child : object.getChildObject()) {
                    if (child instanceof Curve) {
                        child.drawLine();
                    } else {
                        child.draw();
                    }
                    for (Object grandchild : child.getChildObject()) {
                        if (grandchild instanceof Curve) {
                            grandchild.drawLine();
                        } else {
                            grandchild.draw();
                        }
                        for (Object greatgrandchild : grandchild.getChildObject()) {
                            if (greatgrandchild instanceof Curve) {
                                greatgrandchild.drawLine();
                            } else {
                                greatgrandchild.draw();
                            }
                        }
                    }
                }
            }
            for (Object object : koya) {
                object.draw();
                for (Object child : koya.get(0).getChildObject()) {
                    if (child instanceof Curve) {
                        child.drawLineChim();
                    } else {
                        child.draw();
                    }
                    for (Object cucu : child.getChildObject()) {
                        if (cucu instanceof Curve) {
                            cucu.drawLineChim();
                        } else {
                            cucu.draw();
                        }
                        for (Object cicit : cucu.getChildObject()) {
                            if (cicit instanceof Curve) {
                                cicit.drawLineChim();
                            } else {
                                cicit.draw();
                            }
                        }
                    }
                }
            }

            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }
    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}