package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        int width = gameData.getDisplayWidth();
        int height = gameData.getDisplayHeight();

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double speed = 0.75; //bullet speed
            double radians = bullet.getRadians();

            bullet.setX(bullet.getX() + Math.cos(radians) * speed);
            bullet.setY(bullet.getY() + Math.sin(radians) * speed);

            if (bullet.getX() < 0 || bullet.getX() > width || bullet.getY() < 0 || bullet.getY() > height) {
                world.removeEntity(bullet); //removes bullet if it hits the edge of the map
            }
        }
    }
}