package dk.sdu.cbse.common.data;

import java.io.Serializable;

public class Entity implements Serializable {
    private double x;
    private double y;
    private double radians;
    private final String ID = java.util.UUID.randomUUID().toString();
    private String type;
    private double[] shapeX = new double[4];
    private double[] shapeY = new double[4];

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}

    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    public double getRadians() {return radians;}
    public void setRadians(double radians) {this.radians = radians;}

    public void setShapeX(double[] shapeX) { this.shapeX = shapeX; }
    public double[] getShapeX() { return shapeX; }
    public void setShapeY(double[] shapeY) { this.shapeY = shapeY; }
    public double[] getShapeY() { return shapeY; }

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
