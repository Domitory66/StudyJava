package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "television")
public class Television {
    private int id;
    private String modelName;
    private  double diagonal;
    private int price;
    private String resolution;
    private  String typeLed;

    private ProductCategory category;
    public Television() {
    }
    public Television(String[]line) {
        this.modelName = line[1];
        this.diagonal = Double.parseDouble(line[2]);
        this.resolution = line[3];
        this.price = Integer.parseInt(line[4]);
        this.typeLed = line[5];
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
    public double geDiagonal() {
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
    @Column(name = "typeLed")
    public String getTypeLed() {
        return typeLed;
    }

    public void setTypeLed(String typeLed) {
        this.typeLed = typeLed;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productCategory_id")
    public ProductCategory getProductCategory() {
        return category;
    }
    public void setProductCategory(ProductCategory category) {
        this.category = category;
    }
}
