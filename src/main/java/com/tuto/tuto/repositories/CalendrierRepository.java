package com.tuto.tuto.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tuto.tuto.model.Jour;
import com.tuto.tuto.model.JourFerie;
import com.tuto.tuto.model.Semaine;

@Repository
public class CalendrierRepository {
    static GregorianCalendar calendar = new GregorianCalendar();

    static List<Semaine> calendrier = new ArrayList<Semaine>();

    public static void main(String[] args) {

	int valueWeek = 0;

	List<JourFerie> ferieList = JourFerie.joursFeriesArray();
	for (int i = 0; i <= 52; i++) {
	    List<Jour> dayList = new ArrayList<Jour>();
	    calendar.getTime();
	    calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
	    ;

	    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

	    int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
	    Jour jour1 = new Jour("Lundi", calendar.getTime());
	    dayList.add(jour1);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 1);

	    Jour jour2 = new Jour("Mardi", calendar.getTime());
	    dayList.add(jour2);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 2);

	    Jour jour3 = new Jour("Mercredi", calendar.getTime());
	    dayList.add(jour3);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 3);

	    Jour jour4 = new Jour("Jeudi", calendar.getTime());
	    dayList.add(jour4);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 4);

	    Jour jour5 = new Jour("Vendredi", calendar.getTime());
	    dayList.add(jour5);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 5);

	    Jour jour6 = new Jour("Samedi", calendar.getTime(), false);
	    dayList.add(jour6);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 6);

	    Jour jour7 = new Jour("Dimanche", calendar.getTime(), false);
	    dayList.add(jour7);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 7);

	    Semaine semai = new Semaine(weekNumber, dayList);
	    calendrier.add(semai);
	    for (int f = 0; f < ferieList.size(); f++) {
		JourFerie jourFerie = ferieList.get(f);
		int dayFerie = jourFerie.day;
		int monthFerie = jourFerie.month;
		int yearFerie = jourFerie.year;
		for (int d = 0; d < dayList.size(); d++) {
		    Jour jourToVerify = dayList.get(d);
		    int day = jourToVerify.date.getDate();
		    int month = jourToVerify.date.getMonth();
		    int year = calendar.get(Calendar.YEAR);
		    if (day == dayFerie && month == monthFerie && year == yearFerie) {
			jourToVerify.setIsWorkedJour();
		    }
		}
	    }

	}
	for (int j = 0; j < calendrier.size(); j++) {
	    Semaine semaine0 = calendrier.get(j);
	    valueWeek = semaine0.getJoursOuvres();

	    System.out.println("Jours ouvrés :  " + valueWeek + "; Semaine numéro " + semaine0.numeroSemaine + ": du "
		    + semaine0.days.get(0).nomJour + " " + semaine0.days.get(0).date.toLocaleString() + " au "
		    + semaine0.days.get(4).nomJour + " " + semaine0.days.get(4).date.toLocaleString());

	}

    };

    public List<Semaine> getAllSemaines() {
	CalendrierRepository.main(null);
	return calendrier;
    }
}
