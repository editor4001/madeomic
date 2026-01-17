package org.madeomic.comp.std;

import org.joml.Matrix4d;
import org.madeomic.GameObject;
import org.madeomic.util.Component;

public class TransformComponent extends Component {
    Matrix4d transform;

    public TransformComponent(GameObject parent) {
        super(parent);

        transform = new Matrix4d();
    }

    public Matrix4d getTransform() {
        return transform;
    }

    public void setTransform(Matrix4d transform) {
        this.transform = transform;
    }
}
