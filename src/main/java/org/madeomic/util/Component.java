package org.madeomic.util;

import org.madeomic.GameObject;

import java.awt.*;

public class Component {

    GameObject parent;

    public Component(GameObject parent) {
        this.parent = parent;
    }

    public void draw(Graphics2D g2d) { }

    public void update(float delta) { }
}
