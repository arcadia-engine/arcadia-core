package com.arcadia.core.system;

import com.arcadia.core.components.PositionComponent;
import com.arcadia.core.components.VelocityComponent;
import com.arcadia.core.entity.*;
import com.arcadia.core.util.*;

import java.util.List;

public class PhysicsSystem implements GameSystem {

    @Override
    public void update(EntityManager manager, double deltaTime) {
        List<Entity> entities = manager.getEntitiesWith(PositionComponent.class);

        for (Entity e : entities) {
            PositionComponent pos = e.getComponent(PositionComponent.class);
            VelocityComponent vel = e.getComponent(VelocityComponent.class);
            if (pos == null || vel == null) continue;

            pos.x += vel.dx * deltaTime;
            pos.y += vel.dy * deltaTime;

            EngineLogger.physics(e + " moved to Position(" + pos.x + ", " + pos.y + ")");
        }
    }

}