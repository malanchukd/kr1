package model;

import java.time.LocalDate;

public class Souvenir {
    private final int id;
    private String name;
    private String manufactoryName;
    private LocalDate releaseDate;
    private double price;
    private static int counter = 1;

    public Souvenir(String name, String manufactoryName, LocalDate releaseDate, double price) {
        this.name = name;
        this.manufactoryName = manufactoryName;
        this.releaseDate = releaseDate;
        this.price = price;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufactoryName() {
        return manufactoryName;
    }

    public void setManufactoryName(String manufactoryName) {
        this.manufactoryName = manufactoryName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", manufactoryName='" + manufactoryName + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }
}
