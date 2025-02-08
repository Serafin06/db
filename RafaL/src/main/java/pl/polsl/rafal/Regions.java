package org.example;


import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int region_id;

    @Column(name = "name")
    private String name;

    @Column(name = "continent_id")
    private int continent_id;

    public Regions() {
    }

    public Regions(int region_id, String name, int continent_id) {
        this.region_id = region_id;
        this.name = name;
        this.continent_id = continent_id;
    }

    public int getRegionId() {
        return region_id;
    }
    public void setRegionId(int regionId) {
        this.region_id = regionId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getContinentId() {
        return continent_id;
    }
    public void setContinentId(int continentId) {
        this.continent_id = continentId;
    }
}
