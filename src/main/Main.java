package main;

import main.Render.Renderer;
import processing.core.PApplet;

public class Main extends PApplet {
    public static Main app;
    public static int w;
    public static int h;
    public void settings() {
        size(100, 100);
        Main.setApp(this);
    }
    public void setup(){
        colorMode(RGB,1,1,1); //Color space mapped to 0-1 (UV)
        w = width;
        h = height;
    }
    private static void setApp(Main a) {
        app = a;
    }

    public void draw(){
        background(1,0,1);
        image(Renderer.render(),0,0);
        println("done");
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}