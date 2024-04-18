package models;

import daos.IntDTO;

public class DTO implements IntDTO {
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String color;


    public DTO() {}

    public DTO(String make, String model, Integer year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
    public DTO(Integer id, String make, String model, Integer year, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
