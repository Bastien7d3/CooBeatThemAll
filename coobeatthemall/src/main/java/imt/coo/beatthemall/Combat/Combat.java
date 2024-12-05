package imt.coo.beatthemall.Combat;

import java.util.Random;
import java.util.Scanner;

import java.util.logging.Logger;

import imt.coo.beatthemall.Perso.Perso.Perso;
import imt.coo.beatthemall.Perso.Perso.Hero.Hero;

/**
 * Classe représentant un combat entre un héros (joueur1) et un autre personnage (joueur2).
 */
public class Combat {
    private static final Logger logger = Logger.getLogger(Combat.class.getName());

    private Hero joueur1; // Le héros qui participe au combat
    private Perso joueur2; // L'adversaire du héros

    // Constructeur
    public Combat(Hero joueur1, Perso joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        logger.info("Combat initialisé entre " + joueur1.getName() + " et " + joueur2.getName() + ".");
    }

    /**
     * Lance le combat entre le héros et son adversaire.
     */
    public void lancerCombat() {
        logger.info("Le combat commence entre " + joueur1.getName() + " et " + joueur2.getName() + ".");

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Le combat commence entre " + joueur1.getName() + " et " + joueur2.getName() + " !");
        int choix;

        // Boucle de combat
        while (joueur1.isAlive() && joueur2.isAlive()) {
            System.out.println("Utiliser la capacité spéciale ? (1 = oui | 2 = non)");
            choix = scanner.nextInt();
            if (choix == 1) {
                logger.info(joueur1.getName() + " utilise sa capacité spéciale.");
                joueur1.useUltimate();
            } else {
                // Héros attaque entre 1 et 5 fois
                int nbAttaques = random.nextInt(5) + 1;
                System.out.println(joueur1.getName() + " attaque " + nbAttaques + " fois !");
                logger.info("le Héro attaque " + nbAttaques + " fois !"); 
                for (int i = 0; i < nbAttaques && joueur2.isAlive(); i++) {
                    int degats = calculerDegats(joueur1, joueur2);
                    joueur2.takeDamage(degats);
                    logger.info("Le Héro inflige " + degats + " points de dégâts à l'ennemi.");
                    System.out.println(joueur1.getName() + " inflige " + degats + " points de dégâts à "
                            + joueur2.getName() + ".");
                    if (!joueur2.isAlive()) {
                        logger.info(joueur2.getName() + " est mort.");
                        System.out.println(joueur2.getName() + " est mort !");
                        System.out.println("Le combat est gagné ! ! ! ");
                        break;
                    }
                }
                if (!joueur2.isAlive()) {
                    break;
                }

                // Tour du joueur2 attaquant
                effectuerAttaque(joueur2, joueur1);
                if (!joueur1.isAlive()) {
                    logger.info(joueur1.getName() + " est mort.");
                    System.out.println(joueur1.getName() + " est mort !");
                    System.out.println("Le combat est perdu . . .");
                    break;
                }
            }
        }
    }

    /**
     * Effectue une attaque entre deux personnages.
     *
     * @param attaquant Le personnage qui attaque.
     * @param defenseur Le personnage qui se défend.
     */
    private void effectuerAttaque(Perso attaquant, Perso defenseur) {
        int degats = calculerDegats(attaquant, defenseur);
        defenseur.takeDamage(degats);

        System.out.println(attaquant.getName() + " attaque " + defenseur.getName() + " et inflige " + degats
                + " points de dégâts !");
        System.out.println(defenseur.getName() + " a maintenant " + defenseur.getPv() + " PV.");
        logger.info("Dégats entre joueur effectués : " + degats);
    }

    /**
     * Calcule les dégâts infligés.
     *
     * @param attaquant Le personnage qui attaque.
     * @param defenseur Le personnage qui se défend.
     * @return Les points de dégâts infligés.
     */
    private int calculerDegats(Perso attaquant, Perso defenseur) {

        // Calcul de la base avec les statistiques existantes
        double base = attaquant.getAtt() * 1.2;

        // Réduction des dégâts par la défense
        double reduction = defenseur.getDef() * 0.5;

        // Calcul final des dégâts
        int degats = (int) Math.max(base - reduction, 1);

        logger.info("Dégats calsulés avec succès.");

        // Limiter les dégâts à la vie restante du défenseur
        return Math.min(degats, defenseur.getPv());
    }
}
