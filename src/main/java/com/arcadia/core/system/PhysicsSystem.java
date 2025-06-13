package com.arcadia.core.system;

import com.arcadia.core.components.PositionComponent;
import com.arcadia.core.components.VelocityComponent;
import com.arcadia.core.entity.*;
import com.arcadia.core.util.EngineLogger;
import com.arcadia.demo.map.MapManager;

import java.util.List;

public class PhysicsSystem implements GameSystem {
    private final MapManager mapManager;

    public PhysicsSystem(MapManager mapManager) {
        this.mapManager = mapManager;
    }

    @Override
    public void update(EntityManager manager, double deltaTime) {
        List<Entity> entities = manager.getEntitiesWithAll(PositionComponent.class, VelocityComponent.class);
        for (Entity e : entities) {
            PositionComponent pos = e.getComponent(PositionComponent.class);
            VelocityComponent vel = e.getComponent(VelocityComponent.class);

            // Compute destination
            int nextX = (int) (pos.x + vel.dx);
            int nextY = (int) (pos.y + vel.dy);

            // Collision check
            if (mapManager.getTile(nextX, nextY).isWalkable()) {
                pos.x = nextX;
                pos.y = nextY;
                EngineLogger.physics("[MOVE] " + e + " to Position(" + pos.x + ", " + pos.y + ")");
            } else {
                EngineLogger.physics("[BLOCKED] " + e + " at Position(" + nextX + ", " + nextY + ")");
            }

            // Optional: reset velocity to zero after tile step
            vel.dx = 0;
            vel.dy = 0;
        }
    }
}
