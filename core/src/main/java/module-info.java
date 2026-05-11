import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;

module core {
    exports dk.sdu.cbse.core;


    requires common; //core needs to require common to use the Interface from common

    //core uses these interfaces
    uses IEntityProcessingService;
    uses IGamePluginService;
}