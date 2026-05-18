module bullet {
    requires common;

    exports dk.sdu.cbse.bullet;

    provides dk.sdu.cbse.common.services.IGamePluginService with dk.sdu.cbse.bullet.BulletPlugin;
    provides dk.sdu.cbse.common.services.IEntityProcessingService with dk.sdu.cbse.bullet.BulletControlSystem;
}