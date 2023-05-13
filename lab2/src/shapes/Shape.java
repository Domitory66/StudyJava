package shapes;

import shapes.animation.Animator;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {
    protected int x;
    protected int y;

    protected  int size;
    protected Color color;

    public int getSize() {return size;}

    public void setSize(int size) {this.size = size;}
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape() {
    }

    public Shape(int x, int y,int size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveRel(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public abstract void draw(Graphics g);
    public abstract Animator getAnimator(JComponent component);
}

