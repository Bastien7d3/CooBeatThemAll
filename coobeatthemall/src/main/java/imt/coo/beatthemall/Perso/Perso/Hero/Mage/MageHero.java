package imt.coo.beatthemall.Perso.Perso.Hero.Mage;

import imt.coo.beatthemall.Perso.Perso.PersoPuissant;
import imt.coo.beatthemall.Perso.Perso.Hero.Hero;

/* Class de définiton des particularités du Mage Hero */
public class MageHero extends Hero implements PersoPuissant {
    public MageHero() {
        super("Mage Hero", 80, 25, 10, 30);
    }

    /* Class de définiton des particularités du Warrior Hero */
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
