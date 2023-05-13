package screen;

import java.io.Serializable;

public class Television extends AbstractScreen implements Serializable {
    private
    String typeLed;
    public Television(
            String name,
            float diagonalScreen,
            String resolution,
            int price,
            String typeLed
            )
    {
       this.name = name;
       this.diagonal = diagonalScreen;
       this.resolution = resolution;
       this.price = price;
       this.typeLed = typeLed;
    }
    public void setTypeLED(String typeLed){
        this.typeLed = typeLed;
    }
    public void  setNameModel(String name) {
        this.name = name;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setDiagonalScreen(float diagonal) {
        this.diagonal = diagonal;
    }
    public String getNamemodel() {
        return name;
    }
    public String getResolution() {
        return resolution;
    }
    public int getPrice() {
        return price;
    }
    public float getDiagonalScreen() {
        return diagonal;
    }
    public String toString(){
        return "name: " + this.name + "\n" +
                "diagonal: " + this.diagonal + "\n" +
                "resolution: " + this.resolution + "\n" +
                "price: " + this.price + "\n" +
                "type led: " + this.typeLed;
    }
    @Override
    public String turnOn() {
        return "TV on";
    }
    @Override
    public String turnOff() {
        return "TV off";
    }
}
