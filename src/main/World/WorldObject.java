package main.World;

import main.Main;
import main.Util.Ray;

public class WorldObject {
    public float x;
    public float y;
    public float z;
    public float size;
    public int albedo;
    protected WorldObject(float x, float y, float z, float size){
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
    }
    public WorldObject setAlbedo(int r, int g, int b){
        albedo = Main.app.color(r,g,b);
        return this;
    }
    public boolean isColliding(Ray ray){

        return false;
    }
    public Ray asVec(){
        return new Ray(x,y,z);
    }
}
