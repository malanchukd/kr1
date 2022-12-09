package repository;

import model.Souvenir;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SouvenirRepository {
    private final List<Souvenir> souvenirList;

    public SouvenirRepository() {
        souvenirList = new LinkedList<>();
        souvenirList.add(new Souvenir("Ring", "GoldenFactory", LocalDate.of(2022, 12, 1), 142));
        souvenirList.add(new Souvenir("Cup", "CeramicINC", LocalDate.of(2015, 3, 5), 10));
    }

    public boolean create(Souvenir souvenir) {
        return souvenirList.add(souvenir);
    }

    public Souvenir read(int id) {
        return souvenirList.stream().filter(souvenir -> souvenir.getId() == id).findFirst().orElse(null);
    }

    public boolean update(Souvenir newSouvenir) {
        Souvenir oldSouvenir = read(newSouvenir.getId());
        if (oldSouvenir != null){
            boolean status = all().stream()
                    .filter(souvenir -> souvenir.getId() != oldSouvenir.getId())
                    .anyMatch(souvenir -> souvenir.getName().equals(newSouvenir.getName()));
            if (!status) return souvenirList.set(souvenirList.indexOf(oldSouvenir), newSouvenir) != null;
            return false;
        }
        return false;
    }

    public boolean delete(int id) {
        Souvenir souvenir = read(id);
        if(souvenir != null) return souvenirList.remove(souvenir);
        return false;
    }

    public List<Souvenir> all() {return souvenirList;}

    public void deleteAll() {souvenirList.clear();}

    private static SouvenirRepository souvenirRepository = null;

    public synchronized static SouvenirRepository getSouvenirRepository() {
        if (souvenirRepository == null) souvenirRepository = new SouvenirRepository();
        return souvenirRepository;
    }
}
