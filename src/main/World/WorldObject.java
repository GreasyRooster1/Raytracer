package main.World;

import main.Main;
import main.Util.Color;
import main.Util.Point;
import main.Util.Ray;

import static processing.core.PApplet.dist;

public class WorldObject {
    public float x;
    public float y;
    public float z;
    public float size;
    public Color albedo;
    public long id;

    protected WorldObject(float x, float y, float z, float size){
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        this.id = (long) Main.app.random(-Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY);
    }
    public WorldObject setAlbedo(int r, int g, int b){
        albedo = new Color(r,g,b);
        return this;
    }
    public boolean isColliding(Ray ray){

        return false;
    }
    public boolean isColliding(Ray ray,Point p){

        return false;
    }
    public Point pointOfCollision(Ray ray){
        return new Point(0,0,0);
    }
    public Point pointOfCollision(Ray ray,Point p){
        return new Point(0,0,0);
    }
    public Ray asVec(){
        return new Ray(x,y,z);
    }
    public float distFromCam(){
        return dist(x,y,z,World.camera.x,World.camera.y,World.camera.z);
    }
}
