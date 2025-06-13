package com.arcadia.core.engine;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.system.GameSystem;
import com.arcadia.core.scene.Scene;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.util.*;

import java.util.ArrayList;
import java.util.List;

public class ArcadiaApp {

    private final List<GameSystem> systems = new ArrayList<>();
    private final EntityManager entityManager = new EntityManager();

    private Renderer renderer;
    private InputProvider inputProvider;
    private Scene initialScene;

    public ArcadiaApp setRenderer(Renderer renderer) {
        this.renderer = renderer;
        return this;
    }

    public ArcadiaApp setInputProvider(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
        return this;
    }

    public ArcadiaApp registerSystem(GameSystem system) {
        this.systems.add(system);
        return this;
    }

    public ArcadiaApp setInitialScene(Scene scene) {
        this.initialScene = scene;
        return this;
    }

    public void start() {
        EngineLogger.info("Starting ArcadiaApp...");

        if (renderer == null || inputProvider == null) {
            throw new IllegalStateException("Renderer and InputProvider must be set.");
        }

        if (initialScene != null) {
            initialScene.load(entityManager);
        }

        GameLoop loop = new GameLoop(entityManager, systems, renderer, inputProvider);
        loop.start();
    }
}
