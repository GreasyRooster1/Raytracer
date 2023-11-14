package main.Render;

import main.Main;
import main.Util.Ray;
import main.World.Objects.Camera;
import processing.core.PImage;

import static processing.core.PApplet.floor;
import static processing.core.PConstants.RGB;

public class Renderer {
    public static Camera camera = new Camera(0,0,0);
    public static PImage render(){
        PImage img = Main.app.createImage(Main.w,Main.h,RGB);
        img.loadPixels();
        for (int i = 0; i < img.pixels.length; i++) {
            img.pixels[i] = renderPixel(i);
        }
        img.updatePixels();
        return img;
    }

    private static int renderPixel(int i) {
        float x = i%Main.w;
        float y = floor((float)i/Main.w);

        float vx = (Main.w*(x/Main.w))-Main.w/2f;
        float vy = (Main.h*(y/Main.h))-Main.h/2f;
        Ray ray = new Ray(1,vx,vy);

        return ray.evaluateColor();
    }
}
