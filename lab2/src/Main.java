import shapes.Shape;
import shapes.DoubleSquare;
import components.GraphicsPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new DoubleSquare(200, 200, 50));
        shapes.add(new DoubleSquare(300, 300, 50));
        shapes.add(new DoubleSquare(100, 100, 50));
        shapes.add(new DoubleSquare(500, 500, 50));
        shapes.add(new DoubleSquare(600, 600, 50));


        GraphicsPanel canvas = new GraphicsPanel(shapes);

        for (Shape s: shapes) {
            Thread t = new Thread(s.getAnimator(canvas));
            t.start();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);
    }
}