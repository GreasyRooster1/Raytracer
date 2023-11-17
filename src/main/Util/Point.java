package main.Util;

public class Point {
    public float x,y,z;
    public Point(float x ,float y,float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Ray asVec(){
        return new Ray(x,y,z);
    }

    public boolean eq(Point p) {
        return (p.x==x)&&(p.y==y)&&(p.z==z);
    }

    public Point moveAlongRay(Ray toLight, float v) {
        Ray norm = toLight.normalize();
        return new Point(x+norm.x*v,y+norm.y*v,z+norm.z*v);
    }
}
