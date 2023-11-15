package main.World;

import main.Util.Ray;
import main.World.Objects.Camera;
import main.World.Objects.Light.Light;
import main.World.Objects.Light.PointLight;
import main.World.Objects.Sphere;

import static processing.core.PApplet.append;
import static processing.core.PApplet.println;

public class World {
    public static WorldObject[] objects = {};
    public static Light[] lights = {};
    public static int backgroundColor=0;
    public static Camera camera = new Camera(0,0,0);

    public static void createWorld(){
        //COLOR IS UV
        add(new Sphere(2.02f,0,0,1.999f).setAlbedo(0,0,1));
        add(new Sphere(2.01f,1,0,1.999f).setAlbedo(1,0,1));
        add(new Sphere(2,0,0,1.999f).setAlbedo(1,0,0));

        addLight(new PointLight(2.001f,0f,1f));
    }

    public static void add(WorldObject object){
        objects = (WorldObject[]) append(objects,object);
        println(object.x,object.y,object.z);
    }
    public static void addLight(Light object){
        lights = (Light[]) append(lights,object);
        println(object.x,object.y,object.z);
    }
}
