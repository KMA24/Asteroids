package dk.sdu.cbse.common.data;

import java.io.Serializable;

public class Entity implements Serializable {
    private double x;
    private double y;
    private double radians;
    private final String ID = java.util.UUID.randomUUID().toString();
    private String type;

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}

    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    public double getRadians() {return radians;}
    public void setRadians(double radians) {this.radians = radians;}

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


}
