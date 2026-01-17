package org.madeomic;

import org.madeomic.comp.std.TransformComponent;
import org.madeomic.util.Component;
import org.madeomic.util.annot.RequiresComponent;

import javax.swing.*;
import java.util.ArrayList;

public class GameObject extends JComponent {
    public ArrayList<Component> components;

    public GameObject() {
        components = new ArrayList<>();
        components.add(new TransformComponent(this));
    }

    public <T extends Component> T getObjComponent(Class<T> clazz) {
        for (Component comp : components) {
            if (clazz.isInstance(comp)) {
                return clazz.cast(comp);
            }
        }
        return null; // nothing found
    }

    public ArrayList<Component> getObjComponents() {
        return components;
    }

    public void setObjComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component) {
        System.out.println("Adding: " + component.getClass().getName());

        RequiresComponent[] requirements =
                component.getClass().getAnnotationsByType(RequiresComponent.class);

        System.out.println("RequiresComponent annotations found: " + requirements.length);

        for (RequiresComponent req : requirements) {
            System.out.println("Requires: " + req.value().getName());
            boolean present = hasComponent(req.value());
            System.out.println("Has required? " + present);
            if (!present) {
                System.out.println("Missing required component: " + req.value().getName());
                return;
            }
        }

        components.add(component);
        System.out.println("Component added successfully.");
    }

    public boolean hasComponent(Class<? extends Component> clazz) {
        return getObjComponent(clazz) != null;
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public TransformComponent getTransform() {
        return getObjComponent(TransformComponent.class);
    }
}
