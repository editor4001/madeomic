package org.madeomic.util.Builder;

import org.joml.Vector2d;
import org.joml.Vector3d;
import org.madeomic.GameObject;
import org.madeomic.comp.std.DrawableComponent;
import org.madeomic.comp.std.TransformComponent;
import org.madeomic.util.Component;
import org.madeomic.util.Shape;

public class GObjectBuilder {
    private GameObject object;

    /**
     Dummy building function -

     public T name(arg) {
        // Do Something
        return this;
     }
     */

    public GObjectBuilder() {
        object = new GameObject();
        init();
    }

    public GObjectBuilder(GameObject object) {
        this.object = object;
        init();
    }

    private void init() {
        object.addComponent(new TransformComponent(object));
    }

    public GObjectBuilder position(Vector3d pos) {
        object.getTransform().getTransform().translate(pos.x, pos.y, pos.z);
        return this;
    }

    public GObjectBuilder rotation(Vector3d pos) {
        object.getTransform().getTransform().setRotationXYZ(pos.x, pos.y, pos.z);
        return this;
    }

    public GObjectBuilder scalingFactor(Vector3d pos) {
        object.getTransform().getTransform().scale(pos.x, pos.y, pos.z);
        return this;
    }

    public GObjectBuilder sprite(Shape shape) {
        DrawableComponent comp = new DrawableComponent(object, shape);
        object.addComponent(comp);
        return this;
    }

    public GObjectBuilder addComponent(Component component) {
        object.addComponent(component);
        return this;
    }

    public GameObject build() {
        return object;
    }
}
