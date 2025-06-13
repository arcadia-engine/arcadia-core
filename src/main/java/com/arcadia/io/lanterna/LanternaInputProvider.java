package com.arcadia.io.lanterna;

import com.arcadia.core.io.InputProvider;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

public class LanternaInputProvider implements InputProvider {
    private final Screen screen;

    public LanternaInputProvider(Screen screen) {
        this.screen = screen;
    }

    @Override
    public char pollInput() {
        try {
            KeyStroke ks = screen.pollInput(); // ✅ non-blocking
            if (ks != null && ks.getKeyType() == KeyType.Character && ks.getCharacter() != null) {
                char ch = Character.toLowerCase(ks.getCharacter());
                System.out.println("[KEY] " + ch);
                return ch;
            } else if (ks != null) {
                System.out.println("[SPECIAL KEY] " + ks.getKeyType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
