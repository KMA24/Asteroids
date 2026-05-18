package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.data.Entity;

public class BulletPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        Bullet bullet = new Bullet();
        bullet.setType("bullet");

        // Small square or dot shape
        bullet.setShapeX(new double[]{1, -1, -1, 1});
        bullet.setShapeY(new double[]{1, 1, -1, -1});

        bullet.setX(gameData.getDisplayWidth() / 2.0);
        bullet.setY(gameData.getDisplayHeight() / 2.0 - 50); // Slightly offset from center
        bullet.setRadians(0); // Flying straight right


    }

    @Override
    public void stop(GameData gameData, World world) {
        for (dk.sdu.cbse.common.data.Entity bullet : world.getEntities(Bullet.class)) {
            world.removeEntity(bullet);
        }
    }
}
