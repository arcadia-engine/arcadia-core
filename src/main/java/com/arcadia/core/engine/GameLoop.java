package com.arcadia.core.engine;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.system.SystemManager;
import com.arcadia.core.util.EngineLogger;

public class GameLoop {

    private final EntityManager entityManager;
    private final SystemManager systemManager;
    private final Renderer renderer;
    private final InputProvider input;

    private final int fps;
    private final double frameTime;
    private final double deltaTime;

    private boolean isRunning = false;

    public GameLoop(EntityManager entityManager, SystemManager systemManager, Renderer renderer, InputProvider input, int fps) {
        this.entityManager = entityManager;
        this.systemManager = systemManager;
        this.renderer = renderer;
        this.input = input;
        this.fps = fps;

        this.frameTime = 1000.0 / fps;
        this.deltaTime = frameTime / 1000.0;
    }

    public void start() {
        isRunning = true;
        EngineLogger.info("🌀 Arcadia Engine started...");

        long lastTime = System.currentTimeMillis();
        long accumulator = 0;

        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsed = currentTime - lastTime;
            lastTime = currentTime;
            accumulator += elapsed;

            while (accumulator >= frameTime) {
                update(deltaTime);
                accumulator -= frameTime;
            }

            long frameDuration = System.currentTimeMillis() - currentTime;
            long sleepTime = (long) frameTime - frameDuration;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    EngineLogger.error("Game loop interrupted: " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void update(double deltaTime) {
        systemManager.updateAll(entityManager, deltaTime);
    }

    public void stop() {
        isRunning = false;
        EngineLogger.info("🛑 Arcadia Engine stopped.");
    }
}
