package repository;

import model.Country;
import model.Manufactory;

import java.util.LinkedList;
import java.util.List;

public class ManufactoryRepository {
    private final List<Manufactory> manufactoriesList;

    public ManufactoryRepository() {
        manufactoriesList = new LinkedList<>();
        manufactoriesList.add(new Manufactory("GoldenFactory", Country.UKRAINE));
        manufactoriesList.add(new Manufactory("CeramicINC", Country.UNITEDKINKDOM));
    }

    public boolean create(Manufactory manufactory) {
        boolean status = manufactoriesList.stream().anyMatch(m -> m.getName().equals(manufactory.getName()));
        if (!status)
            return manufactoriesList.add(manufactory);
        return false;
    }

    public Manufactory read(int id) {
        return manufactoriesList.stream().filter(manufactory -> manufactory.getId() == id).findFirst().orElse(null);
    }

    public boolean update(Manufactory newManuFactory) {
        Manufactory oldManuFactory = read(newManuFactory.getId());
        if (oldManuFactory != null){
            boolean status = all().stream()
                    .filter(manufactory -> manufactory.getId() != oldManuFactory.getId())
                    .anyMatch(manufactory -> manufactory.getName().equals(newManuFactory.getName()));
            if (!status) return manufactoriesList.set(manufactoriesList.indexOf(oldManuFactory), newManuFactory) != null;
            return false;
        }
        return false;
    }

    public boolean delete(int id) {
        Manufactory manufactory = read(id);
        if(manufactory != null) return manufactoriesList.remove(manufactory);
        return false;
    }

    public List<Manufactory> all() {return manufactoriesList;}

    public void deleteAll() {manufactoriesList.clear();}

    private static ManufactoryRepository manufactoryRepository = null;

    public synchronized static ManufactoryRepository getManufactoryRepository() {
        if (manufactoryRepository == null) manufactoryRepository = new ManufactoryRepository();
        return manufactoryRepository;
    }
}
