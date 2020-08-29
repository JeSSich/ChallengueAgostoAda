package ar.com.ada.api.noaa.entities;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "boya")
public class Boya {
    @Column(name = "boya_id")
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoya;
    private String color;
    @Column(name = "color_boya")
    private double longitudInstalacion;
    private double latitudtudInstalacion;
    
   
    @OneToMany (mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   
    @JsonIgnore
    private List<Muestra> muestras = new ArrayList<>();

    public int getBoyaId() {
        return idBoya;
    }

    public void setBoyaId(int idBoya) {
        this.idBoya = idBoya;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getlongitudInstalacion() {
        return longitudInstalacion;
    }

    public void longitudInstalacion(double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }
    public double getlatitudInstalacion() {
        return latitudInstalacion;
    }

    public void latitudInstalacion(double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
	}


    public List<Muestra> getMuestras() {
        return muestras;
    }

    public void setMuestras(List<Muestra> muestras) {
        this.muestars = muestras;
    }
    
}