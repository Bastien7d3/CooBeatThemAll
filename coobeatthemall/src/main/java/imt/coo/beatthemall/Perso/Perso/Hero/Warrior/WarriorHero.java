package Perso.Hero.Warrior;

import Perso.PersoPuissant;
import Perso.Hero.Hero;

public class WarriorHero extends Hero implements PersoPuissant{
    public WarriorHero() {
        super("Warrior Hero", 100, 30, 15, 50);
    }

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
