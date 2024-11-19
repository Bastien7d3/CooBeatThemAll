import Perso.Hero.Warrior.WarriorHero;
import Perso.Hero.Mage.MageHero;
import Perso.Ennemi.Brigand.BrigandEnnemi;
import Combat.Combat;
import Perso.Ennemi.Boss.BossEnnemi;

public class Main {
    public static void main(String[] args) {
        // Création des héros
        WarriorHero guerrier = new WarriorHero();
        MageHero mage = new MageHero();

        // Création des ennemis
        BrigandEnnemi brigand = new BrigandEnnemi();
        BossEnnemi boss = new BossEnnemi();

        // Scénario de combats
        System.out.println("==== Combat 1 : Guerrier VS Brigand ====");
        Combat combat1 = new Combat(guerrier, brigand);
        combat1.lancerCombat();

        System.out.println("\n==== Combat 2 : Mage VS Boss ====");
        Combat combat2 = new Combat(mage, boss);
        combat2.lancerCombat();

        // Refaire un combat entre survivants
        System.out.println("\n==== Combat 3 : Survivants ====");
        if (guerrier.isAlive() && boss.isAlive()) {
            Combat combat3 = new Combat(guerrier, boss);
            combat3.lancerCombat();
        } else if (mage.isAlive() && brigand.isAlive()) {
            Combat combat3 = new Combat(mage, brigand);
            combat3.lancerCombat();
        } else {
            System.out.println("Il n'y a pas assez de survivants pour un nouveau combat.");
        }
    }
}
