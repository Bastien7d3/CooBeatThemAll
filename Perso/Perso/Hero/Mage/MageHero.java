package Perso.Hero.Mage;

import Perso.PersoPuissant;
import Perso.Hero.Hero;

public class MageHero extends Hero  implements PersoPuissant{
    public MageHero() {
        super("Mage Hero", 80, 25, 10, 30);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Fireball!");
        // Utilise le pouvoir ultime pour infliger des dégâts bonus
    }
}
