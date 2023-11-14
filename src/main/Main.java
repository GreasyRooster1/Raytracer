package main;

import main.Render.Renderer;
import main.World.World;
import main.World.WorldObject;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
    public static Main app;
    public static int w;
    public static int h;
    public PImage screen;
    public void settings() {
        size(300, 300);
        Main.setApp(this);
    }
    public void setup(){
        colorMode(RGB,1,1,1);       //Color space mapped to 0-1 (UV)
        w = width;
        h = height;
        World.createWorld();
        screen = Renderer.render();
    }
    private static void setApp(Main a) {
        app = a;
    }

    public void draw(){
        background(1,0,1);
        image(screen,0,0,width,height);
        fill(frameCount%2);
    }

    public void keyPressed(){
        if(key==' '){
            screen = Renderer.render();
            println("done");
        }
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "main.Main" };
        PApplet.main(appletArgs);
    }
}