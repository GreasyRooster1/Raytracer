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
    public boolean isColliding(Ray ray,Point p) {
        return !(pointOfCollision(ray,p)==null);
    }
    @Override
    public Point pointOfCollision(Ray ray) {
        return pointOfCollision(ray,World.camera.asPoint());
    }
    public Point pointOfCollision(Ray ray,Point p) {
        Ray p0 = p.asVec();
        Ray d = ray.normalize();
        Ray c = this.asVec();
        float r = size;

        Ray e = c.sub(p0);
        // Using Length here would cause floating point error to creep in
        float Esq = e.mag()*e.mag();
        float a = Ray.dot(e, d);
        float b = sqrt(Esq - (a * a));
        float f = sqrt((r * r) - (b * b));

        float t = a - f;
        // No collision
        if (r * r - Esq + a * a < 0f) {
            t= -1; // -1 is invalid.
            return null;
        }
        // Ray is inside
        else if (Esq < r * r) {
            t= a + f; // Just reverse direction\
            return new Point(ray.x, ray.y,ray.z);
        }
        // else Normal intersection

        Ray norm = ray.normalize();
        return new Point(norm.x*t,norm.y*t,norm.z*t);
    }
}
