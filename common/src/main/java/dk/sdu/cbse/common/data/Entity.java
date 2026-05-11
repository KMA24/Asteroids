package dk.sdu.cbse.common.data;

public class Entity {
    private double x;
    private double y;
    private double radians;
    private final String ID = java.util.UUID.randomUUID().toString();

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}

    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    public double getRadians() {return radians;}
    public void setRadians(double radians) {this.radians = radians;}

    public String getID() {
        return ID;
    }
}
