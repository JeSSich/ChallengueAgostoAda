package ar.com.ada.api.noaa.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.noaa.entities.Muestra;
import ar.com.ada.api.noaa.models.request.InfoEmpleadaRequest;
import ar.com.ada.api.noaa.models.request.RegistrarMuestraRequest;
import ar.com.ada.api.noaa.models.request.SueldoModifRequest;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.*;

@RestController
public class MuestrasController {
    @Autowired
    MuestrasService muestrasService;
    @Autowired
    MuestrasService boyasService;

    @PostMapping("/muestras")
    public ResponseEntity<?> crearMuestra(@RequestBody RegistrarMuestraRequest info){
        Muestra muestra = new Muestra();      
        muestra.setMuestraId(muestraId);
        muestra.setMatriculaEmbarcacion(info.matriculaEmbarcacion);
        muestra.setLatitud(info.latitud);
        muestra.setLongitud(info.longitud);
   
        muestra.setAlturaMar(info.setAlturaMar);
        muestra.sethorarioMuestra(new Date());
        muestra.setBoya(boyaService.obtenerPorId(info.boyaId));
        muestraService.crearMuestra(muestra);
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = muestra.getMuestraId();
        gR.message = "Muestra creada con exito";
        return ResponseEntity.ok(gR);
    }
    
    @GetMapping("/muestras")
    public ResponseEntity<List<Muestra>> listarMuestra(){
        return ResponseEntity.ok(muestraService.obteneMuestras());
    }

    @GetMapping("/muestras/{id}")
    //la variable id de tipo int va a estar en la ruta, se tiene que llamar igual a como esta declarado arriba, por eso la @PathVariable
    public ResponseEntity<Muestra> obtenerMuestra(@PathVariable int id){
        Muestra muestras = muestrasService.obtenerPorId(id);
        if(muestras == null){
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(muestra);
    }

    @GetMapping("/muestras/boyas/{boyaId}")
    public ResponseEntity<List<Muestra>> listarPorBoyaId(@PathVariable int boyaId){
        List<Muestra> listaMuestras = boyaService.obtenerPorId(boyaId).getMuestras();
        return ResponseEntity.ok(listaMuestras);
    }
 
    @PutMapping("/muestras/{id}/")
    public ResponseEntity<GenericResponse> actualizarMuestra(@PathVariable int id, @RequestBody RegistrarMuestraRequest muestraRequest){
        Muestra muestra = muestraService.obtenerPorId(id);
        if(muestra == null){
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        muestra.setBoya(boya);
        muestra.setHorarioMuestra(horarioMuestra);
        muestra.setMatriculaEmbarcacion(matriculaEmbarcacion);
        muestra.setAlturaMar(alturaMar);
        muestraService.grabar(muestra);
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = muestra.getMuestraId();
        gR.message = "Muestra actualizada con exito";
        return ResponseEntity.ok(gR);
    }
    
    @DeleteMapping("/muestras/{id}")
    public ResponseEntity<GenericResponse> resetearColorMuestra(@PathVariable int id){
        Muestra muestra = muestraService.obtenerPorId(id);
        if(muestra == null){
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        muestra.getBoya().setColor("Azul");
        muestraService.grabar(muestra);
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = muestra.getMuestraId();
        gR.message = "Color azul seteado";
        return ResponseEntity.ok(gR);
    }
}