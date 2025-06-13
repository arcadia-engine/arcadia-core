package com.arcadia.core.engine;

import java.util.ArrayList;
import java.util.List;

import com.arcadia.core.entity.*;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.map.MapManager;
import com.arcadia.core.system.*;
import com.arcadia.core.util.EngineLogger;

public class GameLoop {

    private final EntityManager entityManager;
    private final List<GameSystem> systems;
    private final MapManager mapManager;
    private final Renderer renderer;
    private final InputProvider input;

    private boolean isRunning = false;

    public GameLoop(Renderer renderer, InputProvider input) {
        this.renderer = renderer;
        this.input = input;
        this.entityManager = new EntityManager();
        this.systems = new ArrayList<>();
        this.mapManager = new MapManager(new String[] {
                "####################",
                "#..................#",
                "#..####............#",
                "#..................#",
                "####################"
        });

        setup();
    }

    private void setup() {
        entityManager.addEntity(EntityFactory.createPlayer(2, 3));         // just above wall
        entityManager.addEntity(EntityFactory.createWanderer(2, 2));       // inside walkable zone
        entityManager.addEntity(EntityFactory.createStaticObject(3, 2));   // right of above

        systems.add(new InputSystem(input));
        systems.add(new MovementSystem());
        systems.add(new PhysicsSystem(mapManager));
        systems.add(new RenderSystem(mapManager, renderer));
    }

    public void start() {
        isRunning = true;
        EngineLogger.info("🌀 Arcadia Engine started...");

        final int fps = 2;
        final double frameTime = 1000.0 / fps;
        final double deltaTime = frameTime / 1000.0;

        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= frameTime) {
                update(deltaTime);
                lastTime = currentTime;
            }
        }
    }

    private void update(double deltaTime) {
        for (GameSystem system : systems) {
            system.update(entityManager, deltaTime);
        }
    }

    public void stop() {
        isRunning = false;
        EngineLogger.info("🛑 Arcadia Engine stopped.");
    }
}