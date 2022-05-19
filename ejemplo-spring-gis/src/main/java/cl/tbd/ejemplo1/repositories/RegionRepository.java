package cl.tbd.ejemplo1.repositories;
import java.util.List;
import cl.tbd.ejemplo1.models.Region;
import cl.tbd.ejemplo1.models.Dog;

public interface RegionRepository {
    public int countDogs();
    public List<Dog> getAllDogs();
    public Dog createDog(Dog dog);
    public String getJson();
    public List<Dog> getNDogs(Dog dog, int N);
    public List<Dog> dogScanner(Dog dog, int R);
    public List<Region> getAllRegions();
}