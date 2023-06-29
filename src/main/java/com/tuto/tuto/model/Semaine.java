package com.tuto.tuto.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semaine {

    private int id = 0;
    public int numeroSemaine = 0;
    public List<Jour> days = null;

    /*
     * Date day2; Date day3; Date day4; Date day5; Date day6; Date day7; String
     * nomSemaine; boolean isTravaille;
     */

    public Semaine(int numeroSemaine, List<Jour> days) {
	this.numeroSemaine = numeroSemaine;
	this.days = days;

    }

    /*
     * public int getJoursOuvres() { int count = 0; for (int i = 0; i < days.size();
     * i++) { if (days.get(i).worked) { count += 1; } } return count;
     * 
     * }
     */

    public int getJoursOuvres() {
	return (int) this.days.stream().filter(day -> day.worked).count();
    }

}
