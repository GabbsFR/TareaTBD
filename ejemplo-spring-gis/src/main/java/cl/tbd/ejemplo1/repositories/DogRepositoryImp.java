package cl.tbd.ejemplo1.repositories;

import cl.tbd.ejemplo1.models.Dog;
/*import cl.tbd.ejemplo1.models.Region;*/

import org.postgis.Point;
/*import org.postgis.PGgeometry;
import org.postgis.Geometry;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class DogRepositoryImp implements DogRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countDogs() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM perror").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Dog> getAllDogs() {
        try(Connection conn = sql2o.open()){
            final String query = "SELECT id, name, st_x(st_astext( geom)) AS longitude, st_y(st_astext(geom)) AS latitude FROM perror;";
            return conn.createQuery(query)
                    .executeAndFetch(Dog.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public Dog createDog(Dog dog) {
        try(Connection conn = sql2o.open()){
            String query = "INSERT INTO perror (name, geom) " +
            "VALUES (:dogName, ST_GeomFromText(:point, 4326))";

            String point = "POINT("+dog.getLongitude()+" "+dog.getLatitude()+")";
            System.out.println("point: "+point);
            
            int insertedId = (int) conn.createQuery(query, true)
                    .addParameter("dogName", dog.getName())
                    .addParameter("point", point)
                    .executeUpdate().getKey();
            dog.setId(insertedId);
            return dog;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @Override
    public Dog getDogById(int id_Dog) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(
                    "SELECT id, name, st_x(st_astext( geom)) AS longitude, st_y(st_astext(geom)) AS latitude FROM perror WHERE id = :v_id_Dog")
                    .addParameter("v_id_Dog", id_Dog).executeAndFetchFirst(Dog.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String getJson() {
        // TODO Auto-generated method stub
        final String query = "SELECT json_build_object("+
            "'type', 'FeatureCollection',"+
            "'features', json_agg(ST_AsGeoJSON(t.geom)::json)"+
            ")"+
        "FROM division_regional_4326 AS t WHERE t.gid = 5;";
        return null;
    }
    
    @Override
    public List<Dog> getNDogs(int id, int N) {
        try(Connection conn = sql2o.open()){
            String queryDog = "SELECT id, name, st_x(st_astext( geom)) AS longitude, st_y(st_astext(geom)) AS latitude FROM perror WHERE id = " + id;
            Dog dog = conn.createQuery(queryDog)
            .executeAndFetchFirst(Dog.class);
            final String query = "SELECT ST_Distance(geom,'SRID=4326;:point) as d,id, name FROM perror ORDER BY d limit :limit;";

            String point = "POINT("+dog.getLongitude()+" "+dog.getLatitude()+")";

            return conn.createQuery(query)
                    .addParameter("point", point)
                    .addParameter("limit", N)
                    .executeAndFetch(Dog.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Escaner de perros, toma un Id y un radio R para hacer la busqueda
    @Override
    public List<Dog> dogScanner(int id, int R) {
        try(Connection conn = sql2o.open()){

            String queryDog = "SELECT * FROM perror WHERE id = " + id;
            Dog dog = conn.createQuery(queryDog)
            .executeAndFetchFirst(Dog.class);
            String point = "POINT("+dog.getLongitude()+" "+dog.getLatitude()+")";

            return conn.createQuery("SELECT id, name, st_x(st_astext( geom)) AS longitude, st_y(st_astext(geom)) AS latitude FROM perror p WHERE ST_DWITHIN(Geography(ST_Transform(p.geom,4326)), :point ;)'), :radius )")
                    .addParameter("point", point)
                    .addParameter("radius", R)
                    .executeAndFetch(Dog.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*@Override
    public List<Dog> dogByRegion(Region region) {
        try(Connection conn = sql2o.open()){

            String aux = region.getGeom();
            PGgeometry geom;
            Geometry geometry = geom.geomFromString(aux);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }*/
}
