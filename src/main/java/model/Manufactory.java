package model;

public class Manufactory implements Comparable {
    private int id;
    private String name;

    private Country country;
    private static int counter = 1;

    public Manufactory (String name, Country country) {
        this.name = name;
        this.country = country;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Manufactory{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }


    public int compareTo(Object o) {
        if (this.getClass() != o.getClass()) return getClass().getName().compareTo(o.getClass().getName());
        Manufactory manufactory = (Manufactory) o;
        int a = name.compareTo(manufactory.name);
        if (a != 0) return a;
        a = country.compareTo(manufactory.country);
        return a;
    }
}
