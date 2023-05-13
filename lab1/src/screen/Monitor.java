package screen;

import java.io.Serializable;

public class Monitor extends AbstractScreen implements Serializable {
    private
    int time;
    public  Monitor(){

    }

    public Monitor( String name, float diagonal, String resolution, int price, int time){
        this.time = time;
        this.name = name;
        this.resolution = resolution;
        this.price = price;
        this.diagonal = diagonal;
    }
    public void  setTimeResponse(int time){
        this.time = time;
    }
    public void setNameModel(String name) {

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
    public int getTimeResponse(){
        return this.time;
    }
    public String toString(){
        return "name: " + this.name + "\n" +
                "diagonal: " + this.diagonal + "\n" +
                "resolution: " + this.resolution + "\n" +
                "price: " + this.price + "\n" +
                "time response: " + this.time;
    }

    @Override
    public String turnOn() {
        return "Monitor turned on";
    }
    @Override
    public String turnOff() {
        return "Monitor turned off";
    }
}
