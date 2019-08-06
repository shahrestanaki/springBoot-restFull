package com.service;

import com.repository.entity.AcntwgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcntwgService {
    @Autowired
    public AcntwgRepository acntwgRepository;

    public Double getwage(String accNo) {
        Double acntwg = acntwgRepository.getwage(accNo);
        if (acntwg== null) {
            return Double.valueOf(-1);
        }
        return acntwg;
    }
}
