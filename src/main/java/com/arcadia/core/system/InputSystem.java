package com.arcadia.core.system;

import com.arcadia.core.components.InputIntentComponent;
import com.arcadia.core.entity.*;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.util.EngineLogger;
import com.arcadia.demo.components.PlayerControlledComponent;

import java.util.List;

public class InputSystem implements GameSystem {
    private final InputProvider input;

    public InputSystem(InputProvider input) {
        this.input = input;
    }

    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        List<Entity> entities = entityManager.getEntitiesWithAll(InputIntentComponent.class);

        for (Entity e : entities) {
            if (e.getComponent(PlayerControlledComponent.class) == null) continue;

            InputIntentComponent intent = e.getComponent(InputIntentComponent.class);
            if (intent == null) continue;

            intent.clear();
            char key = input.pollInput();

            switch (key) {
                case 'w' -> intent.moveY = -1;
                case 's' -> intent.moveY = 1;
                case 'a' -> intent.moveX = -1;
                case 'd' -> intent.moveX = 1;
            }

            EngineLogger.debug("[INPUT] " + e + " received input: (" + intent.moveX + ", " + intent.moveY + ")");
        }
    }
}