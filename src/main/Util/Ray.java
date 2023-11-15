package main.Util;

import main.Main;
import main.Render.Renderer;
import main.World.Objects.Light.Light;
import main.World.World;
import main.World.WorldObject;

import static java.lang.Math.sqrt;

public class Ray {
    public float x,y,z;
    public Ray(float x ,float y,float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    //Methods
    
    public Ray normalize() {
        return new Ray(x/mag(),y/mag(),z/mag());
    }
    public float mag(){
        return (float) sqrt((x * x) + (y * y) + (z * z));
    }
    public float dot(Ray ray) {
        return dot(this,ray);
    }
    
    //Static Methods
    
    public static Ray sub(Ray a,Ray b){
        return new Ray(a.x-b.x,a.y-b.y,a.z-b.z);
    }
    public static float dot(Ray r1,Ray r2){
        return (r1.x*r2.x)+(r1.y*r2.y)+(r1.z*r2.z);
    }
    
    //Light
    
    public int evaluateColor() {
        for(WorldObject o:World.objects){
            if(o.isColliding(this)){
                Color out = o.albedo;
                for(Light l:World.lights) {
                    out = o.albedo.mult(out,l.evaluateLightIntensity(new Point(0,0,0)));
                }
                return out.get();
            }
        }
        return World.backgroundColor;
    }
}
