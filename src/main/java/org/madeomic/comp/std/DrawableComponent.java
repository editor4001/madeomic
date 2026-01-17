package org.madeomic.comp.std;

import org.madeomic.GameObject;
import org.madeomic.util.Component;
import org.madeomic.util.Shape;
import org.madeomic.util.annot.RequiresComponent;

import java.awt.*;

@RequiresComponent(TransformComponent.class)
public class DrawableComponent extends Component {
    public Color color;
    public Shape shape;
    public DrawableComponent(GameObject par, Shape shape) {
        super(par);
        this.shape = shape;
        this.shape.parent = par;
    }

    @Override
    public void draw(Graphics2D g2d) {
        shape.draw(g2d);
    }
}
