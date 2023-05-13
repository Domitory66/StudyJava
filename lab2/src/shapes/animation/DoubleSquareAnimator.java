package shapes.animation;

import shapes.Shape;

import javax.swing.*;
import java.awt.*;

public class DoubleSquareAnimator extends Animator {
    private static final int SizeWindow = 800;
    private  boolean moveLeft = false;
    public DoubleSquareAnimator(Shape shape, JComponent component) {
        super(shape, component);
    }

    @Override
    public void run() {
        while (true) {
            if (moveLeft){
                if (shape.getX() <= 0) {
                    moveLeft = false;
                    shape.setColor(Color.BLUE);
                }
                shape.moveRel(-(int) (Math.random() * 10), 0);
            } else {
                if (shape.getX() >= SizeWindow -shape.getSize()){
                    shape.setColor(Color.GREEN);
                    moveLeft = true;
                } else
                    shape.moveRel((int) (Math.random() * 10), 0);
            }



            if (component != null) {
                component.repaint();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}