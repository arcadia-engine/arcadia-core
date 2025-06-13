package com.arcadia.core.entity;

import java.util.ArrayList;
import java.util.List;

import com.arcadia.core.util.EngineLogger;

public class EntityManager {
    private final List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public List<Entity> getEntitiesWithAll(Class<? extends Component>... componentTypes) {
        List<Entity> result = new ArrayList<>();

        for (Entity e : entities) {
            boolean hasAll = true;
            for (Class<? extends Component> type : componentTypes) {
                if (e.getComponent(type) == null) {
                    hasAll = false;
                    break;
                }
            }
            if (hasAll) {
                result.add(e);
            }
        }

        EngineLogger.query("Found " + result.size() + " entities with ALL of: " + componentNames(componentTypes));
        return result;
    }

    private String componentNames(Class<? extends Component>[] types) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length; i++) {
            sb.append(types[i].getSimpleName());
            if (i < types.length - 1) sb.append(", ");
        }
        return sb.toString();
    }
}
