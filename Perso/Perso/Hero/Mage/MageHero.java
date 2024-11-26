package Perso.Hero.Mage;

import Perso.PersoPuissant;
import Perso.Hero.Hero;

public class MageHero extends Hero  implements PersoPuissant{
    public MageHero() {
        super("Mage Hero", 80, 25, 10, 30);
    }

    @Override
    public void useUltimate() {
        if (this.ulti) {
            System.out.println(name + " Boost ses PV !");
        this.pv = this.pv + 50;
        this.ulti = false;
        } else {
            System.out.println("l'ulti a déjà été utilisé");
        }
    }
}
