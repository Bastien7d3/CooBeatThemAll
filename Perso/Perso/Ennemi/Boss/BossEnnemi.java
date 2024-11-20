package Perso.Ennemi.Boss;

import Perso.PersoPuissant;
import Perso.Ennemi.Ennemi;

public class BossEnnemi extends Ennemi  implements PersoPuissant{
    public BossEnnemi() {
        super("Boss", 200, 50, 20, true, 70);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Giga Impact!");
    }

}
