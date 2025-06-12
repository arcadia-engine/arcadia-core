# 🧱 Arcadia Core

**Arcadia Core** is the foundational ECS (Entity-Component-System) framework powering the Arcadia Engine. It is responsible for simulation logic, game loop control, and system execution—independent of rendering, input, or networking.

---

### ✅ Current Features

- ⚙️ **Fixed Timestep Game Loop**  
  Runs at 60 FPS with clean separation of update and render phases.

- 🧠 **Entity-Component-System Architecture**  
  Lightweight, modular ECS design:
  - `EntityManager`
  - `Component` and base components like `PositionComponent`, `VelocityComponent`
  - `GameSystem` interface for pluggable behavior

- 🌀 **Physics System**  
  Applies velocity to entity positions using `VelocityComponent`.

- 📝 **Engine Logger**  
  - Color-coded output via ANSI escape codes  
  - Timestamped entries  
  - Log levels: `info`, `debug`, `error`  
  - Fully replaces `System.out.println(...)`

---

### 🚧 In Progress

- `RenderSystem` to visualize entity positions on an ASCII grid  
- `EntityFactory` for structured game object creation  
- World spatial grid system  
- Modular system manager  

---

### 📁 Package Structure

arcadia-core/
├── com.arcadia.core/
│ ├── ArcadiaMain.java
│ ├── GameLoop.java
│ ├── entity/
│ │ ├── Entity.java
│ │ ├── EntityManager.java
│ │ ├── Component.java
│ │ ├── PositionComponent.java
│ │ └── VelocityComponent.java
│ ├── system/
│ │ ├── GameSystem.java
│ │ └── PhysicsSystem.java
│ └── util/
│ └── EngineLogger.java


---

### 👁️ Example Output

[21:11:22] [INFO] [Arcadia] 🌀 Arcadia Engine started...
[21:11:23] [DEBUG] [Arcadia] PhysicsSystem → Entity 84c4... moved to Position(14, 25)
[21:11:24] [DEBUG] [Arcadia] Rendering player on screen...


---

### 📜 Devlog

View progress entries here: [arcadia-planning/devlog.md](https://github.com/arcadia-engine/arcadia-planning/blob/main/devlog.md)

---

### 💬 Author

Built by [Strategist](https://github.com/Hemerley) as a modern ECS engine for custom 2D games and MMOs.

