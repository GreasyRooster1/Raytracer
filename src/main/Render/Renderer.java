package main.Render;

import main.Main;
import main.Util.Ray;
import main.World.Objects.Camera;
import main.World.World;
import main.World.WorldObject;
import processing.core.PImage;

import static processing.core.PApplet.floor;
import static processing.core.PConstants.RGB;

public class Renderer {
    public static PImage render(){
        PImage img = Main.app.createImage(Main.w,Main.h,RGB);
        img.loadPixels();
        sortWorld();
        for (int i = 0; i < img.pixels.length; i++) {
            img.pixels[i] = renderPixel(i);
        }
        img.updatePixels();
        return img;
    }
    private static void sortWorld(){
        WorldObject[] arr = World.objects;
        int n = arr.length;
        int i;
        int j;
        WorldObject temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j].distFromCam() > arr[j + 1].distFromCam()) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
        World.objects = arr;
    }

    private static int renderPixel(int i) {
        float x = i%Main.w;
        float y = floor((float)i/Main.w);

        float vx = World.camera.y+(Main.w*(x/Main.w))-Main.w/2f;
        float vy = World.camera.z+(Main.h*(y/Main.h))-Main.h/2f;
        Ray ray = new Ray(World.camera.x+1,vx,vy);

        return ray.evaluateColor();
    }
}
