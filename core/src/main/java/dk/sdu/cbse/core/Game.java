package dk.sdu.cbse.core;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import java.util.ServiceLoader;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    public void run() {
        GameData gameData = new GameData();
        World world = new World();

        System.out.println("Scanning for modules...");

        // Try to find the Player module
        ServiceLoader<IGamePluginService> loader = ServiceLoader.load(IGamePluginService.class);

        for (IGamePluginService plugin : loader) {
            plugin.start(gameData, world);
        }

        System.out.println("Scan complete.");
    }
}