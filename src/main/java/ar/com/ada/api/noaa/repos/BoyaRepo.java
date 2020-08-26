package ar.com.ada.api.noaa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.noaa.entities.Boya;
// los repos pasan a ser interfaces
// hereda de otra interface con una serie de métodos (buscar, grabar, actualizar, eliminar, buscar todos)
@Repository
public interface BoyaRepo extends JpaRepository<Boya, Integer>{
    
    
}