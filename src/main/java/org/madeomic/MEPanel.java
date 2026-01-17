package org.madeomic;

import org.madeomic.comp.std.DrawableComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MEPanel extends JPanel {

    private float delta;
    private long lastTime = System.nanoTime();
    private final Set<Integer> keys;

    public MEPanel() {

        keys = new HashSet<>();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                keys.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keys.remove(e.getKeyCode());
            }
        });

        // seconds
        // Update all game objects
        // Trigger repaint after updating
        Timer update = new Timer(16, e -> {
            long now = System.nanoTime();
            delta = (now - lastTime) / 1_000_000_000.0f; // seconds
            lastTime = now;

            // Update all game objects
            for (Component comp : getComponents()) {
                if (comp instanceof GameObject obj) {
                    for (org.madeomic.util.Component j : obj.getObjComponents()) {
                        j.update(delta);
                    }
                }
            }

            // Trigger repaint after updating
            repaint();
        });

        update.start();

        setFocusable(true);
        requestFocusInWindow();

    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);

        // Just draw — no delta calculation here
        for (Component comp : getComponents()) {
            if (comp instanceof GameObject obj) {
                DrawableComponent draw = obj.getObjComponent(DrawableComponent.class);
                if (draw != null) {
                    draw.draw((Graphics2D) g);
                }
            }
        }
    }

    public boolean keyPressed(int keyCode) {
        return keys.contains(keyCode);
    }
}
