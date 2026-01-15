package Starter;

import org.madeomic.GameObject;
import org.madeomic.MEPanel;
import org.madeomic.comp.std.DrawableComponent;
import org.madeomic.comp.std.TransformComponent;
import org.madeomic.util.Shape;

import javax.swing.*;
import java.awt.*;

public class MEPanelTest extends JFrame {
    MEPanel panel;
    GameObject object;
    public MEPanelTest() {

        object = new GameObject();
        object.addComponent(new TransformComponent(object));
        object.addComponent(new DrawableComponent(object) {{
            shape = new Shape() {
                @Override
                public void draw(Graphics2D g2d) {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(200, 50, 500, 30);
                }
            };
        }});


        panel = new MEPanel();
        panel.add(object);

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
