package com.example.demo.patiens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Patiens> getPatiens(){
        return patiensService.getPatiens();
    }

    @GetMapping(value = "/{id}" )
    public Patiens getPatien(@PathVariable Long id){
        return patiensService.getPatien(id);
    }
}
