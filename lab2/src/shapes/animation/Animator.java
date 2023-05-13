package shapes.animation;

import shapes.Shape;

import javax.swing.*;

public abstract class Animator implements Runnable {
    protected Shape shape;
    protected JComponent component;

    public Animator(Shape shape, JComponent component) {
        this.shape = shape;
        this.component = component;
    }
}
