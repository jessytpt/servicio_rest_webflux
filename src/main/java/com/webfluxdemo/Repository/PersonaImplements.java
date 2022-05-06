package com.webfluxdemo.Repository;

import com.webfluxdemo.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaImplements implements IPersonaRepository{

    private static Logger log = LoggerFactory.getLogger(PersonaImplements.class);

    @Override
    public Mono<Persona> registrar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Mono<Persona> modificar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Flux<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add( new Persona(1,"Hablando Claro"));
        personas.add( new Persona(2,"Coreano Mochilero"));
        personas.add( new Persona(3,"Tía Liv"));
        personas.add( new Persona(4,"BN Periodismo"));
        personas.add( new Persona(5,"Café con JJ"));

        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarPorId(Integer id) {

        return Mono.just(new Persona(id,"Me estabas buscando"));
    }

    @Override
    public Mono<Void> eliminar(Integer Id) {

        return Mono.empty();
    }
}
