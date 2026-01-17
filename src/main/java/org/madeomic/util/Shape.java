package org.madeomic.util;

import org.madeomic.GameObject;

import java.awt.*;

public abstract class Shape {

    public Color color;
    public GameObject parent;


    public abstract void draw(Graphics2D g2d);
}
