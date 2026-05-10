package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.GameData; //use gamedata from the common module
import dk.sdu.cbse.common.data.World; //use world from the common module
import dk.sdu.cbse.common.services.IGamePluginService; //use the interface from the common module


//uses the interface from the common module
public class PlayerPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        System.out.println("Player Started");
    }

    @Override
    public void stop(GameData gameData, World world) {
        System.out.println("Player Stopped");
    }
}
