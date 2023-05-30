package domain;

import javax.persistence.*;

@Entity
@Table(name = "monitor")
public class Monitor {
    private int id;
    private String modelName;
    private double diagonal;
    private String resolution;
    private int price;
    private int timeResp;
    private ProductCategory category;
    public Monitor() {
    }
    public Monitor(String[] line) {
        this.modelName = line[1];
        this.diagonal = Double.parseDouble(line[2]);
        this.resolution = line[3];
        this.price = Integer.parseInt(line[4]);
        this.timeResp = Integer.parseInt(line[5]);
    }
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "modelName")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "diagonal")
    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "resolution")
    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Basic
    @Column(name = "timeResp")
    public int getTimeResp() {
        return timeResp;
    }

    public void setTimeResp(int timeResp) {
        this.timeResp = timeResp;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productCategory_id")
    public ProductCategory getProductCategory() {
        return category;
    }
    public void setProductCategory(ProductCategory category) {
        this.category = category;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Monitor: ");
        builder.append("Model name: ").append(modelName).append(" | ");
        builder.append("Diagonal: ").append(diagonal).append(" | ");
        builder.append("Price: ").append(price).append(" | ");
        builder.append("Resolution: ").append(resolution).append(" | ");
        builder.append("Time Response: ").append(timeResp);
        return builder.toString();
    }
}
