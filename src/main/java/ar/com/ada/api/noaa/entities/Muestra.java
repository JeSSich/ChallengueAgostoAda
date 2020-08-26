package ar.com.ada.api.noaa.entities;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;

@Entity
@Table (name = "muestra")
public class Muestra {
    @Column (name = "muestra_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int muestraId;
    private String matriculaEmbarcacion;
    private double longitud;
    private double latitud; 
    private Date horarioMuestra;
    private double alturaMar;
    
  
    // siempre que haya FK y los tratemos como objetos será utilizado el JoinColumn en una clase y en la otra mappedBy  
    @JoinColumn(name = "boya_id", referencedColumnName = "boya_id")
    @ManyToOne
    private Boya boya;

    public int getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(int muestraId) {
        this.muestraId = muestraId;
    }

    public String getMatriculaEmbarcacion() {
        return matriculaEmbarcacion;
    }

    public void setMatriculaEmbarcacion(String matriculaEmbarcacion) {
        this.matriculaEmbarcacion = matriculaEmbarcacion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getAlturaMar() {
        return alturaMar;
    }

    public void setAlturaMar(double alturaMar) {
        this.alturaMar = alturaMar;
    }


   
    public Date getHorarioMuestra() {
        return horarioMuestra;
    }

    public void setHorarioMuestra(Date horarioMuestra) {
        this.horarioMuestra = horarioMuestra;
    }

    


    public Boya getBoya() {
        return boya;
    }

    public void setBoya(Boya boya) {
        this.boya = boya;
        // por el ManyToOne
        // a la lista de empleados va a agregarle el obj
        // devuelve la lista de empleados de la categoria actual y me agrega a mí mismo (o sea, a categoria)
        this.boya.getMuestras().add(this);
    }

    
}