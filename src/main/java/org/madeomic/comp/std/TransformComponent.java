package org.madeomic.comp.std;

import org.madeomic.GameObject;
import org.madeomic.util.Component;

import java.awt.geom.AffineTransform;

public class TransformComponent extends Component {
    private AffineTransform transform;

    public TransformComponent(GameObject parent) {
        super(parent);

        transform = new AffineTransform();
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public void setTransform(AffineTransform transform) {
        this.transform = transform;
    }
}
