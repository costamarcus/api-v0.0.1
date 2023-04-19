package br.com.incubesoftware.api.controller;

import br.com.incubesoftware.api.model.Person;
import br.com.incubesoftware.api.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
            @PathVariable(value = "id") String id
    ) throws Exception {
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person create(@RequestBody Person person) throws Exception {
        return service.create(person);
    }

    @RequestMapping( value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(
            @PathVariable(value = "id") String id,
            @RequestBody Person person) throws Exception {
        return service.update(person);
    }

    @RequestMapping( value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(
            @PathVariable(value = "id") String id
    ) throws Exception {
        service.delete(id);
    }
}
