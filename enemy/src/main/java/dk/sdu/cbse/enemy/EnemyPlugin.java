package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService{

    @Override
    public void start(GameData gameData, World world) {
        Enemy enemy = new Enemy();
        enemy.setType("Enemy1");
        enemy.setX(gameData.getDisplayWidth() / 2 + 100);
        enemy.setY(gameData.getDisplayHeight() / 2 + 100);
        enemy.setRadians(Math.random() * Math.PI * 2);
        world.addEntity(enemy);
        enemy.setShapeX(new double[]{10, -5, -3, -5});
        enemy.setShapeY(new double[]{0, -5, 0, 5});

        System.out.println("Enemy Started");
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (dk.sdu.cbse.common.data.Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }

}
