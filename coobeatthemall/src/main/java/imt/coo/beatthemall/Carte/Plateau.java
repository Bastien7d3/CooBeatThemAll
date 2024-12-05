import java.util.ArrayList;
import java.util.Random;

import java.util.logging.Logger;

import Perso.Ennemi.Ennemi;
import Perso.Ennemi.Boss.BossEnnemi;
import Perso.Ennemi.Brigand.BrigandEnnemi;

/**
 * Classe Représentant un plateau de jeu composé de plusieurs cases.
 * Chaque plateau a un identifiant, une description, une longueur, et une liste de cases.
 */
class Plateau {

    private static final Logger logger = Logger.getLogger(Plateau.class.getName());

    private int id; // Identifiant unique du plateau
    private String description; // Description du plateau
    private int longueur; // Nombre de cases du plateau
    private ArrayList<Case> cases = new ArrayList<>(); // Liste des cases sur le plateau

    /**
     * Constructeur pour créer un plateau.
     *
     * @param id id du plateau.
     * @param description description du plateau.
     * @param longueur longueur du plateau.
     */
    public Plateau(int id, String description, int longueur) {
        this.id = id;
        this.description = description;
        this.longueur = longueur;
        this.cases = new ArrayList<>();
        logger.info("Plateau initialisé avec succès.");
    }

    /**
     * Génère aléatoirement les cases du plateau en utilisant une liste de cases prédéfinies.
     * 
     * @param casesPredefinies liste de cases prédéfinies
     */
    public void genererCasesAleatoires(ArrayList<Case> casesPredefinies) {

        Random random = new Random();
        
        for (int i = 0; i < longueur; i++) {
            // Sélectionner une case aléatoire parmi les cases prédéfinies
            Case caseAleatoire = casesPredefinies.get(random.nextInt(casesPredefinies.size()));

            int nombreEnnemis = random.nextInt(4);
            ArrayList<Ennemi> ennemisCopies = new ArrayList<>();
            for (int j = 0; j < nombreEnnemis; j++) {
                // Choisir un type d'ennemi aléatoire
                int typeEnnemi = random.nextInt(2);
                if (typeEnnemi == 0) {
                    ennemisCopies.add(new BrigandEnnemi());
                } else {
                    ennemisCopies.add(new BossEnnemi());
                }
            }

            // Créer une nouvelle case avec des ennemis générés
            Case nouvelleCase = new Case(i, caseAleatoire.getBonus(), ennemisCopies);
            cases.add(nouvelleCase);
            logger.info("Case générée avec succès.");
        }

        Case caseArrivee = new Case(longueur, "Arrivée", new ArrayList<>());
        cases.add(caseArrivee);

        logger.info("Génération des cases du plateau terminée.");
    }

    /**
     * Retourne la liste des cases du plateau.
     * 
     * @return liste des cases du plateau.
     */
    public ArrayList<Case> getCases() {
        logger.info("Accès à la liste des cases du plateau.");
        return cases;
    }

    /**
     * Affichage console du plateau
     * 
     * @return Une chaîne de caractères décrivant le plateau
     */
    @Override
    public String toString() {
        logger.info("Génération de la représentation console du plateau.");
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