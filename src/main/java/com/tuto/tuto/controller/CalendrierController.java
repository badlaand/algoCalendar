package com.tuto.tuto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.tuto.model.Semaine;
import com.tuto.tuto.service.CalendrierService;

@RestController
public class CalendrierController {
    @Autowired
    private CalendrierService calendrierService;

    @GetMapping("/api/calendrier")
    public Iterable<Semaine> getCalendrierPdc() {
	Iterable<Semaine> calendrier = calendrierService.getCalendrier();
	return calendrier;
    }
}
