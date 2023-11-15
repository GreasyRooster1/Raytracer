package main.World.Objects.Light;

import main.Util.Color;
import main.Util.Point;
import main.Util.Ray;
import main.World.WorldObject;

public class Light extends WorldObject {
    public Color color;

    protected Light(float x, float y, float z) {
        super(x, y, z, 0);
    }
    public float evaluateLightIntensity(Point p){
        return 0;
    }
    public Light setColor(int r, int g, int b){
        color = new Color(r,g,b);
        return this;
    }
}
