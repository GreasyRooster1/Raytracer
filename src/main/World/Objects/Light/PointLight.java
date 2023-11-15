package main.World.Objects.Light;

import main.Util.Point;
import main.Util.Ray;
import main.World.World;
import main.World.WorldObject;

public class PointLight extends Light {
    public PointLight(float x, float y, float z) {
        super(x, y, z);
    }

    @Override
    public float evaluateLightIntensity(Point r) {
//        Ray toLight = new Ray();
//        for(WorldObject o: World.objects){
//            if(o.isColliding(toLight)) {
//
//            }
//        }
        return 0.75f;
    }
}
