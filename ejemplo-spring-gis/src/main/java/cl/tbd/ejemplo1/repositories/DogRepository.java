package cl.tbd.ejemplo1.repositories;
import java.util.List;
import cl.tbd.ejemplo1.models.Dog;
/*import cl.tbd.ejemplo1.models.Region;*/

public interface DogRepository {
    public int countDogs();
    public List<Dog> getAllDogs();
    public Dog createDog(Dog dog);
    public String getJson();
    public Dog getDogById(int id_Dog);
    public List<Dog> getNDogs(Dog dog, int N);
    public List<Dog> dogScanner(Dog dog, int R);
    /*public List<Dog> dogByRegion(Region region);*/
}
