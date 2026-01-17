package org.madeomic.comp.Phy;

import org.madeomic.GameObject;
import org.madeomic.comp.std.TransformComponent;
import org.madeomic.util.Component;
import org.madeomic.util.annot.RequiresComponent;

@RequiresComponent(TransformComponent.class)
public class PhysicsComponent extends Component {

    public PhysicsComponent(GameObject parent) {
        super(parent);
    }
}
