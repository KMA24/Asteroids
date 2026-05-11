package dk.sdu.cbse.map;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class MapPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world){
        System.out.println("Map Started");
    }

    @Override
    public void stop(GameData gameData, World world){
        System.out.println("Map Stopped");
    }
}
