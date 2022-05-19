package cl.tbd.ejemplo1.services;

import cl.tbd.ejemplo1.models.Region;
import cl.tbd.ejemplo1.repositories.RegionRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegionService {
    
    private final RegionRepository regionRepository;

    
    RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    //@CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/region/read")
    public List<Region> getAllRegions() {
        System.out.println("4");
        return regionRepository.getAllRegions();
    }

}