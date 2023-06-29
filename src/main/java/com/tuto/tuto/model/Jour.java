package com.tuto.tuto.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jour {

    private Long id;
    public String nomJour;
    public Date date;
    boolean worked;

    public Jour(String nomJour, Date date, boolean worked) {
	this.nomJour = nomJour;
	this.date = date;
	this.worked = worked;
    };

    public Jour(String nomJour, Date date) {
	this.nomJour = nomJour;
	this.date = date;
	this.worked = true;
    };

    public void setIsWorkedJour() {

	this.worked = false;

    }
}
