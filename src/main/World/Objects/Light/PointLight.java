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
        Ray toLight = Ray.sub(asVec(),r.asVec());
        r=r.moveAlongRay(toLight,1E-45f);
        toLight = Ray.sub(asVec(),r.asVec());

        for(WorldObject o: World.objects){
            if(o.isColliding(toLight)) {
                return 0.3f;
            }
        }
        return 0.75f;
    }
}
