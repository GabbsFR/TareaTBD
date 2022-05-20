package cl.tbd.ejemplo1.services;

import cl.tbd.ejemplo1.models.Dog;
/*import cl.tbd.ejemplo1.models.Region;*/
import cl.tbd.ejemplo1.repositories.DogRepository;
/*import cl.tbd.ejemplo1.repositories.RegionRepository;*/

import org.postgis.Geometry;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

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

    @CrossOrigin()
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
    @GetMapping("/dogs/{id}/readN")
    public List<Dog> getNDogs(@PathVariable int id, @RequestParam(value = "N") int N )  {
        System.out.println("getNDogs()");
        try {
            List<Dog> dogs = dogRepository.getNDogs(id, N);
            System.out.println("1");
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        }     
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/dogs/{id}/readR")
    public List<Dog> dogScanner(@PathVariable int id, @RequestParam(value = "R") int R) {
        System.out.println("dogScanner()");
        try {
            List<Dog> dogs = dogRepository.dogScanner(id, R);
            System.out.println("1");
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        } 
    }
    
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/dogs/readId")
    public Dog getDogById(@RequestBody Dog id) {
        System.out.println("getDogById()");
        try {
            Dog dogs = dogRepository.getDogById(id.getId());
            System.out.println("1");
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        } 
    }
}
