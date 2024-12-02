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

    public void useBonus(String bonus){
        if (bonus == "soin") {
            this.att = this.pv + 25;
        } if (bonus == "attaque") {
            this.att = this.att + 10;
        }else {
            System.out.println("Erreur, bonus incompatible");
        }
    }
}
