package main.World.Objects.Light;

import main.Util.Point;
import main.Util.Ray;
import main.World.World;
import main.World.WorldObject;

import static processing.core.PApplet.*;

public class PointLight extends Light {
    public PointLight(float x, float y, float z) {
        super(x, y, z);
    }

    @Override
    public float evaluateLightIntensity(Point r) {
        Ray dir = Ray.sub(asVec(),r.asVec());
        r=r.moveAlongRay(dir,1E-20f);
        Ray toLight = Ray.sub(asVec(),r.asVec());
        println(toLight.x,toLight.y,toLight.z);
        for(WorldObject o: World.objects){
            if(o.isColliding(toLight,r)) {
                return 0.3f;
            }
        }
        return 1f;
    }
}
