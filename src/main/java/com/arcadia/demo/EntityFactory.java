package com.arcadia.demo;

import com.arcadia.core.components.InputIntentComponent;
import com.arcadia.core.components.PositionComponent;
import com.arcadia.core.components.RenderLayerComponent;
import com.arcadia.core.components.RenderableComponent;
import com.arcadia.core.components.VelocityComponent;
import com.arcadia.core.entity.Entity;
import com.arcadia.core.util.EngineLogger;
import com.arcadia.demo.components.PlayerControlledComponent;

public class EntityFactory {

    public static Entity createPlayer(double x, double y) {
    Entity player = new Entity();
        player.addComponent(new PositionComponent(x, y));
        player.addComponent(new VelocityComponent(0,0));
        player.addComponent(new InputIntentComponent());
        player.addComponent(new PlayerControlledComponent());
        player.addComponent(new RenderableComponent('@'));
        player.addComponent(new RenderLayerComponent(2));
        EngineLogger.spawn("Created Player: " + player);
        return player;
    }

    public static Entity createWanderer(double x, double y) {
        Entity npc = new Entity();
        npc.addComponent(new PositionComponent(x, y));
        npc.addComponent(new VelocityComponent(Math.random() - 0.5, Math.random() - 0.5));
        npc.addComponent(new RenderableComponent('E'));
        npc.addComponent(new RenderLayerComponent(1));
        EngineLogger.spawn("Created Wanderer: " + npc);
        return npc;
    }

    public static Entity createStaticObject(double x, double y) {
        Entity obj = new Entity();
        obj.addComponent(new PositionComponent(x, y));
        obj.addComponent(new RenderableComponent('O'));
        obj.addComponent(new RenderLayerComponent(0));    
        EngineLogger.spawn("Created Static Object: " + obj);
        return obj;
    }
}
