package Perso.Ennemi.Boss;

import Perso.Ennemi.Ennemi;

public class BossEnnemi extends Ennemi {
    public BossEnnemi() {
        super("Boss", 200, 50, 20, true);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Giga Impact!");
    }

}
