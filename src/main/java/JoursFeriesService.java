import java.util.ArrayList;
import java.util.List;

public class JoursFeriesService {
    public static void main(String[] args) {
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
	ferieList.add(nouvelAn);

    }
};
