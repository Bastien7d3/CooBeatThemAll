package Perso.Hero.Warrior;

import Perso.Hero.Hero;

public class WarriorHero extends Hero {
    public WarriorHero() {
        super("Warrior Hero", 100, 30, 15);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Power Strike!");
        // Utilise le pouvoir ultime pour infliger des dégâts bonus
    }
}
