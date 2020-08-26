package ar.com.ada.api.empleados.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.repos.MuestraRepo;

@Service
public class MuestraService {
    @Autowired
    private MuestraRepo repo;

    public void crearMuestra(Muestra muestra){
        grabar(muestra);
    }

    public List<Muestra> obtenerMuestras(){
        return repo.findAll();
    }

	public Muestra obtenerPorId(int id) {
		return repo.findById(id);
	}
    
    public void grabar(Muestra muestra){
        repo.save(muestra);
    }
}