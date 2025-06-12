# 🧱 Arcadia Core

**Arcadia Core** is the foundational ECS (Entity-Component-System) framework powering the [Arcadia Engine](https://github.com/arcadia-engine).  
It handles simulation logic, game loop control, and system execution—completely decoupled from rendering, input, or networking.

Built for modularity, clarity, and classic 2D game logic.

---

## ✅ Features

### ⚙️ Fixed Timestep Game Loop
- Runs at 60 FPS using delta time
- Clean separation between simulation and rendering phases

### 🧠 Entity-Component-System Architecture
- Lightweight, pluggable ECS
- Components define behavior without inheritance
- `EntityManager` handles creation and lifecycle
- `GameSystem` interface allows drop-in system modules

### 🌀 Physics System
- Applies velocity over time using `VelocityComponent`
- Supports deterministic simulation for multiplayer sync

### 📝 Engine Logger
- ANSI-colored console output
- Timestamps and log levels (`info`, `debug`, `error`)
- Fully replaces `System.out.println(...)` for core logging

---

## 🚧 In Progress

- `RenderSystem` for terminal-grid ASCII rendering  
- `EntityFactory` for structured game object creation  
- Spatial partitioning (grid-based world navigation)  
- Pluggable `SystemManager` for runtime injection and priority handling  

---

## 📁 Package Structure

```plaintext
arcadia-core/
└── com.arcadia.core/
    ├── ArcadiaMain.java
    ├── GameLoop.java
    ├── entity/
    │   ├── Entity.java
    │   ├── EntityManager.java
    │   ├── Component.java
    │   ├── PositionComponent.java
    │   └── VelocityComponent.java
    ├── system/
    │   ├── GameSystem.java
    │   └── PhysicsSystem.java
    └── util/
        └── EngineLogger.java
```
---

### 👁️ Example Output

[21:11:22] [INFO] [Arcadia] 🌀 Arcadia Engine started...
[21:11:23] [DEBUG] [Arcadia] PhysicsSystem → Entity 84c4... moved to Position(14, 25)
[21:11:24] [DEBUG] [Arcadia] Rendering player on screen...


---

###📜 Devlog & Roadmap

[Arcadia Engine](https://github.com/arcadia-engine)
[DevLogs](https://github.com/arcadia-engine/arcadia-planning/tree/main/devlogs)
[Roadmap](https://github.com/arcadia-engine/arcadia-planning/blob/main/milestones/roadmap-v0.1.md)

This module is actively maintained and tracked via the arcadia-planning repo.

---

### 💬 Author

Built by [Hemerley](https://github.com/Hemerley) as a modern ECS engine for custom 2D games and MMOs.  
Systems developer · Tools engineer · MMO enthusiast  
MIT Licensed · Java 17+

"Simulation before sensation. Logic before light."

