package domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "productCategory")
public class ProductCategory {
    private int id;
    private String name;
    private boolean sold;
    private Set<Monitor>  ComputerMonitors = new LinkedHashSet<>();
    private Set<Television> tvScreen = new LinkedHashSet<>();
    public ProductCategory() {
    }

    public ProductCategory(String[] line) {
        this.name = line[1];
        this.sold = Boolean.parseBoolean(line[2]);
    }
    @Basic
    @Id
    @GeneratedValue
    @Column(name ="id")
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    @Basic
    @Column(name = "name")
    public String getName(){return  name;}

    public void setName(String name){this.name = name;}

    @Basic
    @Column(name = "sold")
    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @OneToMany(mappedBy = "productCategory")
    public Set<Monitor> getComputerMonitors() {
        return ComputerMonitors;
    }
    public void setComputerMonitors(Set<Monitor> ComputerMonitors) {
        this.ComputerMonitors = ComputerMonitors;
    }

    @OneToMany(mappedBy = "productCategory")
    public Set<Television> getTvScreen() {
        return tvScreen;
    }
    public void setTvScreen(Set<Television> tvScreen) {
        this.tvScreen = tvScreen;
    }
}
