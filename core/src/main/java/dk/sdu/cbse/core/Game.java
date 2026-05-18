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
import java.util.List;
import java.util.ArrayList;

public class Game extends Application {

    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private Pane gameWindow;
    private int printCounter;

    private final List<IEntityProcessingService> processors = new ArrayList<>();

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

        for (IEntityProcessingService processor : ServiceLoader.load(IEntityProcessingService.class)) {
            processors.add(processor);
        }

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
                gameData.setTime(0.0166f);
                update();
                draw();
            }
        }.start();
    }

    private void update() {
        for (IEntityProcessingService processor : processors) {
            processor.process(gameData, world);
        }
        //shows the enemy position
        if (printCounter++ >= 30) {
            for (Entity entity : world.getEntities()) {
                if ("Enemy1".equals(entity.getType())) {
                    System.out.printf("Enemy Position -> X: %.1f, Y: %.1f\n", entity.getX(), entity.getY());
                }
            }
            printCounter = 0;
        }
    }

    private void draw() {
        // Step A: Clean up old bullet polygons that were deleted by your BulletControlSystem
        polygons.entrySet().removeIf(entry -> {
            if (!world.getEntities().contains(entry.getKey())) {
                gameWindow.getChildren().remove(entry.getValue());
                return true;
            }
            return false;
        });

        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon();
                polygon.setFill(Color.TRANSPARENT);
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }

            // Step B: Explicitly set the stroke color every frame to guarantee visibility
            if ("bullet".equals(entity.getType())) {
                polygon.setStroke(Color.RED);
                polygon.setStrokeWidth(2); // Make it slightly thicker so it's easy to spot!
            } else {
                polygon.setStroke(Color.GREEN);
                polygon.setStrokeWidth(1);
            }

            polygon.getPoints().clear();
            for (int i = 0; i < entity.getShapeX().length; i++) {
                polygon.getPoints().addAll(
                        entity.getX() + entity.getShapeX()[i],
                        entity.getY() + entity.getShapeY()[i]
                );
            }

            double degrees = Math.toDegrees(entity.getRadians());
            polygon.setRotate(degrees);
        }
    }
}