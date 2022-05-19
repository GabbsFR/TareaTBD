package cl.tbd.ejemplo1.models;

import org.postgis.PGgeometry;
import org.postgis.Point;

public class Dog {


    private Integer id;
    private String name;
    private double longitude;
    private double latitude;
    //private PGgeometry geom;

    //Constructor
    /**
     * Crear un perro a partir de los parametros descritos
     * @param id
     * @param name
     * @param longitude
     * @param latitude
     * 
     */
    public Dog(Integer id, String name, double longitude, double latitude){

        this.id=id;
        this.name=name;
        this.longitude=longitude;
        this.latitude=latitude;

    }

    ////////////////////////Getters
     /**
     * Obtiene el identificador de un perro
     * @return id si el perro existe
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Obtiene el nombre de un perro 
     * @return el nombre si el perro esta bien definido
     */
    public String getName(){
        return this.name;

    }
    
    /**
     * Obtiene la latitud del perro 
     * @return latitude si el perro existe correctamente
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Obtiene la longitud del perro 
     * @return longitud si el perro existe correctamente
     */
    public double getLongitude() {
        return this.longitude;
    }
    ////////////////////////Getters




    ////////////////////////Setters

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    ////////////////////////Setters


}
