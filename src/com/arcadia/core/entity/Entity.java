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
        Component c = components.get(type);
        if (c == null) return null;
        return type.cast(c);
    }

    @Override
    public String toString() {
        return "Entity[" + id.toString().substring(0, 8) + "]";
    }

}
