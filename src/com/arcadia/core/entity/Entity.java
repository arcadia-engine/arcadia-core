package com.arcadia.core.entity;

import java.util.UUID;
import java.util.HashMap;

public class Entity {
    private final UUID id = UUID.randomUUID();
    private final HashMap<Class<? extends Component>, Component> components = new HashMap<>();

    public UUID getId() {
        return id;
    }

    public void addComponent(Component component) {
        components.put(component.getClass(), component);
    }

    public <T extends Component> T getComponent(Class<T> type) {
        return type.cast(components.get(type));
    }
}
