package imt.coo.beatthemall.Perso.Perso.Hero.Warrior;

import imt.coo.beatthemall.Perso.Perso.PersoPuissant;
import imt.coo.beatthemall.Perso.Perso.Hero.Hero;

/* Class de définiton des particularités du Warrior Hero */
public class WarriorHero extends Hero implements PersoPuissant {
    public WarriorHero() {
        super("Warrior Hero", 100, 30, 15, 50);
    }

    /*
         * Utilise son ulti pour booster son attaque
         */
    @Override
    public void useUltimate() {
        
        if (this.ulti) {
            System.out.println(name + " Boost son attaque !");
            this.att = this.att + 50;
            this.ulti = false;
        } else {
            System.out.println("l'ulti a déjà été utilisé");
        }
    }
}
