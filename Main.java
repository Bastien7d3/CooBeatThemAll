import Perso.Hero.Mage.MageHero;
import Perso.Hero.Warrior.WarriorHero;
import Perso.Ennemi.Brigand.BrigandEnnemi;
import Perso.Ennemi.Boss.BossEnnemi;

public class Main {
    public static void main(String[] args) {
        WarriorHero warrior = new WarriorHero();
        MageHero mage = new MageHero();
        BrigandEnnemi brigand = new BrigandEnnemi();
        BossEnnemi boss = new BossEnnemi();

        System.out.println(warrior);
        warrior.useUltimate();

        System.out.println(mage);
        mage.useUltimate();

        System.out.println(boss);
        boss.useUltimate();

        // Exemple de combat
        brigand.takeDamage(warrior.getAtt());
        System.out.println("Brigand after attack: " + brigand.getPv());

        boss.takeDamage(mage.getAtt());
        System.out.println("Boss after attack: " + boss.getPv());
    }
}