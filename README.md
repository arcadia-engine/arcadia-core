# 🧱 Arcadia Core

**Arcadia Core** is the foundational ECS runtime of the [Arcadia Engine](https://github.com/arcadia-engine)—a modular Java framework built for developing 2D simulations, roguelikes, and MMO-scale systems.

This module provides the core:
- Entity-Component-System architecture
- Game loop and simulation timing
- Modular system pipeline
- Scene and world loading infrastructure

It is fully decoupled from rendering, input, and networking, and serves as the embeddable logic core for clients, servers, or headless simulations.

---

## ✅ Core Features

### 🧠 ECS Architecture
- `Entity`, `Component`, and `System` driven logic
- Flexible `EntityManager` for lifecycle and state
- Systems operate independently via `GameSystem` interface

### 🔁 ArcadiaApp Runtime API
- Developer-facing app builder: set up scenes, systems, IO, and run the loop
- Simplifies engine use with a fluent interface
```java
new ArcadiaApp()
  .setRenderer(...)
  .setInputProvider(...)
  .registerSystem(new PhysicsSystem(...))
  .setInitialScene(new DemoScene())
  .start();
```

### 🧩 Scene Loading
- `Scene` interface lets you modularize game states (menu, levels, zones)
- Supports entity setup, map loading, and system configuration

### 🗺️ Tile-Based Map Support
- `Tile`, `TileType`, and `MapManager` handle ASCII or grid-based maps
- Used by rendering and physics for collision, display, and movement

### 🌀 Fixed Timestep Game Loop
- Consistent delta-time simulation
- Deterministic logic for multiplayer sync and replay support

### 🎨 IO Abstraction
- `Renderer` and `InputProvider` interfaces allow pluggable backend support
- Example implementation: Lanterna ASCII renderer in `arcadia-io-lanterna`

### 📝 Engine Logger
- Clean, ANSI-colored logs with `[info]`, `[debug]`, `[error]` levels
- Timestamped output replaces all raw `System.out` usage

---

## 📁 Module Structure

```plaintext
arcadia-core/
└── com.arcadia.core/
    ├── engine/       → ArcadiaApp, GameLoop
    ├── entity/       → EntityManager, Components
    ├── components/   → Position, Velocity, Renderable, etc.
    ├── system/       → GameSystem, PhysicsSystem, RenderSystem
    ├── io/           → Renderer, InputProvider (interfaces only)
    ├── map/          → MapManager, Tile, TileType
    ├── scene/        → Scene interface
    └── util/         → EngineLogger
```

---

## 🚧 In Progress / Roadmap

- `SystemManager` for runtime system ordering and lifecycle hooks  
- `TileMapLoader` (load ASCII, JSON, or binary map data)  
- `AnimationSystem` for 2D sprite timing  
- `ArcadiaConnection` for multiplayer support (via arcadia-net)  
- `ViewportSystem` for scrolling maps and camera control  
- `UISystem` for healthbars, labels, and message overlays  

---

## 🔁 Example Log Output

```
[21:11:22] [INFO]  [Arcadia] 🌀 Arcadia Engine started...
[21:11:23] [DEBUG] [PhysicsSystem] Entity e72a... moved to (3, 4)
[21:11:24] [DEBUG] [RenderSystem] Drew player on map layer 1
```

---

## 📚 Related Modules

- [`arcadia-client`](https://github.com/arcadia-engine/arcadia-client) → frontend rendering & input
- [`arcadia-server`](https://github.com/arcadia-engine/arcadia-server) → headless simulation server
- [`arcadia-net`](https://github.com/arcadia-engine/arcadia-net) → WIP network layer (ArcadiaConnection)
- [`arcadia-demo`](https://github.com/arcadia-engine/arcadia-demo) → example game and test zone
- [`arcadia-planning`](https://github.com/arcadia-engine/arcadia-planning) → devlogs, specs, roadmaps

---

## 🧠 Philosophy

Built by [Hemerley](https://github.com/Hemerley) as a modern Java-first engine for simulation-heavy games.

- Systems-first, not graphics-first.
- Simulation before sensation. Logic before light.
- Designed for tinkering, prototyping, and mastery of state.

MIT Licensed · Java 17+
