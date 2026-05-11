package dk.sdu.cbse.core;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ServiceLoader;

public class Game extends Application {

    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private Pane gameWindow;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {
        gameWindow = new Pane();
        gameWindow.setPrefSize(800, 600);
        gameData.setDisplayWidth(800);
        gameData.setDisplayHeight(600);

        //window color
        gameWindow.setStyle("-fx-background-color: #000000;");

        Scene scene = new Scene(gameWindow);
        window.setScene(scene);
        window.setTitle("ASTEROIDS");
        window.show();

        // Start Plugins
        for (IGamePluginService plugin : ServiceLoader.load(IGamePluginService.class)) {
            plugin.start(gameData, world);
        }

        renderLoop();
    }

    private void renderLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
            }
        }.start();
    }

    private void update() {
        for (IEntityProcessingService processor : ServiceLoader.load(IEntityProcessingService.class)) {
            processor.process(gameData, world);
        }
    }

    private void draw() {
        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon();
                polygon.setStroke(Color.GREEN);
                polygon.setFill(Color.WHITE);
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }

            // Move and Rotate the polygon
            polygon.getPoints().clear();
            for (int i = 0; i < entity.getShapeX().length; i++) {
                polygon.getPoints().addAll(
                        entity.getX() + entity.getShapeX()[i],
                        entity.getY() + entity.getShapeY()[i]
                );
            }
        }
    }
}