package com.arcadia.core;

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


        final int fps = 60;
        final double frameTime = 1000.0 / fps;

        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= frameTime) {
                update();
                render();
                lastTime = currentTime;
            }
        }
    }

    private void update() {
        for (GameSystem system : systems) {
            system.update(entityManager);
        }
    }

    private void render() {
        EngineLogger.debug("Rendering player on screen...");
    }

    public void stop() {
        isRunning = false;
        EngineLogger.info("🛑 Arcadia Engine stopped.");
    }

    private void setup() {
        Entity player = new Entity();
        player.addComponent(new PositionComponent(10, 25));
        player.addComponent(new VelocityComponent(1, 0));
        entityManager.addEntity(player);

        systems.add(new PhysicsSystem());
    }

}
