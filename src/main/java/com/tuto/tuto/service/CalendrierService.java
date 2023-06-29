package com.tuto.tuto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.tuto.model.Semaine;
import com.tuto.tuto.repositories.CalendrierRepository;

import lombok.Data;

@Data
@Service
public class CalendrierService {
    @Autowired
    private CalendrierRepository calendrierRepository;

    public Iterable<Semaine> getCalendrier() {

	return calendrierRepository.getAllSemaines();
    }
}
