package mk.ukim.finki.wp.lab.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "Balloon")
public class Balloon {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "manufacturerId")
    private Manufacturer manufacturer;

    @Column(name = "isSize")
    private boolean isSize;

    public Balloon(String name, String description, Optional<Manufacturer> manufacturer, boolean isSize) {
        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer.orElse(null);
        this.isSize = isSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = (long) (Math.random()*1000);
    }

    public Balloon(String name, String description, Manufacturer manufacturer, boolean isSize) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.id = (long) (Math.random()*1000);
        this.isSize = isSize;
    }

    public Balloon() {
    }

    public Long getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isSize() {
        return isSize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSize(boolean size) {
        isSize = size;
    }
}
