package Starter;

import org.joml.Vector3d;
import org.madeomic.GameObject;
import org.madeomic.MEPanel;
import org.madeomic.comp.std.DrawableComponent;
import org.madeomic.comp.std.TransformComponent;
import org.madeomic.geo.Circle;
import org.madeomic.util.Builder.GObjectBuilder;
import org.madeomic.util.Component;
import org.madeomic.util.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MEPanelTest extends JFrame {
    MEPanel panel;
    GameObject object;
    public MEPanelTest() {

        object = new GObjectBuilder()
                .position(new Vector3d(20, 20, 0))
                .sprite(new Circle(Color.RED, 50))
                .addComponent(new Component(object){
                    enum Direction {
                        UP, DOWN, LEFT, RIGHT;
                    }

                    @Override
                    public void update(float delta) {
                        super.update(delta);
                        if (panel.keyPressed(KeyEvent.VK_W)) move(0, -2);
                        if (panel.keyPressed(KeyEvent.VK_A)) move(-2, 0);
                        if (panel.keyPressed(KeyEvent.VK_S)) move(0, 2);
                        if (panel.keyPressed(KeyEvent.VK_D)) move(2, 0);
                    }

                    public void move(Direction direction) {
                        switch (direction) {
                            case UP -> move(0, -2);
                            case DOWN -> move(0, 2);
                            case LEFT -> move(-2, 0);
                            case RIGHT -> move(2, 0);
                        }
                    }

                    public void move(float x, float y) {
                        object.getTransform().getTransform().translate(x, y, 0);
                    }
                })
                .build();

        object.getTransform().getTransform().translate(100, 50, 0);

        panel = new MEPanel();
        panel.add(object);

        panel.setBackground(Color.GREEN);

        setContentPane(panel);

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MEPanelTest();
    }
}
