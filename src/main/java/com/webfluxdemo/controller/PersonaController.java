package com.webfluxdemo.controller;

import com.webfluxdemo.Repository.IPersonaRepository;
import com.webfluxdemo.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/*
Hay dos posibilidades de hacer un servicio con reactividad
    1. Con anotaciones(Spring MVC)
    2. Con progrqmación funcional
  En este caso se trabajará con anotaciones
 */

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private static Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private IPersonaRepository personaRepository;

    @GetMapping
    public Flux<Persona> listar()
    {
       return personaRepository.listar();

    }


}
