package com.arcadia.core.system;

import com.arcadia.core.entity.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class SystemManager {
    private final List<GameSystem> systems = new ArrayList<>();

    public void addSystem(GameSystem system) {
        systems.add(system);
    }

    public void removeSystem(Class<? extends GameSystem> type) {
        systems.removeIf(type::isInstance);
    }

    public <T extends GameSystem> T getSystem(Class<T> type) {
        for (GameSystem system : systems) {
            if (type.isInstance(system)) {
                return type.cast(system);
            }
        }
        return null;
    }

    public void updateAll(EntityManager entityManager, double deltaTime) {
        for (GameSystem system : systems) {
            system.update(entityManager, deltaTime); // ✅ Pass both params
        }
    }

    public List<GameSystem> getSystems() {
        return systems;
    }
}
