package Combat;

import java.util.Random;

import Perso.Perso;

public class Combat {
    private Perso joueur1;
    private Perso joueur2;

    // Constructeur
    public Combat(Perso joueur1, Perso joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    // Méthode pour lancer le combat
    public void lancerCombat() {
        
        
        System.out.println("Le combat commence entre " + joueur1.getName() + " et " + joueur2.getName() + " !");
        Perso premier;
        Perso second ;
        // Déterminer l'ordre des attaques
        if (joueur1.getVitesse() >= joueur2.getVitesse()) {
            premier = joueur1;
            second = joueur2;
        }else{
            premier = joueur2;
            second = joueur1;
        }

        System.out.println(premier.getName() + " attaque en premier grâce à sa vitesse supérieure !");
        
        // Boucle de combat
        while (joueur1.isAlive() && joueur2.isAlive()) {
            // Tour du premier attaquant
            effectuerAttaque(premier, second);
            if (!second.isAlive()) {
                System.out.println(second.getName() + " est mort !");
                break;
            }

            // Tour du second attaquant
            effectuerAttaque(second, premier);
            if (!premier.isAlive()) {
                System.out.println(premier.getName() + " est mort !");
                break;
            }
        }

        // Annonce du gagnant
        if (joueur1.isAlive()) {
            System.out.println(joueur1.getName() + " remporte le combat !");
        } else {
            System.out.println(joueur2.getName() + " remporte le combat !");
        }
    }

    // Méthode pour effectuer une attaque
    private void effectuerAttaque(Perso attaquant, Perso defenseur) {
        int degats = calculerDegats(attaquant, defenseur);
        defenseur.takeDamage(degats);

        System.out.println(attaquant.getName() + " attaque " + defenseur.getName() + " et inflige " + degats + " points de dégâts !");
        System.out.println(defenseur.getName() + " a maintenant " + defenseur.getPv() + " PV.");
    }

    // Méthode avancée pour calculer les dégâts
    private int calculerDegats(Perso attaquant, Perso defenseur) {
        Random random = new Random();

        // Calcul de la base avec les statistiques existantes
        double base = attaquant.getAtt() * 1.2;

        // Facteur critique (entre 1.0x et 1.5x)
        double critique = base * (1 + random.nextDouble() * 0.5);

        // Réduction des dégâts par la défense
        double reduction = defenseur.getDef() * 0.5;

        // Calcul final des dégâts
        int degats = (int) Math.max(critique - reduction, 1);

        // Limiter les dégâts à la vie restante du défenseur
        return Math.min(degats, defenseur.getPv());
    }
}
