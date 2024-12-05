package imt.coo.beatthemall.Perso.Perso.Ennemi.Boss;

import imt.coo.beatthemall.Perso.Perso.PersoPuissant;
import imt.coo.beatthemall.Perso.Perso.Ennemi.Ennemi;

public class BossEnnemi extends Ennemi  implements PersoPuissant{
    public BossEnnemi() {
        super("Boss", 20, 50, 20, true, 70);
    }

    @Override
    public void useUltimate() {
        System.out.println(name + " uses Giga Impact!");
    }

}
