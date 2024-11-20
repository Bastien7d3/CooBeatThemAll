import Perso.Hero.Hero;
import Perso.Hero.Mage.MageHero;
import Perso.Hero.Warrior.WarriorHero;
import Perso.Hero.Mage.MageHero;
import Perso.Ennemi.Brigand.BrigandEnnemi;
import Combat.Combat;
import Perso.Ennemi.Boss.BossEnnemi;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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
