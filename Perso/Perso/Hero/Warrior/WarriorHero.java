package Perso.Hero.Warrior;

import Perso.PersoPuissant;
import Perso.Hero.Hero;

public class WarriorHero extends Hero implements PersoPuissant{
    public WarriorHero() {
        super("Warrior Hero", 100, 30, 15);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Power Strike!");
        // Utilise le pouvoir ultime pour infliger des dégâts bonus
    }
}
