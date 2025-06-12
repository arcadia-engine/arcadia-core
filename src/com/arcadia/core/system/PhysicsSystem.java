package com.arcadia.core.system;

import com.arcadia.core.entity.*;
import com.arcadia.core.util.*;

import java.util.List;

public class PhysicsSystem implements GameSystem {

    @Override
    public void update(EntityManager manager) {
        List<Entity> entities = manager.getEntitiesWith(PositionComponent.class);

        for (Entity e : entities) {
            PositionComponent pos = e.getComponent(PositionComponent.class);
            VelocityComponent vel = e.getComponent(VelocityComponent.class);
            if (pos == null || vel == null) continue;

            pos.x += vel.dx;
            pos.y += vel.dy;

            EngineLogger.debug("PhysicsSystem → Entity " + e.getId() + " moved to " + pos);

        }
    }
}