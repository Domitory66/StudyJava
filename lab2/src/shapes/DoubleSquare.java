package shapes;

import shapes.animation.Animator;
import shapes.animation.DoubleSquareAnimator;

import javax.swing.*;
import java.awt.*;

public class DoubleSquare extends Shape {
    protected int side;
    public DoubleSquare() {
    }

    public DoubleSquare(int x, int y, int side) {
        super(x, y,side);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x,y, side,side);
        g.fillRect(x, y, side, side);
        g.setColor(color);
        g.drawRect(x+5, y+5, side-10, side-10);
        g.fillRect(x+5, y+5, side-10, side-10);
    }

    @Override
    public Animator getAnimator(JComponent component) {
        return new DoubleSquareAnimator(this, component);
    }
}

