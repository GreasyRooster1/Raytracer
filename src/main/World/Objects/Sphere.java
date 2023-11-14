package main.World.Objects;

import main.Util.Ray;
import main.World.World;
import main.World.WorldObject;

public class Sphere extends WorldObject {
    public Sphere(float x, float y, float z, float radius) {
        super(x, y, z, radius);
    }

    @Override
    public boolean isColliding(Ray ray) {
        Ray rayDirection = ray.normalize();
        Ray oc = Ray.sub(World.camera.asVec(), asVec());
        float a = rayDirection.dot(rayDirection);
        float b = 2.0f * oc.dot(rayDirection);
        float c = oc.dot(oc) - (size * size);

        // Find the discriminant of the quadratic equation
        float discriminant = b*b - 4*a*c;

        return discriminant >= 0;
    }
}
