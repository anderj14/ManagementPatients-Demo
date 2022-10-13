package com.example.demo.patiens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatiensService {

    private final PatiensRepository patiensRepository;

    @Autowired

    public PatiensService(PatiensRepository patiensRepository) {
        this.patiensRepository = patiensRepository;
    }

    public List<Patiens> getPatiens(){
        return patiensRepository.findAll();
    }

    public Patiens getPatien(Long id){
        Patiens patiens = getPatiens().stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return patiens;
    }

    // add Patiens
    public void addPatiens(Patiens patiens){
        Optional<Patiens> patiensOptional = patiensRepository
                .findPatiensByCedula(patiens.getCedula());
        if(patiensOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        patiensRepository.save(patiens);
    }



}
