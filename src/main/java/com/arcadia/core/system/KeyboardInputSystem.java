package com.arcadia.core.system;

import com.arcadia.core.components.InputIntentComponent;
import com.arcadia.core.components.PlayerControlledComponent;
import com.arcadia.core.entity.*;
import com.arcadia.core.util.EngineLogger;

import java.io.IOException;
import java.util.List;

public class KeyboardInputSystem implements GameSystem {
    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        char input = pollInput();

        List<Entity> entities = entityManager.getEntitiesWithAll(InputIntentComponent.class, PlayerControlledComponent.class);

        for (Entity e : entities) {
            InputIntentComponent intent = e.getComponent(InputIntentComponent.class);
            if (intent == null) continue;

            intent.clear();

            switch (input) {
                case 'w' -> intent.moveY = -1;
                case 's' -> intent.moveY = 1;
                case 'a' -> intent.moveX = -1;
                case 'd' -> intent.moveX = 1;
            }

            EngineLogger.debug("[INPUT] " + e + " received key: '" + input + "'");
        }
    }

    private char pollInput() {
        try {
            if (System.in.available() > 0) {
                return (char) System.in.read();
            }
        } catch (IOException e) {
            EngineLogger.error("Input read failed: " + e.getMessage());
        }
        return 0; // no input
    }
}
