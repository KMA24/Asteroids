package dk.sdu.cbse.map;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class Map implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        int width = gameData.getDisplayWidth();
        int height = gameData.getDisplayHeight();


         //Entities will wrap around the map
        for (Entity entity : world.getEntities()) {
            if ("bullet".equals(entity.getType())) {
                continue;
            }

            if (entity.getX() < 0) {
                entity.setX(entity.getX() + width);
            } else if (entity.getX() > width) {
                entity.setX(entity.getX() - width);
            }


            if (entity.getY() < 0) {
                entity.setY(entity.getY() + height);
            } else if (entity.getY() > height) {
                entity.setY(entity.getY() - height);
            }
        }
    }

}
