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
        add(new Sphere(100,0,0,20).setAlbedo((float) 252 /255, (float) 186 /255, (float) 3 /255));

        addLight(new PointLight(100,0,50));
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
