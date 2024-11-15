package Perso.Hero.Mage;

import Perso.Hero.Hero;

public class MageHero extends Hero {
    public MageHero() {
        super("Mage Hero", 80, 25, 10);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Fireball!");
        // Utilise le pouvoir ultime pour infliger des dégâts bonus
    }
}
