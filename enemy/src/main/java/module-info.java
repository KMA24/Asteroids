import dk.sdu.cbse.enemy.EnemyLogic;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IEntityProcessingService;

module enemy {
    exports dk.sdu.cbse.enemy;

    requires common;

    provides IGamePluginService with EnemyPlugin;
    provides IEntityProcessingService with EnemyLogic;


}