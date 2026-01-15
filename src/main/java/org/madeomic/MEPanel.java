package org.madeomic;

import org.madeomic.comp.std.DrawableComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MEPanel extends JPanel {
    public MEPanel() { }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);

        for (int i = 0; i < getComponents().length; i++) {
            Component comp = getComponents()[i];
            if (comp instanceof GameObject obj) {
                DrawableComponent draw = obj.getComponent(DrawableComponent.class);
                draw.draw(((Graphics2D) g));
            }
        }
    }
}
