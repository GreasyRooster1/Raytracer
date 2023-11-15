package main.World.Objects;

import main.Util.Point;
import main.Util.Ray;
import main.World.World;
import main.World.WorldObject;

import static processing.core.PApplet.sqrt;

public class Sphere extends WorldObject {
    public Sphere(float x, float y, float z, float radius) {
        super(x, y, z, radius);
    }

    @Override
    public boolean isColliding(Ray ray) {
        return !(pointOfCollision(ray)==null);
    }

    @Override
    public Point pointOfCollision(Ray ray) {
        Ray p0 = World.camera.asVec();
        Ray d = ray.normalize();
        Ray c = this.asVec();
        float r = size;

        Ray e = c.sub(p0);
        // Using Length here would cause floating point error to creep in
        float Esq = e.mag()*e.mag();
        float a = Ray.dot(e, d);
        float b = sqrt(Esq - (a * a));
        float f = sqrt((r * r) - (b * b));

        float t;
        // No collision
        if (r * r - Esq + a * a < 0f) {
            t= -1; // -1 is invalid.
            return null;
        }
        // Ray is inside
        else if (Esq < r * r) {
            t= a + f; // Just reverse direction
        }
        // else Normal intersection
        t = a - f;
        Ray norm = ray.normalize();
        return new Point(norm.x*t,norm.y*t,norm.z*t);
    }
}
