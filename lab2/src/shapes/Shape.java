package shapes;

import shapes.animation.Animator;

import javax.swing.*;
import java.awt.*;

public abstract class Shape {
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected  int size;
    protected Color color;

    public int getSize() {return size;}

    public void setSize(int size) {this.size = size;}

    public int getDx() {return dx;}

    public void setDx(int dx) {
        this.dx = dx;
        if (this.dx > 0){
            setColor(Color.GREEN);
        } else {
            setColor(Color.BLUE);
        }
    }

    public int getDy() {return dy;}

    public void setDy(int dy) {
        this.dy = dy;
        if (this.dy > 0){
            setColor(Color.CYAN);
        } else {
            setColor(Color.MAGENTA);
        }
    }
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

    public Shape(int x, int y,int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = (int)(Math.random() *10);
        this.dy = (int)(Math.random() *10);
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

