import dk.sdu.cbse.player.PlayerPlugin;

module player {
    exports dk.sdu.cbse.player;
    requires core;
    requires common;

    provides dk.sdu.cbse.common.services.IGamePluginService with PlayerPlugin;
}