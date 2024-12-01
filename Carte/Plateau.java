import java.util.ArrayList;
import java.util.Random;

import Perso.Ennemi.Ennemi;
import Perso.Ennemi.Boss.BossEnnemi;
import Perso.Ennemi.Brigand.BrigandEnnemi;

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
        
        for (int i = 0; i < longueur; i++) {
            Case caseAleatoire = casesPredefinies.get(random.nextInt(casesPredefinies.size()));

            int nombreEnnemis = random.nextInt(4);
            ArrayList<Ennemi> ennemisCopies = new ArrayList<>();
            for (int j = 0; j < nombreEnnemis; j++) {
                int typeEnnemi = random.nextInt(2);
                if (typeEnnemi == 0) {
                    ennemisCopies.add(new BrigandEnnemi());
                } else {
                    ennemisCopies.add(new BossEnnemi());
                }
            }

            Case nouvelleCase = new Case(i, caseAleatoire.getBonus(), ennemisCopies);
            cases.add(nouvelleCase);
        }

        Case caseArrivee = new Case(longueur, "Arrivée", new ArrayList<>());
        cases.add(caseArrivee);
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