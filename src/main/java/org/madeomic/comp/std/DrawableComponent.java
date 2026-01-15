package org.madeomic.comp.std;

import org.madeomic.GameObject;
import org.madeomic.util.Component;
import org.madeomic.util.Shape;

import java.awt.*;

public class DrawableComponent extends Component {
    public Shape shape;
    public DrawableComponent(GameObject par) {
        super(par);
    }

    @Override
    public void draw(Graphics2D g2d) {
        shape.draw(g2d);
    }
}
