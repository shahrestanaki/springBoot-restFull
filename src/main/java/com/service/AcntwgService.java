package com.service;

import com.model.Acntwg;
import com.repository.entity.AcntwgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcntwgService {
    @Autowired
    public AcntwgRepository acntwgRepository;

    public Double getwage(String accNo) {
        Double acntwg = acntwgRepository.getwage(accNo);
        if (acntwg == null) {
            return Double.valueOf(-1);
        }
        return acntwg;
    }

    public Optional<Acntwg> findOn(Integer id) {
        System.out.println("********* AcntwgService -id " + id);
        return acntwgRepository.loadById(id);
    }

    public Acntwg loadWage(String accNo) {
        return acntwgRepository.loadWage(accNo);
    }

    public Acntwg save(Acntwg obj) {
        return acntwgRepository.save(obj);
    }

    public void delete(Integer id) {
        Acntwg obj = new Acntwg();
        obj.setId(id);
        acntwgRepository.delete(obj);
    }

    public List<Acntwg> findAll() {
        return acntwgRepository.findAll();
    }

    public Acntwg update(Acntwg obj) {
        Optional<Acntwg> old = findOn(obj.getId());
        if (old.isPresent()) {
            obj.setTrndate(old.get().getTrndate());
            return acntwgRepository.save(obj);
        } else {
            return null;
        }

    }
}
