package com.tuto.tuto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JourFerie {

    private Long id;

    public String nomJourFerie;
    public int day;
    public int month;
    public int year;

    public JourFerie(String nomJourFerie, int day, int month, int year) {
	this.nomJourFerie = nomJourFerie;
	this.day = day;
	this.month = month;
	this.year = year;
    }

    // méthodes pour calculer les jours fériés en rapport avec paques
    public static LocalDate paques(int annee) {

	int n = annee % 19;

	int c = annee / 100;

	int u = annee % 100;
	int s = c / 4;
	int t = c % 4;

	int p = (c + 8) / 25;

	int q = (c - p + 1) / 3;

	int e = (19 * n + c - s - q + 15) % 30;
	int b = u / 4;
	int d = u % 4;

	int l = (32 + 2 * t + 2 * b - e - d) % 7;

	int h = (n + 11 * e + 22 * l) / 451;
	int f = e + l - 7 * h + 114;
	int mois = f / 31;
	int jours = f % 31 + 1;

	return LocalDate.of(annee, mois, jours);
    };

    public static LocalDate lundiDePaques(int annee) {
	return paques(annee).plusDays(1);
    };

    public static LocalDate ascension(int annee) {
	return paques(annee).plusDays(39);
    };

    public static LocalDate lundiDePentecote(int annee) {
	return paques(annee).plusDays(50);
    };

    // méthode pour créer la liste des jours fériés
    public static List<JourFerie> joursFeriesArray() {
	GregorianCalendar calendar = new GregorianCalendar();
	List<JourFerie> ferieList = new ArrayList<JourFerie>();
	JourFerie nouvelAn = new JourFerie("Nouvel an", 1, 0, calendar.get(Calendar.YEAR));
	ferieList.add(nouvelAn);
	JourFerie nextNouvelAn = new JourFerie("Nouvel an année suivante", 1, 0, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextNouvelAn);
	JourFerie premierMai = new JourFerie("1er mai", 1, 4, calendar.get(Calendar.YEAR));
	ferieList.add(premierMai);
	JourFerie nextPremierMai = new JourFerie("1er mai année suivante", 1, 4, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextPremierMai);
	JourFerie huitMai = new JourFerie("8 mai", 8, 4, calendar.get(Calendar.YEAR));
	ferieList.add(huitMai);
	JourFerie nextHuitMai = new JourFerie("8 mai année suivante", 8, 4, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextHuitMai);
	JourFerie quatorzeJuillet = new JourFerie("14 juillet", 14, 6, calendar.get(Calendar.YEAR));
	ferieList.add(quatorzeJuillet);
	JourFerie nextQuatorzeJuillet = new JourFerie("14 juillet année suivante", 14, 6,
		calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextQuatorzeJuillet);
	JourFerie assomption = new JourFerie("Assomption", 15, 7, calendar.get(Calendar.YEAR));
	ferieList.add(assomption);
	JourFerie nextAssomption = new JourFerie("Assomption année suivante", 15, 7, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextAssomption);
	JourFerie toussaint = new JourFerie("Toussaint", 1, 10, calendar.get(Calendar.YEAR));
	ferieList.add(toussaint);
	JourFerie nextToussaint = new JourFerie("Toussaint année suivante", 1, 10, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextToussaint);
	JourFerie armistice = new JourFerie("Armistice", 11, 10, calendar.get(Calendar.YEAR));
	ferieList.add(armistice);
	JourFerie nextArmistice = new JourFerie("Armistice année suivante", 11, 10, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextArmistice);
	JourFerie noel = new JourFerie("Noël", 25, 11, calendar.get(Calendar.YEAR));
	ferieList.add(noel);
	JourFerie nextNoel = new JourFerie("Noël année suivante", 25, 11, calendar.get(Calendar.YEAR) + 1);
	ferieList.add(nextNoel);
	LocalDate paques = JourFerie.paques(calendar.get(Calendar.YEAR));
	JourFerie dimanchePaques = new JourFerie("Dimanche de Paques", paques.getDayOfMonth(),
		paques.getMonthValue() - 1, paques.getYear());
	ferieList.add(dimanchePaques);
	LocalDate paquesNextYear = JourFerie.paques(calendar.get(Calendar.YEAR) + 1);
	JourFerie dimanchePaquesNextYear = new JourFerie("Dimanche de Paques de l'année suivante",
		paquesNextYear.getDayOfMonth(), paquesNextYear.getMonthValue() - 1, paquesNextYear.getYear());
	ferieList.add(dimanchePaquesNextYear);
	LocalDate lunPaques = JourFerie.lundiDePaques(calendar.get(Calendar.YEAR));
	JourFerie lundiPaques = new JourFerie("Lundi de Paques", lunPaques.getDayOfMonth(),
		lunPaques.getMonthValue() - 1, lunPaques.getYear());
	ferieList.add(lundiPaques);
	LocalDate lunPaquesNextYear = JourFerie.lundiDePaques(calendar.get(Calendar.YEAR) + 1);
	JourFerie lundiPaquesNextYear = new JourFerie("Lundi de Paques de l'année suivante",
		lunPaquesNextYear.getDayOfMonth(), lunPaquesNextYear.getMonthValue() - 1, lunPaquesNextYear.getYear());
	ferieList.add(lundiPaquesNextYear);
	LocalDate ascens = JourFerie.ascension(calendar.get(Calendar.YEAR));
	JourFerie ascension = new JourFerie("Ascension", ascens.getDayOfMonth(), ascens.getMonthValue() - 1,
		ascens.getYear());
	ferieList.add(ascension);
	LocalDate ascensNextYear = JourFerie.ascension(calendar.get(Calendar.YEAR) + 1);
	JourFerie ascensionNextYear = new JourFerie("Ascension de l'année suivante", ascensNextYear.getDayOfMonth(),
		ascensNextYear.getMonthValue() - 1, ascensNextYear.getYear());
	ferieList.add(ascensionNextYear);
	LocalDate lunPentecote = JourFerie.lundiDePentecote(calendar.get(Calendar.YEAR));
	JourFerie lundiPentecote = new JourFerie("Lundi de Pentecôte", lunPentecote.getDayOfMonth(),
		lunPentecote.getMonthValue() - 1, lunPentecote.getYear());
	ferieList.add(lundiPentecote);
	LocalDate lunPentecoteNextYear = JourFerie.lundiDePentecote(calendar.get(Calendar.YEAR) + 1);
	JourFerie lundiPentecoteNextYear = new JourFerie("Lundi de Pentecôte de l'année suivante",
		lunPentecoteNextYear.getDayOfMonth(), lunPentecoteNextYear.getMonthValue() - 1,
		lunPentecoteNextYear.getYear());
	ferieList.add(lundiPentecoteNextYear);
	return ferieList;
    }
}
