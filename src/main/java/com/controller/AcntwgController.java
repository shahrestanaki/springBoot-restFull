package com.controller;

import com.service.AcntwgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/about")
    public String aboutMe() {
        return "Hello World";
    }
}
