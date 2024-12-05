package imt.coo.beatthemall.Carte;

import java.util.ArrayList;
import java.util.logging.Logger;

import imt.coo.beatthemall.Perso.Perso.Ennemi.Ennemi;

/**
 * Classe représentant une case sur un plateau de jeu.
 * Chaque case peut avoir un identifiant, un bonus, et une liste d'ennemis.
 */
public class Case {

    private static final Logger logger = Logger.getLogger(Case.class.getName());

    private int id; // Identifiant unique de la case
    private String bonus; // Bonus associé à la case (peut être null)
    private ArrayList<Ennemi> ennemis; // Liste des ennemis présents sur la case

    /**
     * Constructeur de la case.
     *
     * @param id id de la case
     * @param bonus bonus de la case (peut être null)
     * @param ennemis liste des ennemis présents sur la case
     */
    public Case(int id, String bonus, ArrayList<Ennemi> ennemis) {
        this.id = id;
        this.bonus = bonus;
        this.ennemis = ennemis;
        logger.info("Case initialisé avec succès.");
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

    /**
     * Affichage console d'une case.
     *
     * @return Une chaîne décrivant la case.
     */
    @Override
    public String toString() {
        logger.info("Génération de la représentation console d'une case.");

        String result = "Case " + id + " [";
    
        if (id == 0) {
            result += "Case départ !]";
            return result;
        }

        if (bonus != null && bonus.equals("Arrivée")) {
            result += "Arrivée !]";
            return result;
        }

        // Bonus de la case
        if (bonus != null) {
            result += "Bonus: " + bonus + ", ";
        }
    
        // Ennemis présents sur la case
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