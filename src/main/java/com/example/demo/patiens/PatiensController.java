package com.example.demo.patiens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patiens")
public class PatiensController {

    private final PatiensService patiensService;

    @Autowired
    public PatiensController(PatiensService patiensService) {
        this.patiensService = patiensService;
    }

    @GetMapping
    public List<Patiens> getPatiens(String keyword){
        return patiensService.getPatiens();
    }

    @GetMapping(value = "/{id}" )
    public Patiens getPatien(@PathVariable Long id){
        return patiensService.getPatien(id);
    }

    @PostMapping
    public void addPatiens(@RequestBody Patiens patiens){
        patiensService.addPatiens(patiens);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatiens(@PathVariable("id") Long id){
        patiensService.deletePatiens(id);
    }

}
