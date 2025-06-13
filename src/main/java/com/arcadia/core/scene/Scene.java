package com.arcadia.core.scene;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.system.SystemManager;

public interface Scene {
    void load(SystemManager systemManager, EntityManager entityManager);
}
