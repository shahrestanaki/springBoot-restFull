package com.controller;

import com.service.AcntwgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@EnableAutoConfiguration
@RequestMapping("/acntwg")
public class AcntwgController {

    @Autowired
    public AcntwgService acntwgService;

    @RequestMapping(value = "/getwage", method = RequestMethod.GET)
    public Double getwage(@RequestParam("accno") String accno) {
        Double acntwg = acntwgService.getwage(accno);
        return acntwg;
    }
}
