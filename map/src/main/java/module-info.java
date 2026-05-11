import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.map.MapPlugin;

module map {
    exports dk.sdu.cbse.map;

    requires common;

    provides IGamePluginService with MapPlugin;
}