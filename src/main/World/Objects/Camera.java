package main.World.Objects;

import main.Main;
import main.Util.Ray;
public class Camera {
    public float x,y,z;
    public Camera(float x, float y, float z){
        this.x = x;
        this.y=y;
        this.z=z;
    }
    public Ray asVec(){
        return new Ray(x,y,z);
    }

}
