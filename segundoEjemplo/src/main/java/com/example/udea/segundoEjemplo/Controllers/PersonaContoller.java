package com.example.udea.segundoEjemplo.Controllers;

import com.example.udea.segundoEjemplo.Entities.Persona;
import com.example.udea.segundoEjemplo.Services.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PersonaContoller {
    PersonaService servicio = new PersonaService();

    //metodo para mostrar lista

    @GetMapping("listarPersonas")
    public ArrayList<Persona> listar(){
        return servicio.mostrar();
    }

    //metodo para mostrar una persona
    @GetMapping("mostrarPersona/{nombre}")
    public Persona buscar(@PathVariable String nombre){
        return  servicio.buscarNombre(nombre);
    }

    //metodo para agregar persona
    @PostMapping("agregarPersona")
    public String persona(@RequestBody Persona p){
        return servicio.agregarPersona(p);
    }

    //Metodo para actulizar una persona
    @PutMapping("actualizarPersona")
    public String actualizarPersona(@RequestParam String nombre, @RequestParam String estadocivil) {

        Persona personaResponse = servicio.actualizarPersona(nombre, estadocivil);
        if (personaResponse == null) {
            return "Persona no encontrada";
        } else {
            return "Se actualizó con éxito: " + personaResponse;
        }
    }
    //Metodo para eliminar una persona
    @DeleteMapping("eliminarPersona/{nombre}")
    public String eliminarPersona(@PathVariable String nombre){
        Persona personaResponse = servicio.eliminarPersona(nombre);
        if (personaResponse == null) {
            return "Persona no encontrada";
        } else {
            return "Se Eliminó con éxito: " + personaResponse;
        }
    }
}
