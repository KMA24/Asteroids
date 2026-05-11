import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.player.PlayerPlugin;

module player {
    exports dk.sdu.cbse.player;

    requires common;

    provides IGamePluginService with PlayerPlugin;
}