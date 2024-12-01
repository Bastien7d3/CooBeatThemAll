import java.util.ArrayList;
import Perso.Ennemi.Ennemi;

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
        String result = "Case " + id + " [";
    
        if (id == 0) {
            result += "Case départ !]";
            return result;
        }

        if (bonus != null && bonus.equals("Arrivée")) {
            result += "Arrivée !]";
            return result;
        }

        if (bonus != null) {
            result += "Bonus: " + bonus + ", ";
        }
    
        if (!ennemis.isEmpty()) { // isEmpty permet de vérifier si la chaine de carctères est vide ou pas
            result += "Ennemis: ";
            for (Ennemi ennemi : ennemis) {
                result += ennemi.GetNom() + " ";
            }
        } else {
            result += "Aucun ennemi";
        }

        result += "]";
        return result;
    }
}