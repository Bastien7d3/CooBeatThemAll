package imt.coo.beatthemall;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import imt.coo.beatthemall.Perso.Perso.Hero.Hero;
import imt.coo.beatthemall.Carte.Plateau;
import imt.coo.beatthemall.Jeu.Jeu;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        // Charger le fichier de configuration
        try (FileInputStream configFile = new FileInputStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(configFile);
        } catch (IOException e) {
            System.err.println("Erreur de chargement du fichier logging.properties : " + e.getMessage());
        }

        logger.info("début du jeu");

        System.out.println("\nDéveloppeur: Brunel Bastien et Beaurepaire Paul\n");

        Object[] resultat = Jeu.lancer();

        Plateau plateau = (Plateau) resultat[0];
        Hero joueur1 = (Hero) resultat[1];

        System.out.println("\nLe jeu commence avec le plateau suivant : \n");
        System.out.println(plateau);
        System.out.println("Le héros choisi est : " + joueur1);

        System.out.println("\n-------------------- La partie commence --------------------\n");
        System.out.println("\nA vous de jouer !\n");
        Jeu.commencerJeu(plateau, joueur1);

    }
}
