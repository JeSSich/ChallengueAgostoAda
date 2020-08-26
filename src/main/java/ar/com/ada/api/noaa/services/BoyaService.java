package ar.com.ada.api.noaa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.noaa.entities.Categoria;
import ar.com.ada.api.noaa.repos.CategoriaRepo;
// logica de negocio de las categorias
@Service
public class BoyaService {
    @Autowired
    private BoyaRepo repo;

    public void crearBoya( Boya boya){
        repo.save(boya);

    }

    public List<Boya> obtenerBoyas(){
        return (repo.findAll());
    }

    public Boyas obtenerPorId(int boyaId){
        // el findById devuelve un optional, si la encuentra devuelve un objeto, sino nulo
        Optional<Boya> c = repo.findById(boyaId);

        if (c.isPresent())
            return c.get();
        return null;

    }
    
}