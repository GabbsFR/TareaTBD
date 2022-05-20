package cl.tbd.ejemplo1.models;

import org.postgis.PGgeometry;
import org.postgis.Point;

public class Region {
    private Integer gid;
    private String nom_reg;
    private String nom_prov;
    private String cod_com;
    private String nom_com;
    private double cod_regi;
    private double superficie;
    private int poblac02;
    private int pobl2010;
    private double shape_leng;
    private double shape_area;
    private String geom;
    
    // Constructor
    
    public Region(int gid, String nom_reg, String nom_prov, String cod_com, String nom_com, double cod_regl, double superficie, int poblac02, int pobl2010, double shape_leng, double shape_area, String geom){
        this.gid=gid;
        this.nom_reg=nom_reg;
        this.nom_prov=nom_prov;
        this.cod_com=cod_com;
        this.nom_com=nom_com;
        this.cod_regi=cod_regl;
        this.superficie=superficie;
        this.poblac02=poblac02;
        this.pobl2010=pobl2010;
        this.shape_leng=shape_leng;
        this.shape_area=shape_area;
        this.geom=geom;

    }
    

    public String getGeom() {
        return geom;
    }
    
    public void setGeom(String geom) {
        this.geom = geom;
    }
    
    //------------------------------------
    public String getNom_reg() {
        return nom_reg;
    }
    
    public void setNom_reg(String nom_reg) {
        this.nom_reg = nom_reg;
    }
    //------------------------------------
    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }
    //------------------------------------
    public String getCod_com() {
        return cod_com;
    }

    public void setCod_com(String cod_com) {
        this.cod_com = cod_com;
    }
    //------------------------------------
    public String getNom_com() {
        return nom_com;
    }

    public void setNom_com(String nom_com) {
        this.nom_com = nom_com;
    }
    //------------------------------------
    public double getCod_regi() {
        return cod_regi;
    }

    public void setCod_regi(double cod_regl) {
        this.cod_regi = cod_regl;
    }
    //------------------------------------
    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    //------------------------------------
    public int getPoblac02() {
        return poblac02;
    }

    public void setPoblac02(Integer poblac02) {
        this.poblac02 = poblac02;
    }
    //------------------------------------
    public int getPobl2010() {
        return pobl2010;
    }

    public void setPobl2010(Integer pobl2010) {
        this.pobl2010 = pobl2010;
    }
    //------------------------------------
    public double getShape_leng() {
        return shape_leng;
    }

    public void setShape_leng(double shape_leng) {
        this.shape_leng = shape_leng;
    }
    //------------------------------------
    public double getShape_area() {
        return shape_area;
    }

    public void setShape_area(double shape_area) {
        this.shape_area = shape_area;
    }
    //------------------------------------
}