package Perso.Ennemi.Brigand;

import Perso.Ennemi.Ennemi;

public class BrigandEnnemi extends Ennemi {
    public BrigandEnnemi() {
        super("Brigand", 60, 15, 5, false);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Sneak Attack!");
    }
}
