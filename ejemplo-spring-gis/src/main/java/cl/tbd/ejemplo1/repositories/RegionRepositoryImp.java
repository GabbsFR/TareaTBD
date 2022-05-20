package cl.tbd.ejemplo1.repositories;

import cl.tbd.ejemplo1.models.Region;

import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RegionRepositoryImp implements RegionRepository {

    @Autowired
    private Sql2o sql2o;

    

    @Override
    public List<Region> getAllRegions() {
        try(Connection conn = sql2o.open()){
            final String query = "SELECT * FROM division_regional;";
            return conn.createQuery(query)
                    .executeAndFetch(Region.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}