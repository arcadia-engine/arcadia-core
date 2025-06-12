package com.arcadia.core.engine;

import java.util.ArrayList;
import java.util.List;

import com.arcadia.core.entity.*;
import com.arcadia.core.system.*;
import com.arcadia.core.util.*;

public class GameLoop {

    private boolean isRunning = false;
    private EntityManager entityManager;
    private List<GameSystem> systems;


    public GameLoop() {
        entityManager = new EntityManager();
        systems = new ArrayList<>();
        setup();
    }

    public void start() {
        isRunning = true;
        EngineLogger.info("🌀 Arcadia Engine started...");

        final int fps = 2;
        final double frameTime = 1000.0 / fps; // milliseconds per frame
        final double deltaTime = frameTime / 1000.0; // convert to seconds

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

    private void setup() {
        entityManager.addEntity(EntityFactory.createPlayer(10, 25));
        entityManager.addEntity(EntityFactory.createWanderer(5, 5));
        entityManager.addEntity(EntityFactory.createStaticObject(12, 7));

        systems.add(new InputSystem());
        systems.add(new MovementSystem());
        systems.add(new PhysicsSystem());
        systems.add(new RenderSystem());
    }

}
