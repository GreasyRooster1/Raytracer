package main.World.Objects.Light;

import main.Main;
import main.Util.Point;
import main.Util.Ray;
import main.World.World;
import main.World.WorldObject;

import static java.lang.Math.random;
import static processing.core.PApplet.*;

public class PointLight extends Light {
    public PointLight(float x, float y, float z) {
        super(x, y, z);
    }

    @Override
    public float evaluateLightIntensity(Point r) {
        println("Evaluating light intensity at ", r, " to ", asVec());
        Ray dir = Ray.sub(asVec(),r.asVec()).normalize();
        r=r.moveAlongRay(dir,0.00002f);
        Ray toLight = Ray.sub(asVec(),r.asVec());
        println("Post move along ray: ", r);

        for(WorldObject o: World.objects){
            if(o.isColliding(toLight,r)&&!o.pointOfCollision(toLight,r).eq(asPoint())) {
                println("Collision detected on route to light");
                println();
                return 0.3f;
            }
        }
        return 1f;
    }
    public Point asPoint(){
        return new Point(x,y,z);
    }
}
