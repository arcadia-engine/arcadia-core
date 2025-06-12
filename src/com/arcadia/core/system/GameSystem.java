package com.arcadia.core.system;

import com.arcadia.core.entity.EntityManager;

public interface GameSystem {
    void update(EntityManager entityManager, double deltaTime);
}
