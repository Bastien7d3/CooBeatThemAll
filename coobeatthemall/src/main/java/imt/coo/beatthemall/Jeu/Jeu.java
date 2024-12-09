package imt.coo.beatthemall.Jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import imt.coo.beatthemall.Carte.Plateau;
import imt.coo.beatthemall.Carte.Case;
import imt.coo.beatthemall.Combat.Combat;
import imt.coo.beatthemall.Perso.Perso.Hero.Hero;
import imt.coo.beatthemall.Perso.Perso.Hero.Mage.MageHero;
import imt.coo.beatthemall.Perso.Perso.Hero.Warrior.WarriorHero;
import imt.coo.beatthemall.Perso.Perso.Ennemi.Brigand.BrigandEnnemi;
import imt.coo.beatthemall.Perso.Perso.Ennemi.Ennemi;
import imt.coo.beatthemall.Perso.Perso.Ennemi.Boss.BossEnnemi;

/**
 * Classe permettant de lancer le jeu.
 */
public class Jeu {

    protected static Logger logger = Logger.getLogger(Jeu.class.getName());

    /**
     * Lancer le jeu en demandant à l'utilisateur de choisir un plateau et un heros.
     * 
     * @return Un tableau d'objets contenant le plateau choisi et le heros choisi.
     */
    public static Object[] lancer() {

        logger.info("Demarrage de la methode lancer()");
        System.out.println("------------------------------------------------------------");
        System.out.println("\nBonjour et bienvenue sur le jeu de CooBeatThemAll !\n");
        System.out.println("CooBeatThemAll est un mini-jeu de combat en Java, dans lequel des heros affrontent divers ennemis. Ce projet illustre une architecture orientee objet avec des concepts tels que l'heritage, les classes abstraites et le polymorphisme. Chaque personnage possede ses propres attributs et competences specifiques, ce qui permet d'experimenter differentes strategies de combat.\n");
        System.out.println("------------------------------------------------------------");
        logger.info("Presentation du jeu affichee.");
        System.out.println("------------------------------------------------------------\n");
        System.out.println("Pour commencer, veuillez choisir un numero de plateau :\n");

        // creation 3 plateaux
        Plateau plateau10 = new Plateau(1, "Petit plateau (10 cases)", 10);
        Plateau plateau15 = new Plateau(2, "Moyen plateau (15 cases)", 15);
        Plateau plateau20 = new Plateau(3, "Grand plateau (20 cases)", 20);

        logger.info("3 plateaux crees.");
        System.out.println("------------------------------------------------------------\n");
        // cases predefinies
        ArrayList<Case> casesPredefinies = new ArrayList<>();
        casesPredefinies.add(new Case(1, "Bonus de soin", new ArrayList<>()));
        casesPredefinies.add(new Case(2, "Bonus d'attaque", new ArrayList<>()));
        casesPredefinies.add(new Case(4, "Pas de bonus", new ArrayList<>(List.of(new BrigandEnnemi()))));
        casesPredefinies.add(new Case(5, "Pas de bonus", new ArrayList<>(List.of(new BossEnnemi()))));

        logger.info("Cases predefinies generees.");
        System.out.println("------------------------------------------------------------\n");
        Plateau plateauChoisi = null;
        Scanner scanner = new Scanner(System.in);

        while (plateauChoisi == null) {
            System.out.println("1 - " + plateau10);
            System.out.println("2 - " + plateau15);
            System.out.println("3 - " + plateau20);
            System.out.println("Numero du plateau : ");

            int numPlateau = scanner.nextInt();

            if (numPlateau == 1) {
                plateau10.genererCasesAleatoires(casesPredefinies);
                plateauChoisi = plateau10;
                logger.info("Plateau 10 cases selectionne.");
                System.out.println("Petit plateau enregistre avec succes !");
            } else if (numPlateau == 2) {
                plateau15.genererCasesAleatoires(casesPredefinies);
                plateauChoisi = plateau15;
                logger.info("Plateau 15 cases selectionne.");
                System.out.println("Moyen plateau enregistre avec succes !");
            } else if (numPlateau == 3) {
                plateau20.genererCasesAleatoires(casesPredefinies);
                plateauChoisi = plateau20;
                logger.info("Plateau 20 cases selectionne.");
                System.out.println("Grand plateau enregistre avec succes !");
            } else {
                logger.warning("Choix invalide pour le plateau.");
                System.out.println("Choix invalide. Veuillez reessayer.\n");
            }
        }
        System.out.println("------------------------------------------------------------\n");
        // creation des heros
        Hero joueur1 = null;
        while (joueur1 == null) {
            System.out.println("\nParfait ! Maintenant, choisissez un heros : ");
            WarriorHero warrior = new WarriorHero();
            MageHero mage = new MageHero();

            System.out.println("1 - " + warrior);
            System.out.println("2 - " + mage + "\n");
            System.out.println("Numero de heros : ");

            int numHeros = scanner.nextInt();
            if (numHeros == 1) {
                joueur1 = warrior;
                logger.info("Heros Warrior selectionne.");
                System.out.println("Hero Warrior enregistre avec succes !");
            } else if (numHeros == 2) {
                joueur1 = mage;
                logger.info("Heros Mage selectionne.");
                System.out.println("Hero Mage enregistre avec succes !");
            } else {
                logger.warning("Choix invalide pour le heros.");
                System.out.println("Choix invalide. Veuillez reessayer.");
            }
        }
        System.out.println("------------------------------------------------------------\n");
        logger.info("Methode lancer() terminee avec succes.");
        System.out.println("------------------------------------------------------------\n");
        return new Object[]{plateauChoisi, joueur1};
    }

    /**
     * Methode principale pour gerer la progression du jeu. 
     * Elle place le joueur sur le plateau et execute les actions associees à chaque case.
     *
     * @param plateau Le plateau choisi par le joueur.
     * @param joueur1 Le heros choisi par le joueur.
     * @return void (retourne simplement si on le joueur a gagne ou perdu)
     */
    public static void commencerJeu(Plateau plateau, Hero joueur1) throws InterruptedException {

        logger.info("Debut de la methode commencerJeu()");

        Scanner scanner = new Scanner(System.in);
        int position = 0; // placement du joueur sur la case de depart 0

        // Boucle principale pour avancer à travers le plateau.
        while (position != plateau.getCases().size()-1) {

            // Verifier si la case deux cases plus loin existe
            if (position + 2 < plateau.getCases().size()) {

                Case futureCase = plateau.getCases().get(position + 2);
                int nombreBrigands = 0;
                for (Ennemi ennemi : futureCase.getEnnemis()) {
                    if (ennemi instanceof BrigandEnnemi) {
                        nombreBrigands++;
                    }
                }
                
                //si il y a au moins 1 brigand alors il tire
                if (nombreBrigands > 0) {
                    int pvPerdus = nombreBrigands * 2; // 1 brigand enleve 2 PV au Hero
                    joueur1.setPv(joueur1.getPv() - pvPerdus);

                    System.out.println("\nAttention ! " + nombreBrigands + " brigand(s) tirent sur vous depuis la case " + (position + 2) + " !");
                    System.out.println("Vous perdez " + pvPerdus + " PV. Il vous reste " + joueur1.getPv() + " PV.");

                    // Au cas ou le joueur est mort
                    if (joueur1.getPv() <= 0) {
                        logger.info("Le joueur est mort à cause des tirs des brigands.");
                        System.out.println("Vous etes mort à cause des tirs des brigands ! Fin du jeu.");
                        return;
                    }
                }
            }
            System.out.println("------------------------------------------------------------\n");

            Case currentCase = plateau.getCases().get(position); // case actuelle du joueur
            System.out.println("\nVous etes sur la " + currentCase);
            System.out.println("------------------------------------------------------------\n");
            // si c'est pas la case depart
            if (position != 0) {
                // Si il y a un bonus
                if (currentCase.getBonus() != null) {
                    System.out.println("Bonus de la case : " + currentCase.getBonus());
                    logger.info("Applique un bonus au joueur");

                    joueur1.useBonus(currentCase.getBonus());
                    Thread.sleep(1500); // attendre 1,5 secondes pour laisser du suspense !
                }

                // Si il y a des ennemis
                if (!currentCase.getEnnemis().isEmpty()) {
                    System.out.println("Vous etes attaque par un ennemis !");
                    for (Ennemi ennemi : currentCase.getEnnemis()) {
                        Thread.sleep(1500);
                        System.out.println("\nCombat contre : " + ennemi);
                        logger.info("Debut du combat contre un ennemi" + ennemi);

                        Combat combat = new Combat(joueur1, ennemi);
                        combat.lancerCombat();
                        // si il est mort alors c'est ciao
                        if (joueur1.isAlive() == false) {
                            logger.info("Le joueur est mort pendant un combat.");
                            System.out.println("Vous etes mort ! Fin du jeu.");
                            return;
                        }
                    }
                }
            }
            // Si la case est vide
            if (currentCase.getBonus() == null && currentCase.getEnnemis().isEmpty()) {
                System.out.println("La case est vide, vous avancez.");
            }
            System.out.println("------------------------------------------------------------\n");
            // Demandez au joueur s'il veut avancer ou arreter
            System.out.println("Bravo, vous avez reussi la case.\nQue voulez-vous faire ? (1: Avancer, 2: Arreter)");
            int choix = scanner.nextInt();
            if (choix == 2) {
                logger.info("Le joueur a choisi de quitter le jeu.");
                System.out.println("Vous avez quitte le jeu. A bientot !!");
                return;
            }

            position++;
        }

        Thread.sleep(1500);
        logger.info("Le joueur a atteint la fin du plateau, il a gagne");
        System.out.println("\nVous etes arrive à la fin du plateau et avez vaincu tous les ennemis !");
        Thread.sleep(1500);
        System.out.println("\nFelicitations ! Vous avez termine le plateau !");
    }
}