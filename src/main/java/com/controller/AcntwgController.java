package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.Acntwg;
import com.service.AcntwgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Component
@RestController
@EnableAutoConfiguration
@RequestMapping("/acntwg")
public class AcntwgController {
    @Autowired
    public AcntwgService acntwgService;

    @GetMapping("/about")
    public String aboutMe() {
        return "Hello World";
    }

    @RequestMapping(value = "/getwage", method = RequestMethod.GET)
    public Double getwage(@RequestParam("accno") String accno) {
        Double acntwg = acntwgService.getwage(accno);
        return acntwg;
    }

    @RequestMapping(value = "/loadWage", method = RequestMethod.GET)
    public Acntwg loadWage(@RequestParam("accno") String accno) {
        return acntwgService.loadWage(accno);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Acntwg save(@RequestBody Acntwg obj) {
        return acntwgService.save(obj);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        acntwgService.delete(id);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Acntwg> findAll() {
        return acntwgService.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Acntwg update(@RequestBody Acntwg obj) {
        System.out.println("********* AcntwgController  " );
        return acntwgService.update(obj);
    }
}
