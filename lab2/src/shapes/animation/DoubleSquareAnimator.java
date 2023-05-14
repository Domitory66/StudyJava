package shapes.animation;

import shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class DoubleSquareAnimator extends Animator {
    public DoubleSquareAnimator(Shape shape, JComponent component) {
        super(shape, component);
    }

    @Override
    public void run() {
        while (true) {
            if (shape.getX() < 0 || shape.getX() > component.getWidth()  - shape.getSize()){
                shape.setDx(-shape.getDx());
            }
            if (shape.getY() < 0  || shape.getY() > component.getHeight() - shape.getSize()) {
                shape.setDy(-shape.getDy());
            }
            shape.moveRel(shape.getDx(),shape.getDy());


            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}