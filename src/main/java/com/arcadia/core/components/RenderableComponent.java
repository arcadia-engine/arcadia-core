package com.arcadia.core.components;

import com.arcadia.core.entity.*;

public class RenderableComponent implements Component {
    public final char glyph;

    public RenderableComponent(char glyph) {
        this.glyph = glyph;
    }
}
