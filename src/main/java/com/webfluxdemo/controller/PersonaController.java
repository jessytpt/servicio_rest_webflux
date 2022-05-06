package com.webfluxdemo.controller;

import com.webfluxdemo.Repository.IPersonaRepository;
import com.webfluxdemo.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
Hay dos posibilidades de hacer un servicio con reactividad
    1. Con anotaciones(Spring MVC)
    2. Con progrqmación funcional
  En este caso se trabajará con anotaciones
 */

@RestController
@RequestMapping("/customers")
public class PersonaController {
    private static Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private IPersonaRepository personaRepository;

    @GetMapping("/all")
    public Flux<Persona> listar()
    {
       return personaRepository.listar();

    }

    @PostMapping("/new")
    public Mono<Persona> registrar(@RequestBody Persona persona){
        return personaRepository.registrar(persona);
    }

    @PutMapping("/save")
    public Mono<Persona> modificar(@RequestBody Persona persona){
        return personaRepository.modificar(persona);
    }

    @GetMapping("/product/{idProduct}")
    public Mono<Persona> listarPorId(@PathVariable("idProduct") int idProduct){
        return personaRepository.listarPorId(idProduct);
    }

    @DeleteMapping("/delete/{Id}")
    public Mono<Void> eliminar(@PathVariable("Id") int Id) {
        // Comprueba sì primero existe el elemento y luego lo elimina
        return personaRepository.listarPorId(Id)
                .flatMap( p -> personaRepository.eliminar(p.getIdPersona()));
    }







}
