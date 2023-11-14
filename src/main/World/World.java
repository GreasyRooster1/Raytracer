package main.World;

import main.Util.Ray;
import main.World.Objects.Camera;
import main.World.Objects.Sphere;

import static processing.core.PApplet.append;
import static processing.core.PApplet.println;

public class World {
    public static WorldObject[] objects = {};
    public static int backgroundColor=0;
    public static Camera camera = new Camera(0,0,0);

    public static void createWorld(){
        add(new Sphere(11,0,0,10).setAlbedo(255,0,0));
    }

    public static void add(WorldObject object){
        objects = (WorldObject[]) append(objects,object);
        println(object.x,object.y,object.z);
    }
}
