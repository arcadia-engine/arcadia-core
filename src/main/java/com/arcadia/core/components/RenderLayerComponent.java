// com.arcadia.core.components.RenderLayerComponent.java
package com.arcadia.core.components;

import com.arcadia.core.entity.Component;

public class RenderLayerComponent implements Component {
    public final int layer;

    public RenderLayerComponent(int layer) {
        this.layer = layer;
    }
}
