package main.Util;

import main.Main;
import processing.core.PApplet;

public class Color {
    public float r,g,b;
    public Color(float r, float g, float b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public int get(){
        return Main.app.color(r,g,b);
    }
    public static Color add(Color c,Color c1){
        return new Color(c.r+c1.r,c.g+c1.g,c.b+c1.b);
    }
    public static Color mult(Color c,float m){
        return new Color(c.r*m,c.g*m,c.b*m);
    }
    public Color add(Color c1){
        Color c = this;
        return new Color(c.r+c1.r,c.g+c1.g,c.b+c1.b);
    }
    public Color mult(float m){
        Color c = this;
        return new Color(c.r*m,c.g*m,c.b*m);
    }
}
