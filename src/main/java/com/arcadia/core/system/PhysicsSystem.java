package com.arcadia.core.system;

import com.arcadia.core.components.PositionComponent;
import com.arcadia.core.components.VelocityComponent;
import com.arcadia.core.collision.CollisionProvider;
import com.arcadia.core.entity.*;
import com.arcadia.core.util.EngineLogger;

import java.util.List;

/**
 * Moves entities based on their velocity, if the destination is walkable.
 */
public class PhysicsSystem implements GameSystem {
    private final CollisionProvider collision;

    public PhysicsSystem(CollisionProvider collision) {
        this.collision = collision;
    }

    @Override
    public void update(EntityManager manager, double deltaTime) {
        List<Entity> entities = manager.getEntitiesWithAll(PositionComponent.class, VelocityComponent.class);
        for (Entity e : entities) {
            PositionComponent pos = e.getComponent(PositionComponent.class);
            VelocityComponent vel = e.getComponent(VelocityComponent.class);

            int nextX = (int) (pos.x + vel.dx);
            int nextY = (int) (pos.y + vel.dy);

            if (collision.isWalkable(nextX, nextY)) {
                pos.x = nextX;
                pos.y = nextY;
                EngineLogger.physics("[MOVE] " + e + " to Position(" + pos.x + ", " + pos.y + ")");
            } else {
                EngineLogger.physics("[BLOCKED] " + e + " at Position(" + nextX + ", " + nextY + ")");
            }

            vel.dx = 0;
            vel.dy = 0;
        }
    }
}
