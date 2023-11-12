package main.Util;

import main.Main;

import static java.lang.Math.sqrt;

public class Ray {
    public float x,y,z;
    public Ray(float x ,float y,float z){

    }
    public int rgb(){
        Ray norm = normalized();
        return Main.app.color(norm.x,norm.y,norm.z);
    }
    public Ray normalized(){
        return new Ray(x/mag(),y/mag(),z/mag());
    }
    public float mag(){
        return (float) sqrt((x * x) + (y * y) + (z * z));
    }
}
