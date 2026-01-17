package org.madeomic.geo;

import org.joml.Matrix3d;
import org.joml.Matrix4d;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.madeomic.GameObject;
import org.madeomic.comp.std.TransformComponent;
import org.madeomic.util.Shape;

import java.awt.*;

public class Circle extends Shape {

    private int width, height;
    public Circle(Color color, int radius) {
        this.color = color;
        this.width = radius;
        this.height = radius;
    }

    public Circle(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);

        Matrix4d transform = parent.getTransform().getTransform();
        Vector3d pos = new Vector3d();
        transform.getTranslation(pos);

        g2d.fillOval(((int) pos.x), ((int) pos.y), width, height);

    }
}
