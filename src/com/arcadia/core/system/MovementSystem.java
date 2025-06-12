package com.arcadia.core.system;

import com.arcadia.core.entity.*;
import com.arcadia.core.util.EngineLogger;

import java.util.List;

public class MovementSystem implements GameSystem {
    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        List<Entity> entities = entityManager.getEntitiesWith(InputIntentComponent.class);

        for (Entity e : entities) {
            InputIntentComponent intent = e.getComponent(InputIntentComponent.class);
            VelocityComponent velocity = e.getComponent(VelocityComponent.class);

            if (intent == null || velocity == null) continue;

            velocity.dx = intent.moveX;
            velocity.dy = intent.moveY;

            EngineLogger.debug("[MOVE] " + e + " velocity set to (" + velocity.dx + ", " + velocity.dy + ")");
        }
    }
}