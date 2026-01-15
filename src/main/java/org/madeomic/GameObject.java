package org.madeomic;

import org.madeomic.comp.std.TransformComponent;
import org.madeomic.util.Component;

import javax.swing.*;
import java.util.ArrayList;

public class GameObject extends JComponent {
    public ArrayList<Component> components;

    public GameObject() {
        components = new ArrayList<>();
        components.add(new TransformComponent(this));
    }

    public <T extends Component> T getComponent(Class<T> clazz) {
        for (Component comp : components) {
            if (clazz.isInstance(comp)) {
                return clazz.cast(comp);
            }
        }
        return null; // nothing found
    }


    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }
}
