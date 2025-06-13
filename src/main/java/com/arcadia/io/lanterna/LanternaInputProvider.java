package com.arcadia.io.lanterna;

import com.arcadia.core.io.InputProvider;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

public class LanternaInputProvider implements InputProvider {
    private final Screen screen;

    public LanternaInputProvider(Screen screen) {
        this.screen = screen;
    }

    @Override
    public char pollInput() {
        try {
            KeyStroke ks = screen.pollInput(); // ✅ this does NOT block
            if (ks != null && ks.getCharacter() != null) {
                System.out.println("[KEY] " + ks.getCharacter());
                return ks.getCharacter();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
