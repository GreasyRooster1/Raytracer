package main.Render;

import main.Main;
import main.World.Camera;
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
        float y = floor((float)i/Main.h);

        return Main.app.color(x/Main.app.width,y/Main.app.height,0);
    }
}
