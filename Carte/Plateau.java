import java.util.ArrayList;
import java.util.Random;

class Plateau {

    private int id;
    private String description;
    private int longueur;
    private ArrayList<Case> cases = new ArrayList<>();

    public Plateau(int id, String description, int longueur) {
        this.id = id;
        this.description = description;
        this.longueur = longueur;
        this.cases = new ArrayList<>();
    }

    public void genererCasesAleatoires(ArrayList<Case> casesPredefinies) {
        /*
         * Liste générée à partir des cases prédéfinies dans le main
         */
        Random random = new Random();
        
        for (int i = 0; i <= longueur; i++) {
            Case caseAleatoire = casesPredefinies.get(random.nextInt(casesPredefinies.size()));
            Case nouvelleCase = new Case(i, caseAleatoire.getBonus(), new ArrayList<>(caseAleatoire.getEnnemis()));
            cases.add(nouvelleCase);
        }
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    @Override
    public String toString() {
        /*
         * Affichage console du plateau avec ses différents
         */
        StringBuilder plateauInfo = new StringBuilder();
        plateauInfo.append("Plateau n° ").append(id).append("\n");
        plateauInfo.append("Description: ").append(description).append("\n");
        plateauInfo.append("Longueur: ").append(longueur).append(" cases\n");

        for (int i = 0; i < cases.size(); i++) {
            plateauInfo.append("  ").append(cases.get(i)).append("\n");
        }

        return plateauInfo.toString();
    }
}