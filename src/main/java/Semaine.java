import java.util.List;

public class Semaine {
    private final int numeroSemaine;
    private final List<Jour> days;

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
     * i++) {
     * 
     * if (days.get(i).isWorked) { count += 1;
     * 
     * }
     * 
     * } return count;
     * 
     * }
     */

    public int getJoursOuvres() {
	return (int) this.days.stream().filter(day -> day.isWorked).count();
    }

}
