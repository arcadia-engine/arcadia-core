package com.arcadia.core.engine;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.scene.Scene;
import com.arcadia.core.system.SystemManager;
import com.arcadia.core.util.EngineLogger;

public class ArcadiaApp {

    private final SystemManager systemManager = new SystemManager();
    private final EntityManager entityManager = new EntityManager();

    private Renderer renderer;
    private InputProvider inputProvider;
    private Scene initialScene;
    private int fps = 60;

    public ArcadiaApp setRenderer(Renderer renderer) {
        this.renderer = renderer;
        return this;
    }

    public ArcadiaApp setInputProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        return this;
    }

    public ArcadiaApp setInitialScene(Scene scene) {
        this.initialScene = scene;
        return this;
    }

    public ArcadiaApp setFPS(int fps) {
        this.fps = fps;
        return this;
    }

    public void start() {
        if (renderer == null || inputProvider == null || initialScene == null) {
            throw new IllegalStateException("Missing required components: renderer, inputProvider, or initialScene.");
        }

        EngineLogger.info("📦 Loading scene...");
        initialScene.load(systemManager, entityManager);

        EngineLogger.info("🎮 Launching game loop...");
        GameLoop gameLoop = new GameLoop(entityManager, systemManager, renderer, inputProvider, fps);
        gameLoop.start();
    }
}
