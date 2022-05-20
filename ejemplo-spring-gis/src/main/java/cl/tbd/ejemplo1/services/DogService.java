package cl.tbd.ejemplo1.services;

import cl.tbd.ejemplo1.models.Dog;
import cl.tbd.ejemplo1.repositories.DogRepository;

import org.postgis.Geometry;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DogService {

    private final DogRepository dogRepository;

    DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @GetMapping("/home")
    public String hello(){
        return String.format("HOLA");
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/dogs/read")
    public List<Dog> getAllDogs() {
        System.out.println("getAllDogs()");
        try {
            List<Dog> dogs = dogRepository.getAllDogs();
            //System.out.println("1");
            /*for (Dog d : dogs) {
                System.out.println("ID: " + d.getId());
                PGgeometry geom = d.getGeom();
                Geometry geometry = geom.getGeometry();
                
                System.out.println("Point: "+ geometry.getValue());
            }*/
            //System.out.println("2");
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        }
         
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/dogs/count")
    public String countDogs(){
        int total = dogRepository.countDogs();
        return String.format("Tienes %s perros!!", total);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/dogs/create")
    @ResponseBody
    public Dog createDog(@RequestBody Dog dog){
        Dog result = dogRepository.createDog(dog);
        return result;
    }
    
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/dogs/readN")
    public List<Dog> getNDogs(@RequestBody int id, int N) {
        System.out.println("getNDogs()");
        try {
            List<Dog> dogs = dogRepository.getAllDogs();
            System.out.println("1");
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        }
         
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/dogs/readR")
    public List<Dog> dogScanner(@RequestBody int id, int R) {
        System.out.println("dogScanner()");
        try {
            List<Dog> dogs = dogRepository.getAllDogs();
            System.out.println("1");
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        } 
    }
}
