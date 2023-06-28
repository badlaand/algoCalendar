import java.time.LocalDate;

public class JourFerie {
    String nomJourFerie;
    int day;
    int month;
    int year;

    public JourFerie(String nomJourFerie, int day, int month, int year) {
	this.nomJourFerie = nomJourFerie;
	this.day = day;
	this.month = month;
	this.year = year;
    }

    public JourFerie(String nomJourFerie, int day, int month) {
	this.nomJourFerie = nomJourFerie;
	this.day = day;
	this.month = month;

    }

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
}
