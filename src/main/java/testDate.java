import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class testDate {

    static GregorianCalendar calendar = new GregorianCalendar();
    static GregorianCalendar calendar2 = new GregorianCalendar();
    static GregorianCalendar calendar3 = new GregorianCalendar();

    static boolean isNotWork = false;

    public static void main(String[] args) {

	List<Semaine> calendrier = new ArrayList<Semaine>();

	List<Jour> dayList = new ArrayList<Jour>();

	calendar2.setWeekDate(2023, 0, 1);
	List<JourFerie> ferieList = new ArrayList<JourFerie>();
	JourFerie nouvelAn = new JourFerie("Nouvel an", 1, 0);
	ferieList.add(nouvelAn);
	JourFerie premierMai = new JourFerie("1er mai", 1, 4);
	ferieList.add(premierMai);
	JourFerie huitMai = new JourFerie("8 mai", 8, 4);
	ferieList.add(huitMai);
	JourFerie quatorzeJuillet = new JourFerie("14 juillet", 14, 6);
	ferieList.add(quatorzeJuillet);
	JourFerie assomption = new JourFerie("Assomption", 15, 7);
	ferieList.add(assomption);
	JourFerie toussaint = new JourFerie("Toussaint", 1, 10);
	ferieList.add(toussaint);
	JourFerie armistice = new JourFerie("Armistice", 11, 10);
	ferieList.add(armistice);
	JourFerie noel = new JourFerie("Noël", 25, 11);
	ferieList.add(noel);
	LocalDate paques = JourFerie.paques(calendar.get(Calendar.YEAR));
	JourFerie dimanchePaques = new JourFerie("Dimanche de Paques", paques.getDayOfMonth(),
		paques.getMonthValue() - 1, paques.getYear());
	ferieList.add(dimanchePaques);
	LocalDate paquesNextYear = JourFerie.paques(calendar.get(Calendar.YEAR) + 1);
	JourFerie dimanchePaquesNextYear = new JourFerie("Dimanche de Paques de l'année suivante",
		paquesNextYear.getDayOfMonth(), paquesNextYear.getMonthValue() - 1, paquesNextYear.getYear());
	ferieList.add(dimanchePaquesNextYear);
	for (int i = 0; i < 52; i++) {
	    calendar.getTime();
	    calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
	    ;

	    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
	    calendar2.set(Calendar.DAY_OF_YEAR, dayOfYear + 6);

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
// mettre la condition ici!

	    for (int f = 0; f < ferieList.size(); f++) {
		JourFerie jourFerie = ferieList.get(f);
		int dayFerie = jourFerie.day;
		int monthFerie = jourFerie.month;
		int yearFerie = calendar.get(Calendar.YEAR);
		for (int d = 0; d < dayList.size(); d++) {
		    Jour jourToVerify = dayList.get(d);
		    int day = jourToVerify.date.getDate();
		    int month = jourToVerify.date.getMonth();
		    int year = calendar.get(Calendar.YEAR);
		    System.out.println("jour à vérifier " + day + " " + month + " " + year);
		    jourToVerify.setIsWorkedJour(day, dayFerie, month, monthFerie, year, yearFerie);

		    System.out.println("jour ferie" + dayFerie + " " + monthFerie + " " + yearFerie);
		}
	    }

	    Semaine semai = new Semaine(weekNumber, jour1, jour2, jour3, jour4, jour5, jour6, jour7);
	    int valueWeek = semai.getJoursOuvres();
	    semai.setSemaine(valueWeek);
	    calendrier.add(semai);

	}
	for (int j = 0; j < calendrier.size(); j++) {
	    Semaine semaine0 = calendrier.get(j);

	    /*
	     * if (semaine0.day1.date.getDate() == 1 && semaine0.day1.date.getMonth() == 0)
	     * {
	     * 
	     * semaine0.day1.setIsWorkedJour(false); System.out.println("JOUR FERIE");
	     * 
	     * }
	     */

	    System.out.println("valeur semaine   " + semaine0.valeurSemaine + " Semaine numéro "
		    + semaine0.numeroSemaine + ": du " + semaine0.day1.nomJour + " "
		    + semaine0.day1.date.toLocaleString() + " au " + semaine0.day5.nomJour + " "
		    + semaine0.day5.date.toLocaleString() + "test férié" + semaine0.day1.isWorked + "    "
		    + semaine0.day1.date.getDate() + " /" + semaine0.day1.date.getMonth() + " /" + paques.getYear());

	}

	System.out.println(ferieList.get(9).month + " " + ferieList.get(9).day + " " + ferieList.get(9).year);
	System.out.println(paquesNextYear.getYear());
    };

}