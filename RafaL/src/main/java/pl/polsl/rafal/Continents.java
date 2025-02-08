package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
public class Continents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private int continent_id;

    @Column(name = "name")
    private String name;

    public Continents() {
    }

    public Continents(int continentId, String name) {
        this.continent_id = continentId;
        this.name = name;
    }

    public int getContinentId() {
        return continent_id;
    }

    public void setContinentId(int continentId) {
        this.continent_id = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
