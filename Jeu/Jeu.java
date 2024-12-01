import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Combat.Combat;
import Perso.Hero.Hero;
import Perso.Hero.Mage.MageHero;
import Perso.Hero.Warrior.WarriorHero;
import Perso.Ennemi.Brigand.BrigandEnnemi;
import Perso.Ennemi.Ennemi;
import Perso.Ennemi.Boss.BossEnnemi;

public class Jeu {

    public static Object[] lancer() {

        System.out.println("\nBonjour et bienvenue sur le jeu de CooBeatThemAll !\n");
        System.out.println("CooBeatThemAll est un mini-jeu de combat en Java, dans lequel des héros affrontent divers ennemis. Ce projet illustre une architecture orientée objet avec des concepts tels que l'héritage, les classes abstraites et le polymorphisme. Chaque personnage possède ses propres attributs et compétences spécifiques, ce qui permet d'expérimenter différentes stratégies de combat.\n");
        System.out.println("Pour commencer, veuillez choisir un numéro de plateau :\n");

        // création 3 plateaux
        Plateau plateau10 = new Plateau(1, "Petit plateau (10 cases)", 10);
        Plateau plateau15 = new Plateau(2, "Moyen plateau (15 cases)", 15);
        Plateau plateau20 = new Plateau(3, "Grand plateau (20 cases)", 20);

        // cases prédéfinies
        ArrayList<Case> casesPredefinies = new ArrayList<>();
        casesPredefinies.add(new Case(1, "Bonus de soin", new ArrayList<>()));
        casesPredefinies.add(new Case(2, "Bonus d'attaque", new ArrayList<>()));
        casesPredefinies.add(new Case(4, "Pas de bonus", new ArrayList<>(List.of(new BrigandEnnemi()))));
        casesPredefinies.add(new Case(5, "Pas de bonus", new ArrayList<>(List.of(new BossEnnemi()))));

        Plateau plateauChoisi = null;
        Scanner scanner = new Scanner(System.in);

        while (plateauChoisi == null) {
            System.out.println("1 - " + plateau10);
            System.out.println("2 - " + plateau15);
            System.out.println("3 - " + plateau20);
            System.out.println("Numéro du plateau : ");

            int numPlateau = scanner.nextInt();
            if (numPlateau == 1) {
                plateau10.genererCasesAleatoires(casesPredefinies);
                plateauChoisi = plateau10;
                System.out.println("Petit plateau enregistré avec succès !");
            } else if (numPlateau == 2) {
                plateau15.genererCasesAleatoires(casesPredefinies);
                plateauChoisi = plateau15;
                System.out.println("Moyen plateau enregistré avec succès !");
            } else if (numPlateau == 3) {
                plateau20.genererCasesAleatoires(casesPredefinies);
                plateauChoisi = plateau20;
                System.out.println("Grand plateau enregistré avec succès !");
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.\n");
            }
        }

        // création des héros
        Hero joueur1 = null;
        while (joueur1 == null) {
            System.out.println("\nParfait ! Maintenant, choisissez un héros : ");
            WarriorHero warrior = new WarriorHero();
            MageHero mage = new MageHero();

            System.out.println("1 - " + warrior);
            System.out.println("2 - " + mage + "\n");
            System.out.println("Numéro de héros : ");

            int numHeros = scanner.nextInt();
            if (numHeros == 1) {
                joueur1 = warrior;
                System.out.println("Héro Warrior enregistré avec succès !");
            } else if (numHeros == 2) {
                joueur1 = mage;
                System.out.println("Héro Mage enregistré avec succès !");
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        return new Object[]{plateauChoisi, joueur1};
    }

    public static void commencerJeu(Plateau plateau, Hero joueur1) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int position = 0; // placement du joueur sur la case de départ 0

        while (position != plateau.getCases().size()-1) {

            // Vérifier si la case deux cases plus loin existe
            if (position + 2 < plateau.getCases().size()) {

                Case futureCase = plateau.getCases().get(position + 2);
                int nombreBrigands = 0;
                for (Ennemi ennemi : futureCase.getEnnemis()) {
                    if (ennemi instanceof BrigandEnnemi) {
                        nombreBrigands++;
                    }
                }
                
                //si il y a au moins 1 brigand
                if (nombreBrigands > 0) {
                    int pvPerdus = nombreBrigands * 2; // 1 brigand enleve  PV au Hero
                    joueur1.setPv(joueur1.getPv() - pvPerdus);

                    System.out.println("\nAttention ! " + nombreBrigands + " brigand(s) tirent sur vous depuis la case " + (position + 2) + " !");
                    System.out.println("Vous perdez " + pvPerdus + " PV. Il vous reste " + joueur1.getPv() + " PV.");

                    // Au cas ou le joueur est mort
                    if (joueur1.getPv() <= 0) {
                        System.out.println("Vous êtes mort à cause des tirs des brigands ! Fin du jeu.");
                        return;
                    }
                }
            }


            Case currentCase = plateau.getCases().get(position); // case actuelle du joueur
            System.out.println("\nVous êtes sur la " + currentCase);

            // si c'est pas la case départ
            if (position != 0) {
                // Si il y a un bonus
                if (currentCase.getBonus() != null) {
                    System.out.println("Bonus de la case : " + currentCase.getBonus());

                    // TODO : faire la méthode pour appliquer les bonus
                    //joueur1.appliquerBonus(currentCase.getBonus());
                    Thread.sleep(1500); // attendre 1,5 secondes pour laisser du suspense !
                }

                // Si il y a des ennemis
                if (!currentCase.getEnnemis().isEmpty()) {
                    System.out.println("Vous êtes attaqué par un ennemis !");
                    for (Ennemi ennemi : currentCase.getEnnemis()) {
                        Thread.sleep(1500);
                        System.out.println("\nCombat contre : " + ennemi);
                        Combat combat = new Combat(joueur1, ennemi);
                        combat.lancerCombat();
                        // si il est mort alors c'est ciao
                        if (joueur1.isAlive() == false) {
                            System.out.println("Vous êtes mort ! Fin du jeu.");
                            return;
                        }
                    }
                }
            }

            // Si la case est vide
            if (currentCase.getBonus() == null && currentCase.getEnnemis().isEmpty()) {
                System.out.println("La case est vide, vous avancez.");
            }

            // Demandez au joueur s'il veut avancer ou arrêter
            System.out.println("\n----------------------------------------\n");
            System.out.println("Bravo, vous avez réussi la case.\nQue voulez-vous faire ? (1: Avancer, 2: Arrêter)");
            int choix = scanner.nextInt();
            if (choix == 2) {
                System.out.println("Vous avez quitté le jeu. A bientot !!");
                return;
            }

            position++;
        }

        Thread.sleep(1500);
        System.out.println("\nVous êtes arrivé à la fin du plateau et avez vaincu tous les ennemis !");
        Thread.sleep(1500);
        System.out.println("\nFélicitations ! Vous avez terminé le plateau !");
    }
}