module core {
    exports dk.sdu.cbse.core;

    requires common; //core needs to require common to use the Interface from common

    uses dk.sdu.cbse.common.services.IGamePluginService;
}