package imt.coo.beatthemall;

import java.io.File;
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

        // Vérifier et créer le répertoire "logs" si nécessaire
        File logDir = new File("logs");
        if (!logDir.exists()) {
            if (logDir.mkdirs()) {
                System.out.println("Répertoire 'logs' créé avec succès !");
            } else {
                System.err.println("Échec de la création du répertoire 'logs'.");
            }
        }

        // Charger le fichier de configuration de logs
        try {
            LogManager.getLogManager().readConfiguration(
                Main.class.getClassLoader().getResourceAsStream("logging.properties")
            );
            System.out.println("Configuration des logs chargée avec succès !");
        } catch (IOException | NullPointerException e) {
            System.err.println("Erreur de chargement du fichier logging.properties : " + e.getMessage());
        }

        // Exemple de log
        Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());
        logger.info("Début du jeu");
    

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
