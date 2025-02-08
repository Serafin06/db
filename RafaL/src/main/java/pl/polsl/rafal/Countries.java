package org.example;


import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int country_id;
    @Column(name = "name")
    private String name;
    @Column(name = "area")
    private double area;
    @Column(name = "national_day")
    private String national_day;
    @Column(name = "country_code2")
    private String country_code2;
    @Column(name = "country_code3")
    private String country_code3;
    @Column(name = "region_id")
    private int region_id;

    public Countries() {
    }

    public Countries(int countryId, String name, double area, String nationalDay, String countryCode2, String countryCode3, int regionId) {
        this.country_id = countryId;
        this.name = name;
        this.area = area;
        this.national_day = nationalDay;
        this.country_code2 = countryCode2;
        this.country_code3 = countryCode3;
        this.region_id = regionId;
    }

    public int getCountryId() {
        return country_id;
    }

    public void setCountryId(int countryId) {
        this.country_id = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getNationalDay() {
        return national_day;
    }

    public void setNationalDay(String nationalDay) {
        this.national_day = nationalDay;
    }

    public String getCountryCode2() {
        return country_code2;
    }

    public void setCountryCode2(String countryCode2) {
        this.country_code2 = countryCode2;
    }

    public String getCountryCode3() {
        return country_code3;
    }

    public void setCountryCode3(String countryCode3) {
        this.country_code3 = countryCode3;
    }

    public int getRegionId() {
        return region_id;
    }

    public void setRegionId(int regionId) {
        this.region_id = regionId;
    }
}
