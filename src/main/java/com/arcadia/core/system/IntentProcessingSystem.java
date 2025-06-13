package com.arcadia.core.system;

import com.arcadia.core.components.InputIntentComponent;
import com.arcadia.core.components.VelocityComponent;
import com.arcadia.core.entity.Entity;
import com.arcadia.core.entity.EntityManager;

import java.util.List;

public class IntentProcessingSystem implements GameSystem {
    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        List<Entity> entities = entityManager.getEntitiesWithAll(InputIntentComponent.class, VelocityComponent.class);
        for (Entity e : entities) {
            InputIntentComponent intent = e.getComponent(InputIntentComponent.class);
            VelocityComponent vel = e.getComponent(VelocityComponent.class);

            vel.dx = intent.moveX;
            vel.dy = intent.moveY;
        }
    }
}
