package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.services.IEntityProcessingService;






public class EnemyLogic implements IEntityProcessingService {
    private float Timer = 0;

    @Override
    public void process(GameData gameData, World world) {


        Timer += gameData.getTime();
        System.out.println("Timer ticking: " + Timer);

        for (Entity enemy : world.getEntities(Enemy.class)) {
            double speed = 0.3;
            double radians = enemy.getRadians();

            enemy.setX(enemy.getX() + Math.cos(radians) * speed);
            enemy.setY(enemy.getY() + Math.sin(radians) * speed);

            enemy.setRadians(radians + 0.001);
        }



        if (Timer >= 3.0f) {
            System.out.println("BANG! bullet Spawning");
            //makes sure all enemies shoots a bullet before restarting the timer
            for (Entity enemy : world.getEntities(Enemy.class)) {
                double radians = enemy.getRadians();

                Entity bullet = new dk.sdu.cbse.bullet.Bullet();
                bullet.setType("bullet");
                bullet.setShapeX(new double[]{2, -2, -2, 2});
                bullet.setShapeY(new double[]{2, 2, -2, -2});

                // Calculate spawning at the nose
                double noseX = enemy.getX() + Math.cos(radians) * 10;
                double noseY = enemy.getY() + Math.sin(radians) * 10;

                bullet.setX(noseX);
                bullet.setY(noseY);
                bullet.setRadians(radians);

                world.addEntity(bullet);
                System.out.println("BANG! Spawning bullet at X: " + noseX);
            }

            Timer = 0;
        }
    }

}
