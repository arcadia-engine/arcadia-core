package com.arcadia.core.entity;

import com.arcadia.core.components.InputIntentComponent;
import com.arcadia.core.components.PlayerControlledComponent;
import com.arcadia.core.components.PositionComponent;
import com.arcadia.core.components.VelocityComponent;
import com.arcadia.core.util.EngineLogger;

public class EntityFactory {

    public static Entity createPlayer(double x, double y) {
        Entity player = new Entity();
        player.addComponent(new PositionComponent(x, y));
        player.addComponent(new VelocityComponent(0, 0));
        player.addComponent(new InputIntentComponent());
        player.addComponent(new PlayerControlledComponent()); // 👈 Required for input to activate
        EngineLogger.spawn("Created Player: " + player);
        return player;
    }

    public static Entity createWanderer(double x, double y) {
        Entity npc = new Entity();
        npc.addComponent(new PositionComponent(x, y));
        npc.addComponent(new VelocityComponent(Math.random() - 0.5, Math.random() - 0.5));
        EngineLogger.spawn("Created Wanderer: " + npc);
        return npc;
    }

    public static Entity createStaticObject(double x, double y) {
        Entity obj = new Entity();
        obj.addComponent(new PositionComponent(x, y));    
        EngineLogger.spawn("Created Static Object: " + obj);
        return obj;
    }
}
