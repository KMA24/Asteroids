package dk.sdu.cbse.common.data;

public class GameData {

    private int displayWidth;
    private int displayHeight;
    private final GameKeys keys = new GameKeys();
    private float Time;

    public GameKeys getKeys() {
        return keys;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public float getTime() {
        return Time;
    }
    public void setTime(float Time) {
        this.Time = Time;
    }

}
