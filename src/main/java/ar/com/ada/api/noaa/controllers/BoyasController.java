package ar.com.ada.api.noaa.controllers;

import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.noaa.entities.Boya;
import ar.com.ada.api.noaa.models.response.GenericResponse;
import ar.com.ada.api.noaa.services.BoyaService;
// el controller va a hacer el método que vamos a exponer a internet para que desde internet a nosotros nos manden la info
// pero el controller delega al service que cree la categoria y a su vez el service se lo va a delegar al repo
// el controller es publicado en front
@RestController
public class BoyasController {
    @Autowired
    BoyaService boyaService;
    // indica a front que haga un post a la ruta indicada (categorias)
    // buenas practicas sustantivos en plural(api rest)
    @PostMapping("/boyas")
    public ResponseEntity<?> crearBoya(@RequestBody Boya boyas){
        boyaService.crearBoya(boya);
        GenericResponse gR = new GenericResponse();
        gR.isOk = true;
        gR.id = boya.getBoyaId();
        gR.message = "Boya creada de manera exitosa";
        // damos una respuesta a front
        // serializar, transformar un obj o algo a un flujo de cadena de textos (JSON es un texto, convertimos el obj en 
        // java a un String de texto)
        return ResponseEntity.ok(gR);
    }

    @GetMapping("/boyas")
    public ResponseEntity<List<Boya>> listarBoyas(){
        return ResponseEntity.ok(boyaService.obtenerBoyas());     
    }
    


    
    @GetMapping("/boyas/{id}")
     public ResponseEntity<Boyas> obtenerBoya(@PathVariable int id){
        Boya boya = boyaService.obtenerPorId(id);
        if(boya == null){
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(boya);
    }
}