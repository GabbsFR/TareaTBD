package cl.tbd.ejemplo1.models;

import org.postgis.PGgeometry;
import org.postgis.Point;

public class Dog {
    private Integer id;
    private String name;
    private double longitude;
    private double latitude;
    //private PGgeometry geom;

    public Integer getId() {
        return id;
    }

    /*public PGgeometry getGeom() {
        return geom;
    }

    public void setGeom(PGgeometry geom) {
        this.geom = geom;
    }*/

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
