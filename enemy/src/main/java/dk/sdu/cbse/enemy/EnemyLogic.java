package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;

import dk.sdu.cbse.common.services.IEntityProcessingService;


public class EnemyLogic implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {

            double speed = 1;
            double radians = enemy.getRadians();

            enemy.setX(enemy.getX() + Math.cos(radians) * speed);
            enemy.setY(enemy.getY() + Math.sin(radians) * speed);

            enemy.setRadians(radians + 0.2);
        }
    }

}
