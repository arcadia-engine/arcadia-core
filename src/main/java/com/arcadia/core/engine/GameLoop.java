package com.arcadia.core.engine;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.system.GameSystem;
import com.arcadia.core.util.EngineLogger;

import java.util.List;

public class GameLoop {

    private final EntityManager entityManager;
    private final List<GameSystem> systems;
    private final Renderer renderer;
    private final InputProvider input;

    private boolean isRunning = false;

    public GameLoop(EntityManager entityManager, List<GameSystem> systems,
                    Renderer renderer, InputProvider input) {
        this.entityManager = entityManager;
        this.systems = systems;
        this.renderer = renderer;
        this.input = input;
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
