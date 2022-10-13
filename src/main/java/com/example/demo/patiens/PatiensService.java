package com.example.demo.patiens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
            throw new IllegalStateException("Cedula taken");
        }

        patiensRepository.save(patiens);
    }

    // Remove patiens
    public void deletePatiens(Long id){
        boolean exists = patiensRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Patiens with id " + id + " does not exists");
        }

        patiensRepository.deleteById(id);
    }

    // update patiens
    @Transactional
    public void updatePatiens(Long id, String firstName, String lastName, Long phone, Long cedula){
        Patiens patiens = patiensRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Patiens with id " + id + " does not exits"
                ));

        // Validations of patiens

        if(firstName != null && firstName.length() > 0 && !Objects.equals(patiens.getFirstName(), firstName)){
            patiens.setFirstName(firstName);
        }

        if(lastName != null && lastName.length() > 0 && !Objects.equals(patiens.getLastName(), lastName)){
            patiens.setLastName(lastName);
        }

        if(phone != null && phone > 0 && !Objects.equals(patiens.getPhone(), phone)){
            patiens.setPhone(phone);
        }

        if(cedula != null && cedula > 0 && !Objects.equals(patiens.getCedula(), cedula)){
            Optional<Patiens> patiensOptional = patiensRepository.findPatiensByCedula(cedula);
            if(patiensOptional.isPresent()){
                throw new IllegalStateException("Cedula taken");
            }
            patiens.setCedula(cedula);
        }

    }



}
