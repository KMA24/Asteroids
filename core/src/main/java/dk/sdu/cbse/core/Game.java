package dk.sdu.cbse.core;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import java.util.ServiceLoader;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.data.Entity;


public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    public void run() {
        GameData gameData = new GameData();
        World world = new World();
        //size of the map
        gameData.setDisplayWidth(800);
        gameData.setDisplayHeight(600);

        //Initialise plugins
        for (IGamePluginService iGamePluginService : ServiceLoader.load(IGamePluginService.class)) {
            iGamePluginService.start(gameData, world);
        }

        //the gameloop
        while (true) {
            for (IEntityProcessingService processor : ServiceLoader.load(IEntityProcessingService.class)) {
                processor.process(gameData, world);
            }

            // Loop through all entities and find the one tagged "ENEMY"
            for (Entity entity : world.getEntities()) {
                //show enemy position in the terminal
                if ("Enemy1".equals(entity.getType())) {
                    System.out.printf("Enemy [%s] position: x=%.2f, y=%.2f\n",
                            entity.getID().substring(0, 4), entity.getX(), entity.getY());
                }
            }

            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}