package com.arcadia.core.system;

import com.arcadia.core.components.InputIntentComponent;
import com.arcadia.core.components.PlayerControlledComponent;
import com.arcadia.core.entity.*;
import com.arcadia.core.util.EngineLogger;

import java.util.List;

public class InputSystem implements GameSystem {
    private int tickCounter = 0;

    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        List<Entity> entities = entityManager.getEntitiesWith(InputIntentComponent.class);

        for (Entity e : entities) {
            if (e.getComponent(PlayerControlledComponent.class) == null) continue;
            InputIntentComponent intent = e.getComponent(InputIntentComponent.class);
            if (intent == null) continue;

            intent.clear();

            int phase = (tickCounter / 30) % 4;
            switch (phase) {
                case 0 -> intent.moveX = 1;  // D
                case 1 -> intent.moveY = -1; // W
                case 2 -> intent.moveX = -1; // A
                case 3 -> intent.moveY = 1;  // S
            }

            EngineLogger.debug("[INPUT] " + e + " simulated intent: (" + intent.moveX + ", " + intent.moveY + ")");
        }
    }
}
