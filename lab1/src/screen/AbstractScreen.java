package screen;

import java.io.Serializable;

public abstract class AbstractScreen implements Serializable {
    protected int price;
    protected  String resolution;
    protected float diagonal;
    protected String name;
    public abstract String turnOn();
    public abstract String turnOff();

}
