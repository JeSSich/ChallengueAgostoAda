package ar.com.ada.api.empleados.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.ada.api.noaa.entities.Muestra;

@Repository
public interface MuestraRepo extends JpaRepository<Muestra, Integer>{
    // al crear este metodo no necesitamos usar un optional, son menos lineas de codigo
    Muestra findById(int id);

}