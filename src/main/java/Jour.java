import java.util.Date;

public class Jour {
    String nomJour;
    Date date;
    boolean isWorked;

    public Jour(String nomJour, Date date, boolean isWorked) {
	this.nomJour = nomJour;
	this.date = date;
	this.isWorked = isWorked;
    };

    public Jour(String nomJour, Date date) {
	this.nomJour = nomJour;
	this.date = date;
	this.isWorked = true;
    };

    public void setIsWorkedJour(int day, int dayFerieList, int month, int monthFerieList, int year, int yearFerieList) {
	if (day == dayFerieList && month == monthFerieList && year == yearFerieList) {
	    this.isWorked = false;
	}

    }
}
