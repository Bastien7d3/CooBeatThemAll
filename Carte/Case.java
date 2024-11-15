import java.util.ArrayList;
import Perso.Ennemi.*;

class Case {
    private int id;
    private String bonus;
    private ArrayList<Ennemi> ennemis;

    public Case(int id, String bonus, ArrayList<Ennemi> ennemis) {
        this.id = id;
        this.bonus = bonus;
        this.ennemis = ennemis;
    }

    public int getId() {
        return id;
    }

    public String getBonus() {
        return bonus;
    }

    public ArrayList<Ennemi> getEnnemis() {
        return ennemis;
    }

    @Override
    public String toString() {
        /*
         * Affichage console d'une case
         */
        String caseInfo = "Case " + id + " [";
    
        if (bonus != null) {
            caseInfo += "Bonus: " + bonus + ", ";
        }
    
        caseInfo += "Ennemis: " + (!ennemis.isEmpty() ? ( // sEmpty permet de vérifier si la chaine de carctères est vide ou pas
                    String.join(" ", ennemis.stream().map(Ennemi::getNom).toArray(String[]::new))
                   ):(
                    "Aucun ennemi"
                   ));
    
        caseInfo += "]";
        return caseInfo;
    }
}