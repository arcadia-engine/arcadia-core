package com.arcadia.core.entity;

import java.util.ArrayList;
import java.util.List;

import com.arcadia.core.util.EngineLogger;

public class EntityManager {
    private final List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public List<Entity> getEntitiesWith(Class<? extends Component> componentType) {
        List<Entity> result = new ArrayList<>();
        for (Entity e : entities) {
            if (e.getComponent(componentType) != null) {
                EngineLogger.query("Found " + result.size() + " entities with " + componentType.getSimpleName());
                result.add(e);
            }
        }
        return result;
    }
}
